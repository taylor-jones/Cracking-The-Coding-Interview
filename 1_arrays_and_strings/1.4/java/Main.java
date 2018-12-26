/**
 * Question: 1.4
 * Title: Palindrome Permutation
 * Description: Given a string, write a function to check if it is a permutation
 *  of a palindrome. A palindrome is a word or phrase that is the same forwards
 *  and backwards. A permutation is a rearrangement of letters. The palindrome
 *  does not need to be limited to just dictionary words.
 * Example:
 *    Input: Tact Coa
 *    Output: True (permutations: "taco cat", "atco cta", etc.)
 */

 import java.util.HashMap;

 public class Main {
 
    /**
     * Solution: Normalize the string by converting it to all lowercase and then removing
     *  any special characters. Then, split the string into a character array and use a
     *  HashMap to track the # of times each character is present in the array. If the 
     *  converted string has an even # of characters, it is a palindrome if each character
     *  is present an even # of times. If the converted string has an odd # of characters,
     *  it is a palindrome if only one of the characters is present an odd # of times.
     * 
     * Runtime: O(n^2)
     * 
     * @param s - a String to evaluate
     * @return boolean - true if the input string is a permutation of a palindrome, false if not.
     */
    private static boolean isPalindromePermutation(String s) {
      int oddCount = 0;
      HashMap<Character, Integer>map = new HashMap<>();

      // normalize the input string and determine if it's lenght is odd or even.
      String lowered = s.toLowerCase().replaceAll("[^a-z]","");
      boolean hasEvenLength = lowered.length() % 2 == 0;
      char[] chars = lowered.toCharArray();

      // count the # of times each character is present.
      for (char c : chars) {
        if (map.containsKey(c)) {
          map.put(c, map.get(c) + 1);
        } else {
          map.put(c, 1);
        }
      }

      // determine the # of characters present an odd # of times.
      for (char c : chars) {
        if (map.get(c) % 2 != 0) {
          oddCount += 1;
        }
      }

      if ((hasEvenLength && oddCount > 0) || (!hasEvenLength && oddCount != 1)) {
        return false;
      }

      return true;
    }



    /**
     * Solution: Similar to the solution above except here, a modification is made to track
     *  the # of characters that are present an odd # of times in a single pass through the
     *  character array, which makes the small space sacrifice of using another int to track
     *  values, but it improves the runtime to O(n) since we only need to loop through the 
     *  character array once.
     * 
     * Runtime: O(n)
     * 
     * @param s - a String to evaluate
     * @return boolean - true if the input string is a permutation of a palindrome, false if not.
     */
    private static boolean isPalindromePermutation2(String s) {
      int oddCount = 0;
      int currCount = 0;
      HashMap<Character, Integer>map = new HashMap<>();

      // normalize the input string and determine if it's lenght is odd or even.
      String lowered = s.toLowerCase().replaceAll("[^a-z]","");
      boolean hasEvenLength = lowered.length() % 2 == 0;

      // count the # of times each character is present.
      for (char c : lowered.toCharArray()) {
        if (map.containsKey(c)) {
          currCount = map.get(c) + 1;
        } else {
          currCount = 1;
        }

        map.put(c, currCount);

        /* to keep a running total of the # of characters that are present an odd # of times,
         * we'll increment or decrement the # of odd characters found (oddCount) based on the
         * whether or not the current character has been found an even # of times or not. */ 
        if (currCount % 2 == 0) {
          oddCount -= 1;
        } else {
          oddCount += 1;
        }
      }

      if ((hasEvenLength && oddCount > 0) || (!hasEvenLength && oddCount != 1)) {
        return false;
      }

      return true;
    }



    /**
     * Examples
     */
    public static void main(String[] args) {
     System.out.println(isPalindromePermutation("Tact Coa")); // true
     System.out.println(isPalindromePermutation("foo bar"));  // false
     System.out.println(isPalindromePermutation("taco Cat")); // true
     System.out.println(isPalindromePermutation("PPTOOST"));  // true

     System.out.println(isPalindromePermutation2("Tact Coa")); // true
     System.out.println(isPalindromePermutation2("foo bar"));  // false
     System.out.println(isPalindromePermutation2("taco Cat")); // true
     System.out.println(isPalindromePermutation2("PPTOOST"));  // true
   }
 
 }
 