"""
Question: 1.2
Description: Given two strings, write a method to decide if one is a permutation of the other.
"""


def is_permutation(s1, s2):
    """
    Solution: The strings must pass two inspections to be considered a permutation of each other:
      1) They should be the same length.
      2) Their sorted contents should be equal.
    """
    if len(s1) != len(s2):
        return False

    return ''.join(sorted(s1)) == ''.join(sorted(s2))


#
# Examples
#
print(is_permutation('care', 'race'))         # True
print(is_permutation('care', 'rack'))         # False
print(is_permutation('care', 'care'))         # True
print(is_permutation('care', 'care bear'))    # False
print(is_permutation('care', 'car'))          # False
