/**
 * Question: 1.1
 * Name: Is Unique
 * Description: Implement an algorithm to determine if a string has all unique characters.
 */

#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;


/**
 * Helper function that takes a string and splits it into a vector of characters
 */
vector<char> toVector(string s) {
  return vector<char> (s.begin(), s.end());
}


/**
 * Solution: Use a hash map to keep track of which characters have been encountered. At any
 *  point, if a character already exists in the hash map, the string does not have all 
 *  unique characters. If each character in the string is inspected before any duplicates
 *  are found, the string has all unique characters. 
 * Runtime - O(n)
 * 
 * @param s - string
 * @return bool
 */
bool isUnique(string s) {
  map<char, bool> charMap;
  vector<char> chars = toVector(s);

  for (int i = 0; i < chars.size(); i++) {
    if (charMap.find(chars[i]) != charMap.end()) {
      return false;
    }

    charMap[chars[i]] = true;
  }

  return true;
}



/**
 * Variation: Don't use any additional data structures.
 * Solution: Create a boolean array that is the length of the # of possible ASCII characters
 *  (each value set to FALSE by default). Whenever a character is encountered, the value at
 *  that index is set to TRUE. If a character is ever found that already has a TRUE value in
 *  the array, then it's a duplicate.
 * Runtime - O(n)
 * 
 * @param s - string
 * @return bool
 */
bool isUnique2(string s) {
  // For ASCII, there are only 128 possible characters, so if the
  // string has more than that, there must be a duplicate. 
  int stringLength = s.length();
  int val = 0;

  if (stringLength > 128) {
    return false;
  }

  bool chars[256];
  for (int i = 0; i < stringLength; i++) {
    val = s[i];
    if (chars[val]) {
      // the value at this index was already set to TRUE, so it's a duplicate.
      return false;
    }

    // otherwise, set it to TRUE.
    chars[val] = true;
  }

  return true;
}



/**
 * Variation: Ignore duplicate spaces.
 * Solution: Use the same solution as the first version (map), 
 *  except any character that is a space does not get checked for duplicates.
 * Runtime - O(n)
 * 
 * @param s - string
 * @return bool
 */
bool isUnique3(string s) {
  map<char, bool> charMap;
  vector<char> chars = toVector(s);

  for (char c : chars) {
    if (c != ' ' && charMap.find(c) != charMap.end()) {
      return false;
    } else {
      charMap[c] = true;
    }
  }

  return true;
}



// 
// Examples
// 
int main() {
  cout << isUnique("foo") << endl;    // false
  cout << isUnique("foO") << endl;    // true
  cout << isUnique("fog") << endl;    // true
  cout << isUnique("the quick brown fox jumps over the lazy dog") << endl;  // false
  cout << isUnique("Cwm fjord bank glyphs vext quiz") << endl;              // false, bc spaces not ignored
  cout << endl;

  cout << isUnique2("foo") << endl;    // false
  cout << isUnique2("foO") << endl;    // true
  cout << isUnique2("fog") << endl;    // true
  cout << isUnique2("the quick brown fox jumps over the lazy dog") << endl;  // false
  cout << isUnique2("Cwm fjord bank glyphs vext quiz") << endl;              // false, bc spaces not ignored
  cout << endl;

  cout << isUnique3("foo") << endl;    // false
  cout << isUnique3("foO") << endl;    // true
  cout << isUnique3("fog") << endl;    // true
  cout << isUnique3("the quick brown fox jumps over the lazy dog") << endl;  // false
  cout << isUnique3("Cwm fjord bank glyphs vext quiz") << endl;              // true, bc spaces are ignored

  return 0;
}