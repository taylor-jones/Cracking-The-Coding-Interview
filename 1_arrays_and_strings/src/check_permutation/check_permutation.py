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
A = 'care'
B = 'race'
C = 'car'
D = 'acre'

print(A + "\t|\t" + A + "\t|\t" + str(is_permutation(A, A)))
print(A + "\t|\t" + B + "\t|\t" + str(is_permutation(A, B)))
print(A + "\t|\t" + C + "\t|\t" + str(is_permutation(A, C)))
print(A + "\t|\t" + D + "\t|\t" + str(is_permutation(A, D)))
print(B + "\t|\t" + D + "\t|\t" + str(is_permutation(B, D)))
