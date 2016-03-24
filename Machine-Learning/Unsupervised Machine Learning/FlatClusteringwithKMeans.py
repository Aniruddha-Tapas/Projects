import numpy as np
import matplotlib.pyplot as plt
from matplotlib import style

style.use("ggplot")

from sklearn.cluster import KMeans  # Use MiniBatchKMeans when there are > 1000 data points

# x = [1, 5, 1.5, 8, 1, 9]
# y = [2, 8, 1.8, 8, 0.6, 11]
#
# plt.scatter(x,y)
# plt.show()

X = np.array([[1, 2],
              [5, 8],
              [1.5, 1.8],
              [8, 8],
              [1, 0.6],
              [9, 11]])

# kmeans = KMeans(n_clusters=2)
# kmeans = KMeans(n_clusters=3)
kmeans = KMeans(n_clusters=4)

kmeans.fit(X)  # Fitting using KMeans

centroids = kmeans.cluster_centers_  # Centroids of the Cluster
labels = kmeans.labels_  # Labelling

print(centroids)
print(labels)

# Visualizing the clustering

# colors = ["g.","r."]
# colors = ["g.","r.","c."]
colors = ["g.", "r.", "c.", "y."]

for i in range(len(X)):
    print("coordinate:", X[i], "label:", labels[i])
    plt.plot(X[i][0], X[i][1], colors[labels[i]], markersize=10)  # X[1][0] = 1, X[1][1] = 2

plt.scatter(centroids[:, 0], centroids[:, 1], marker="x", s=150, linewidths=5, zorder=10)

plt.show()
