"""
 Question: 1.3
 Name: URLify
 Description: Write a method to replace all spaces in a string with '%20'. You may assume that    the string has sufficient space at the end of the string to hold the additional characters,     and that you are given the 'true' length of the string.
"""

def urlify(s):
    return s.replace(' ', '%20')


print(urlify('Hootie And The Blowfish'))
