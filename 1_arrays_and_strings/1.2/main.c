#include <stdio.h>
#include <string.h>


/**
 * Question: 1.2
 * Description: Implement a function void reverse(char* str) in C or C++,
 *  which reverses a null-terminated string.
 * Solution: Create a c-string of the same length as the argued string. Then, traverse
 *  the argued string in reverse and assign the values in the created c-string in ascending order.
 * Runtime - O(n)
 * 
 * @param s - c-string
 */
void reverse(char* s) {
  size_t len = strlen(s);
  char reversed[len];

  int j = 0;
  for (int i = len - 1; i >= 0; i--) {
    reversed[i] = s[j];
    j++;
  }

  reversed[len] = '\0';
  printf("%s\n", reversed);
}


int main() {
  char x[10] = "telephone";
  char y[50] = "This little light of mine";
  char z[25] = "Walking on sunshine";

  reverse(x);
  reverse(y);
  reverse(z);
  return 0;
}