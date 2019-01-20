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
 * Question: 1.2
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
  // show boolean output as text
  std::cout.setf(std::ios::boolalpha);

  string a = "care";
  string b = "race";
  string c = "rack";
  string d = "cares";
  string e = "car";
  string f = "racetop";
  string g = "carepot";
  string h = "";

  cout << a + "\t|\t" << b << "\t|\t" << isPermutation(a, b) << endl;
  cout << a + "\t|\t" << c << "\t|\t" << isPermutation(a, c) << endl;
  cout << a + "\t|\t" << d << "\t|\t" << isPermutation(a, d) << endl;
  cout << a + "\t|\t" << e << "\t|\t" << isPermutation(a, e) << endl;
  cout << f + "\t|\t" << g << "\t|\t" << isPermutation(f, g) << endl;
  cout << f + "\t|\t" << d << "\t|\t" << isPermutation(f, d) << endl;
  cout << a + "\t|\t" << f << "\t|\t" << isPermutation(a, f) << endl;

  return 0;
}