#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
# Binary insertion sort
#
# Sourcecode: https://github.com/fbcom/MIT-6006-Algorithims
# Lecture notes: http://courses.csail.mit.edu/6.006/fall11/notes.shtml


def binary_insertion_sort(array):
    for i in range(1, len(array)):
        insert = array[i]
        pos = binary_search_position(array[:i], insert)
        j = i
        while j > pos:
            array[j] = array[j-1]
            j = j - 1
        array[j] = insert


def binary_search_position(array, value):
    left = 0
    right = len(array)-1
    while right-left >= 0:
        middle = left + (right - left + 1) / 2
        if array[middle] > value:
            right = middle - 1
        elif array[middle] < value:
            left = middle + 1
        else:
            return middle
    return left

# Testrun
array = [8, 2, 4, 9, 3, 6]
print "Unsorted:", array

binary_insertion_sort(array)
print "Sorted  :", array
