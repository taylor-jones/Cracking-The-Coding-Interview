/**
 * Problem: 1.9
 * Title: String Rotation
 * Description: Assume you have a method isSubString, which checks if one word
 *  is a substring of another. Given two strings, s1 and s2, write code to check
 *  if s2 is a rotation of s1 using only one call to isSubString (e.g, "waterbottle"
 *  is a rotation of "erbottlewat")
 */


public class Main {
  /**
   * Checks if a string s1 is a substring of another string s2.
   * @param s1 - String
   * @param s2 - String
   * @return boolean - True if s1 is a substring of s2. False if not.
   */
  private static boolean isSubString(String s1, String s2) {
    return s2.contains(s1);
  }


  /**
   * Checks if a string is a rotation of another string using only a single
   *  call to isSubString.
   * 
   * Solution: If s2 is a rotation of s1, then s2 will definitely be in the
   *  concatenation of s1 to itself. For example, if s1 is "cloud", and s2 is "udclo",
   *  then concatenating s1 to itself gives us "cloudcloud", which contains the
   *  substring "udclo" (aka s2). Then, all we need to do is call isSubString with
   *  s2 and the concatenated s1s1 one time to find our answer.
   * 
   * Runtime: O(n)
   * 
   * @param s1 - String
   * @param s2 - String
   * @return bool - true if s2 is a rotation of s1, false if not.
   */
  private static boolean isRotation(String s1, String s2) {
    int len = s1.length();

    // First, ensure that the two strings are not empty and are of equal length.
    if (len == s2.length() && len > 0) {
      // Create a string having s1 concatenated to itself, which will always contain
      // s2 whenever s2 is a rotation of s1.
      String s1s1 = s1 + s1;
      return isSubString(s2, s1s1);
    }

    return false;
  }


  //
  // Examples
  //
  public static void main(String[] args) {
    System.out.println(isRotation("foo", "bar"));   // false
    System.out.println(isRotation("foo", "ofo"));   // true
    System.out.println(isRotation("waterbottle", "bottlewater"));   // true
    System.out.println(isRotation("foo", "oof"));   // true
    System.out.println(isRotation("foo", ""));      // false
    System.out.println(isRotation("cat", "tac"));   // false
  }

}
