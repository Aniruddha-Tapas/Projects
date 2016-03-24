# sentiment analysis algorithm.

"""
To do this, we're going to start by trying to use the movie reviews database that is part of the NLTK corpus.
From there we'll try to use words as "features" which are a part of either a positive or negative movie review.
The NLTK corpus movie_reviews data set has the reviews, and they are labeled already as positive or negative.
This means we can train using this data.

"""

import nltk
import random
from nltk.corpus import movie_reviews

import pickle  # using pickle to stor our serialized objects of our training of classifier for subsequent future uses
#from nltk.classify.scikitlearn import SklearnClassifier  # Incorporating sklearn with nltk

# **Tokenizing sentences and words**
from nltk.tokenize import sent_tokenize, word_tokenize
from sklearn.naive_bayes import MultinomialNB, GaussianNB, BernoulliNB  # Naive Bayes algorithms within sklearn

# for analyzing accuracies of different classifying algos
#from sklearn.linear_model import LogisticRegression, SGDClassifier
#from sklearn.svm import SVC, LinearSVC, NuSVC
# Algorithms of Algorithms
#from nltk.classify import ClassifierI
from statistics import mode

# First,Exploring our data:
# list of all words in movie reviews dataset according to its respective documents and category
"""
In each category (we have pos or neg), take all of the file IDs (each review has its own ID),
then store the word_tokenized version (a list of words) for the file ID,
followed by the positive or negative label in one big list.
"""
documents = [(list(movie_reviews.words(fileid)), category)
             for category in movie_reviews.categories()
             for fileid in movie_reviews.fileids(category)]

reviews = open("reviews.txt","r")

# Shuffling our training and test sets so that they don't overlap
random.shuffle(documents)

# print(documents[1])

# movie review words
all_words = []
for w in movie_reviews.words():
    all_words.append(w.lower())

all_words = nltk.FreqDist(all_words)  # Frequency distribution of all words
# print(all_words.most_common(15))
# print(all_words["stupid"])

# Feature list that contains top 3000 words
word_features = list(all_words.keys())[:3000]


# function that will find these top 3,000 words in our positive and negative documents,
# marking their presence as either positive or negative:
def find_features(document):
    words = set(document)
    features = {}
    for w in word_features:
        features[w] = (w in words)

    return features


# Printing 1 feature set
# print((find_features(movie_reviews.words('neg/cv000_29416.txt'))))
# Then we can do this for all of our documents,
# saving the feature existence booleans and their respective positive or negative categories by doing:
featuresets = [(find_features(rev), category) for (rev, category) in documents]

# set that we'll train our Naive Bayes classifier with
training_set = featuresets[:1900]
# set that we'll test against.
testing_set = featuresets[1900:]


# Training our Naive Bayes classifier
classifier = nltk.NaiveBayesClassifier.train(training_set)

"""
Opening and using our classifier
The .pickle file is a serialized object,
all we need to do now is read it into memory,
which will be about as quick as reading any other ordinary file.
"""

classifier_f = open("naivebayes.pickle", "rb")
classifier = pickle.load(classifier_f)
classifier_f.close()

"""
We open the file to read as bytes.
Then, we use pickle.load() to load the file, and we save the data to the classifier variable.
Then we close the file, and that is that. We now have the same classifier object as before!
Now, we can use this object, and we no longer need to train our classifier every time we wanted to use it to classify.
"""

# Original Naive Bayes Algo (within nltk)
print("Classifier accuracy percent:", (nltk.classify.accuracy(classifier, testing_set)) * 100)

# what the most valuable words are when it comes to positive or negative reviews:
classifier.show_most_informative_features(15)

"""
# **Saving our classifier using Pickle**
save_classifier = open("naivebayes.pickle","wb")
pickle.dump(classifier, save_classifier)
save_classifier.close()
"""

"""
This opens up a pickle file, preparing to write in bytes some data.
Then, we use pickle.dump() to dump the data.
The first parameter to pickle.dump() is what are you dumping, the second parameter is where are you dumping it.

After that, we close the file as we're supposed to, and that is that,
we now have a pickled, or serialized, object saved in our script's directory!

"""

"""
# Using SKlearnClassifier

# MultinomialNB
MNB_classifier = SklearnClassifier(MultinomialNB())
MNB_classifier.train(training_set)
print("MultinomialNB accuracy percent:", nltk.classify.accuracy(MNB_classifier, testing_set))

# BernoulliNB
BNB_classifier = SklearnClassifier(BernoulliNB())
BNB_classifier.train(training_set)
print("BernoulliNB accuracy percent:", nltk.classify.accuracy(BNB_classifier, testing_set))

from sklearn.linear_model import LogisticRegression, SGDClassifier
from sklearn.svm import SVC, LinearSVC, NuSVC

# Logistic Regression
LogisticRegression_classifier = SklearnClassifier(LogisticRegression())
LogisticRegression_classifier.train(training_set)
print("LogisticRegression_classifier accuracy percent:",
      (nltk.classify.accuracy(LogisticRegression_classifier, testing_set)) * 100)

# Stochastic Gradient Descent
SGDClassifier_classifier = SklearnClassifier(SGDClassifier())
SGDClassifier_classifier.train(training_set)
print("SGDClassifier_classifier accuracy percent:",
      (nltk.classify.accuracy(SGDClassifier_classifier, testing_set)) * 100)

# SVC
SVC_classifier = SklearnClassifier(SVC())
SVC_classifier.train(training_set)
print("SVC_classifier accuracy percent:", (nltk.classify.accuracy(SVC_classifier, testing_set)) * 100)

# LinearSVC
LinearSVC_classifier = SklearnClassifier(LinearSVC())
LinearSVC_classifier.train(training_set)
print("LinearSVC_classifier accuracy percent:", (nltk.classify.accuracy(LinearSVC_classifier, testing_set)) * 100)

# NuSVC
NuSVC_classifier = SklearnClassifier(NuSVC())
NuSVC_classifier.train(training_set)
print("NuSVC_classifier accuracy percent:", (nltk.classify.accuracy(NuSVC_classifier, testing_set)) * 100)
"""


"""
Combining classifier algorithms is is a common technique, done by creating a sort of voting system,
where each algorithm gets one vote,
and the classification that has the votes votes is the chosen one.

To do this, we want our new classifier to act like a typical NLTK classifier, with all of the methods.
Simple enough, using object oriented programming, we can just be sure to inherit from the NLTK classifier class.
"""


class VoteClassifier(ClassifierI):
    def __init__(self, *classifiers):  # passing a list of classifiers as params
        self._classifiers = classifiers  # assigning the list of classifiers that are passed to our class to self._classifiers.

    def classify(self, features):
        votes = []
        for c in self._classifiers:
            v = c.classify(features)  # classify based on the features
            votes.append(v)
        return mode(votes)  # highest values of votes

    """
    All we're doing here is iterating through our list of classifier objects.
    Then, for each one, we ask it to classify based on the features.
    The classification is being treated as a vote.
     After we are done iterating, we then return the mode(votes), which is just returning the most popular vote.

    This is all we really need, but it would be useful to have another parameter, confidence.
    Since we have algorithms voting, we can also tally the votes for and against the winning vote, and call this "confidence."
    For example, 3/5 votes for positive is weaker than 5/5 votes.
    As such, we can literally return the ratio of votes as a sort of confidence indicator:
    """

    def confidence(self, features):
        votes = []
        for c in self._classifiers:
            v = c.classify(features)
            votes.append(v)

        choice_votes = votes.count(mode(votes))  # how many occurences of most probable votes in the list
        conf = choice_votes / len(votes)  # certainty of votes
        return conf


# our classifier
voted_classifier = VoteClassifier(classifier,
                                  #NuSVC_classifier,
                                  #LinearSVC_classifier,
                                  #SGDClassifier_classifier,
                                  #MNB_classifier,
                                  #BNB_classifier,
                                  #LogisticRegression_classifier
								  )

#print("voted_classifier accuracy percent:", (nltk.classify.accuracy(voted_classifier, testing_set)) * 100)

"""
print("Classification:", voted_classifier.classify(testing_set[0][0]), "Confidence %:",
      voted_classifier.confidence(testing_set[0][0]) * 100)
print("Classification:", voted_classifier.classify(testing_set[1][0]), "Confidence %:",
      voted_classifier.confidence(testing_set[1][0]) * 100)
print("Classification:", voted_classifier.classify(testing_set[2][0]), "Confidence %:",
      voted_classifier.confidence(testing_set[2][0]) * 100)
print("Classification:", voted_classifier.classify(testing_set[3][0]), "Confidence %:",
      voted_classifier.confidence(testing_set[3][0]) * 100)
print("Classification:", voted_classifier.classify(testing_set[4][0]), "Confidence %:",
      voted_classifier.confidence(testing_set[4][0]) * 100)
print("Classification:", voted_classifier.classify(testing_set[5][0]), "Confidence %:",
      voted_classifier.confidence(testing_set[5][0]) * 100)
"""


def sentiment(text):
    feats = find_features(text)
    return voted_classifier.classify(feats),voted_classifier.confidence(feats)
"""
print(sentiment("This movie was awesome!"
                  " The acting was great, plot was wonderful, and there were pythons."
                  "..so yea!"))

print(sentiment("This movie was utter junk."
                  " There were absolutely 0 pythons."
                  " I don't see what the point was at all."
                  " Horrible movie, 0/10"))
"""

print(sentiment(reviews))
