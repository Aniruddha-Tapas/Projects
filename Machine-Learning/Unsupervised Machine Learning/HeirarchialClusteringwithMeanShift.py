import numpy as np
from sklearn.cluster import MeanShift
from sklearn.datasets.samples_generator import make_blobs
import matplotlib.pyplot as plt

# centers = [[1,1],[5,5]]  # centre points
centers = [[1, 1], [5, 5], [3, 10]]

X, y = make_blobs(n_samples=500, centers=centers, cluster_std=1)  # limit for n_samples is 10000
# cluster_std : Standard deviation. Lesser it is more accurate is the clustering

plt.scatter(X[:, 0], X[:, 1])
plt.show()

ms = MeanShift()
ms.fit(X)
# Fitting using MeanShift
labels = ms.labels_  # Labelling by the machine
cluster_centers = ms.cluster_centers_  # estimated centres
print(cluster_centers)
# *higher the sample no and lower the standard deviation, more accuate are the cluster_centers

n_clusters_ = len(np.unique(labels))  # unique : how many unique variables are there
# how many clusters are returned

print("No of estimated clusters: ", n_clusters_)

colors = 10 * ['r.', 'g.', 'b.', 'c.', 'k.', 'y.', 'm.']

print(colors)
print(labels)

for i in range(len(X)):
    plt.plot(X[i][0], X[i][1], colors[labels[i]], markersize=10)

plt.scatter(cluster_centers[:, 0], cluster_centers[:, 1],
            marker="x", s=150, linewidths=5, zorder=10)
plt.show()
