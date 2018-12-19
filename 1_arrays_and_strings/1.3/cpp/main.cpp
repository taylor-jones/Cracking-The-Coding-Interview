#include <iostream>
#include <string>
#include <algorithm>

using namespace std;


/**
 * Sorts the contents of a string alphabetically
 */
string sorted(string s) {
  sort(s.begin(), s.end());
  return s;
}


/**
 * Question: 1.3
 * Description: Given two strings, write a method to decide if one is a permutation of the other.
 * Solution: The strings must pass two inspections to be considered a permutation of each other:
 *  1) They should be the same length.
 *  2) Their sorted contents should be equal. 
 * 
 * @param s1 - string
 * @param s2 - string
 * @return bool
 */
bool isPermutation(string s1, string s2) {
  if (s1.length() != s2.length()) {
    return false;
  }

  return sorted(s1) == sorted(s2);
}



int main() {
  cout << isPermutation("care", "race") << endl;              // true
  cout << isPermutation("care", "rack") << endl;              // false
  cout << isPermutation("care", "care") << endl;              // true
  cout << isPermutation("care", "care stop") << endl;         // false
  cout << isPermutation("race stop", "care pots") << endl;    // true
  cout << isPermutation("care", "car") << endl;               // false

  return 0;
}