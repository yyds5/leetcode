"""
Given an array, rotate the array to the right by k steps, where k is non-negative number
Time Compexity O(N)
"""

def rotate(N, k):
    l = len(N)
    k = k % l
    for i in range(l//2):
        N[~i], N[i] = N[i], N[~i]
    for i in range(k//2):
        N[i], N[k-i-1] = N[k-i-1], N[i]
    for i in range((l-k)//2):
        N[k+i], N[l-i-1] = N[l-i-1], N[k+i]
    return N


n_array = [1, 2, 3, 4, 5, 6, 7]
print(rotate(n_array, 4))
