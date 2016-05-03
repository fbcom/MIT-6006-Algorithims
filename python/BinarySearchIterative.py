#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
# Iterative binary search
#
# Sourcecode: https://github.com/fbcom/MIT-6006-Algorithims
# Lecture notes: http://courses.csail.mit.edu/6.006/fall11/notes.shtml


def binary_search_iterative(array, value):
    left = 0
    right = len(array)-1
    while right-left >= 0:
        middle = left + (right - left + 1) / 2
        if array[middle] > value:
            right = middle - 1
        elif array[middle] < value:
            left = middle + 1
        else:
            return middle  # found value in array at this position
    return None  # not found

# Testrun

array = [2, 3, 4, 6, 8, 9]
print "Array:", array
for i, value in enumerate(array + [999]):
    index = binary_search_iterative(array, value)
    if value in array:
        assert index == i, "Assertion failed"
    if index != None:
        print "%d found at index %d" % (value, index)
    else:
        print "%d was not found" % (value)
