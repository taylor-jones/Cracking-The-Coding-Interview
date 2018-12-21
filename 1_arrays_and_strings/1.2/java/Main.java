public class Main {

  /**
   * Question: 1.2
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
    System.out.println(isPermutation("care", "race"));
    System.out.println(isPermutation("care", "rack"));
    System.out.println(isPermutation("care", "care"));
    System.out.println(isPermutation("care", "care bear"));
    System.out.println(isPermutation("care", "car"));
  }

}