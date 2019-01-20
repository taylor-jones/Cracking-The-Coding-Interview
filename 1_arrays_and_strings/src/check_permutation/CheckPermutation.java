public class CheckPermutation {

  /**
   * Question: 1.2
   * Name: Check Permutation
   * Description: Given two strings, write a method to decide if one is a permutation of the other.
   * Solution: The strings must pass two inspections to be considered a permutation of each other:
   *  1) They should be the same length.
   *  2) Their sorted contents should be equal. 
   * 
   * @param s1 - String
   * @param s2 - String
   * @return boolean
   */
  private static boolean isPermutation(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }

    return sorted(s1).equals(sorted(s2));
  }


  /**
   * Helper function that returns a sorted version of a string.
   * 
   * @param s - the string to sort.
   * @return String - the sorted string
   */
  private static String sorted(String s) {
    char[] chars = s.toCharArray();
    java.util.Arrays.sort(chars);
    return new String(chars);
  }


  public static void main(String[] args) {
    String a = "care";
    String b = "race";
    String c = "rack";
    String d = "cares";
    String e = "car";
    String f = "acre";
    String g = "";

    System.out.println(a + "\t|\t" + b + "\t|\t" + isPermutation(a, b));
    System.out.println(a + "\t|\t" + c + "\t|\t" + isPermutation(a, c));
    System.out.println(a + "\t|\t" + d + "\t|\t" + isPermutation(a, d));
    System.out.println(a + "\t|\t" + e + "\t|\t" + isPermutation(a, e));
    System.out.println(a + "\t|\t" + f + "\t|\t" + isPermutation(a, f));
    System.out.println(a + "\t|\t" + g + "\t|\t" + isPermutation(a, g));
  }

}