#!/usr/bin/env python
# -*- coding: utf-8 -*-
#
# Recursive binary search
#
# Sourcecode: https://github.com/fbcom/MIT-6006-Algorithims
# Lecture notes: http://courses.csail.mit.edu/6.006/fall11/notes.shtml


def binary_search_recursive(array, value):
    if len(array) == 0:
        return None

    if len(array) == 1:
        return 0 if array[0] == value else None

    m = len(array)/2
    if array[m] > value:
        return binary_search_recursive(array[:m], value)
    elif array[m] < value:
        index = binary_search_recursive(array[m:], value)
        return m + index if index != None else None
    return m

# Testrun

array = [2, 3, 4, 6, 8, 9]
print "Array:", array
for i, value in enumerate(array + [999]):
    index = binary_search_recursive(array, value)
    if value in array:
        assert index == i, "Assertion failed"
    if index != None:
        print "%d found at index %d" % (value, index)
    else:
        print "%d was not found" % (value)
