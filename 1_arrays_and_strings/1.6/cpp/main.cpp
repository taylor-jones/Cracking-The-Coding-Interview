#include <iostream>
#include <string>

using namespace std;


/**
 * Helper function that determines what the length would be
 *  after compressing a given string.
 * 
 * @param s - string that would be compressed
 * @return int - the total length that the string would have after compressing.
 */
int compressedLength(string s) {
  if (s.empty()) {
    return 0;
  }

  char prev = s.at(0);
  int size = 0;
  int count = 1;

  for (int i = 1; i < s.length(); i++) {
    if (s.at(i) == prev) {
      count += 1;
    } else {
      prev = s.at(i);
      size += 1 + to_string(count).length();
      count = 1;
    }
  }

  size += 1 + to_string(count).length();
  return size;
}



/**
 * Question: 1.6
 * Description: Implement a method to perform basic string compression using the counts of 
 *  repeated characters. For example, the string aabbcccccaaa would become a2b1c5a3. If the
 *  'compressed' string would not become smaller than the original string, your method should
 *  return the original string. You can assume the string has only upper and lower case letters.
 * Solution: 
 * Runtime:
 * 
 * @param s - string to compress
 * @return string - the compressed (or not) string.
 */
string compressed(string s) {
  int size = compressedLength(s);
  if (size >= s.length()) {
    return s;
  }

  string t = "";
  char prev = s.at(0);
  int count = 1;

  for (int i = 1; i < s.length(); i++) {
    if (s.at(i) == prev) {
      count += 1;
    } else {
      t += prev;
      t += to_string(count);
      prev = s.at(i);
      count = 1;
    }
  }

  t += prev;
  t += to_string(count);
  return t;
}



int main() {
    cout << compressed("The black cat") << endl;    // would not be shortened by compressing
    cout << compressed("aaabbbccc") << endl;        // would be shortened by compressing
    cout << compressed("cccaannaaddaa") << endl;    // would be shortened by compressing


  return 0;
}