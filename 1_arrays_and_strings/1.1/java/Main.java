import java.util.HashMap;

public class Main {

  /**
   * Question: 1.1
   * Description: Implement an algorithm to determine if a string has all unique characters.
   * Solution: Use a hash map to keep track of which characters have been encountered. At any
   *  point, if a character already exists in the hash map, the string does not have all 
   *  unique characters. If each character in the string is inspected before any duplicates
   *  are found, the string has all unique characters. 
   * Runtime - O(n)
   * 
   * @param s - String
   * @return boolean
   */
  private static boolean hasAllUniqueCharacters(String s) {
    HashMap<Character, Boolean>map = new HashMap<>();
    char[] chars = s.toCharArray();
    for (char c : chars) {
      if (map.containsKey(c)) {
        return false;
      } else {
        map.put(c, true);
      }
    }

    return true;
  }



  /**
   * Question: 1.1
   * Description: Implement an algorithm to determine if a string has all unique characters.
   * Variation: Don't use any additional data structures.
   * Solution: Create a boolean array that is the length of the # of possible ASCII characters
   *  (each value set to FALSE by default). Whenever a character is encountered, the value at
   *  that index is set to TRUE. If a character is ever found that already has a TRUE value in
   *  the array, then it's a duplicate.
   * Runtime - O(n)
   * 
   * @param s - String
   * @return boolean
   */
  private static boolean hasAllUniqueCharacters2(String s) {
    // For ASCII, there are only 128 possible characters, so if the
    // string has more than that, there must be a duplicate. 
    int stringLength = s.length();
    int val = 0;

    if (stringLength > 128) {
      return false;
    }

    boolean[] chars = new boolean[256];
    for (int i = 0; i < stringLength; i++) {
      val = s.charAt(i);
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
   * Question: 1.1
   * Description: Implement an algorithm to determine if a string has all unique characters.
   * Variation: Ignore spaces.
   * Solution: Use the same solution as the first version (hash map), expect any character that is
   *  a space does not get checked for duplicates.
   * Runtime - O(n)
   * 
   * @param s - String
   * @return boolean
   */
  private static boolean hasAllUniqueCharacters3(String s) {
    HashMap<Character, Boolean>map = new HashMap<>();
    char[] chars = s.toCharArray();

    for (char c : chars) {
      if (c != ' ' && map.containsKey(c)) {
        return false;
      } else {
        map.put(c, true);
      }
    }

    return true;
  }


    
  /**
   * Question: 1.1
   * Description: Implement an algorithm to determine if a string has all unique characters.
   * Variation: Ignore any characters present in a specified array.
   * Solution: Use the same solution as the first version (hash map), expect any character that is
   *  a space does not get checked for duplicates.
   * Runtime - O(n^2)
   * 
   * @param s - String
   * @return boolean
   */
  private static boolean hasAllUniqueCharacters4(String s, char[] ignoreList) {
    HashMap<Character, Boolean>map = new HashMap<>();
    char[] chars = s.toCharArray();

    for (char c : chars) {
      if (map.containsKey(c) && !contains(ignoreList, c)) {
        return false;
      } else {
        map.put(c, true);
      }
    }

    return true;
  }



  /**
   * Question: 1.1
   * Description: Implement an algorithm to determine if a string has all unique characters.
   * Variation: Ignore the case of the character.
   * Solution: Same as the first example except conver the input string to lowercase before
   *  splitting it into an array.
   * Runtime - O(n)
   * 
   * @param s - String
   * @return boolean
   */
  private static boolean hasAllUniqueCharacters5(String s) {
    HashMap<Character, Boolean>map = new HashMap<>();
    char[] chars = s.toLowerCase().toCharArray();

    for (char c : chars) {
      if (map.containsKey(c)) {
        return false;
      } else {
        map.put(c, true);
      }
    }

    return true;
  }




  /**
   * Helper function that determines if a given array of characters 
   *  contains a specified character.
   * 
   * @runtime - O(n)
   * @param c - the character to look for.
   * @param chars - the array of characters to search within.
   * @return boolean - true if the array contains the character, false if not.
   */
  private static boolean contains(char[] chars, char c) {
    for (char i : chars) {
      if (i == c) {
        return true;
      }
    }

    return false;
  }


  

  public static void main(String[] args) {
    System.out.println(hasAllUniqueCharacters("foO")); // case is not ignored, so o and O are seen as different chars
    System.out.println(hasAllUniqueCharacters("fog"));
    System.out.println(hasAllUniqueCharacters("the quick brown fox jumps over the lazy dog"));
    System.out.println(hasAllUniqueCharacters("Cwm fjord bank glyphs vext quiz"));
    System.out.print('\n');

    System.out.println(hasAllUniqueCharacters2("foo"));
    System.out.println(hasAllUniqueCharacters2("fog"));
    System.out.println(hasAllUniqueCharacters2("the quick brown fox jumps over the lazy dog"));
    System.out.println(hasAllUniqueCharacters2("Cwm fjord bank glyphs vext quiz"));
    System.out.print('\n');

    System.out.println(hasAllUniqueCharacters3("foo"));
    System.out.println(hasAllUniqueCharacters3("fog"));
    System.out.println(hasAllUniqueCharacters3("the quick brown fox jumps over the lazy dog"));
    System.out.println(hasAllUniqueCharacters3("Cwm fjord bank glyphs vext quiz"));
    System.out.print('\n');

    char[] ignored = {'a', 'e', 'i', 'o', 'u', ' '};
    System.out.println(hasAllUniqueCharacters4("foo", ignored));
    System.out.println(hasAllUniqueCharacters4("fog", ignored));
    System.out.println(hasAllUniqueCharacters4("the quick brown fox jumps over the lazy dog", ignored));
    System.out.println(hasAllUniqueCharacters4("Cwm fjord bank glyphs vext quiz", ignored));
    System.out.print('\n');

    System.out.println(hasAllUniqueCharacters5("foO"));  // case is ignored, so o and O are seen as same char
    System.out.println(hasAllUniqueCharacters5("fog"));
    System.out.println(hasAllUniqueCharacters5("the quick brown fox jumps over the lazy dog"));
    System.out.println(hasAllUniqueCharacters5("Cwm fjord bank glyphs vext quiz"));
    System.out.print('\n');
  }
}
