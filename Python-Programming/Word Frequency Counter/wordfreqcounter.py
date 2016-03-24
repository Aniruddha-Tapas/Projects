import requests
from bs4 import BeautifulSoup
import operator

def start(url):
    word_list = []
    source_code = requests.get(url).text
    soup = BeautifulSoup(source_code, "html.parser")
    for post_text in soup.findAll('div', {'class': 'head'}):
        content = post_text.get_text()
        words = content.lower().split()
        for each_word in words:
            word_list.append(each_word)
    clean_up_list(word_list)

def clean_up_list(word_list):
    clean_word_list = []
    for word in word_list:
        symbols = "!@#$%^&*()_+{}:\"<>?,./;'[]-='"
        for i in range(0,len(symbols)):
            word= word.replace(symbols[i],"")
        if len(word) > 0:
            print(word)
            clean_word_list.append(word)
    create_dictionary(clean_word_list)

def create_dictionary(clean_word_list):
    word_count = {}
    for word in clean_word_list:
        if word in word_count:
            word_count[word] +=1
        else:
            word_count[word] = 1
        for key,value in sorted(word_count.items(), key=operator.itemgetter(1)):
            print(key,value)

start('http://www.snapdeal.com/product/apple-macbook-pro-13-inch/199160/reviews?page=5')

