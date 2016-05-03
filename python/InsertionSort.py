#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
# Insertion sort
#
# Sourcecode: https://github.com/fbcom/MIT-6006-Algorithims
# Lecture notes: http://courses.csail.mit.edu/6.006/fall11/notes.shtml

def insertion_sort(array):
    for i in range(1, len(array)):
        insert = array[i]
        j = i
        while j>0 and array[j-1] > insert:
            array[j] = array[j-1]
            j = j - 1
        array[j] = insert

# Testrun

array = [8,2,4,9,3,6]
print "Unsorted:", array

insertion_sort(array)
print "Sorted  :", array
