"""
Question: 1.1
Description: Implement an algorithm to determine if a string has all unique characters.
"""


def is_unique(in_string):
    """
    Uses a dictionary to track which characters have already been seen. 
    Then, If a character is found that is already in the dictionary, 
    the string is not unique.

    Runtime: O(n)
    """
    char_map = {}
    chars = list(in_string)
    for char in chars:
        if char_map.get(char):
            return False
        char_map[char] = True
    return True



def is_unique2(in_string):
    """
    Uses a set to distinguish the unique characters in the string.
    Then compares the length of the set to the length of the original string
    to determine if any characters were removed.

    Runtime: O(n), since this is the worst-case for the set implementation.
    """
    uniques = set(in_string)
    return len(uniques) == len(in_string)



#
# Examples
#
print(is_unique('foo'))   # false
print(is_unique('bar'))   # true
print()                   # just for readability

print(is_unique2('foo'))  # false
print(is_unique2('bar'))  # true
print()                   # just for readability
