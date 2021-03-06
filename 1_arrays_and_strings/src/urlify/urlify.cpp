/**
 * Question: 1.3
 * Name: URLify
 * Description: Write a method to replace all spaces in a string with '%20'.
 *  You may assume that the string has sufficient space at the end of the string to
 *  hold the additional characters, and that you are given the 'true' length of the string.
 */

#include <iostream>
#include <string>
#include <regex>

using namespace std;


string urlify(string s) {
  return regex_replace(s, regex("\\s+"), "%20");
}


// 
// Examples
// 
int main() {
  cout << urlify("Hootie and the Blowfish") << endl;
  cout << urlify("End-of-the-week") << endl;
  
  return 0;
}