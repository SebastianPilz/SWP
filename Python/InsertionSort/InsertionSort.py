'''
Created on 8 Jan 2019

@author: SebastianPilz
'''

def InsertionSort(A):
    for i in range(1, len(A)):
        h = A[i]
        j = i - 1
        while j >= 0 and A[j] > h:
            A[j + 1] = A[j]
            j = j - 1
        A[j + 1] = h

A = [4, 2, 3, 1]
InsertionSort(A)
print(A)