public class Main {

  /**
   * Question: 1.4
   * Description: Write a method to replace all spaces in a string with '%20'. You may assume that
   *  the string has sufficient space at the end of the string to hold the additional characters, and
   *  that you are given the 'true' length of the string.
   * Solution: Split the string into a character array. Iterate through the array and, whenever a space
   *  is encountered, call the helper function shiftRight, which moves each of the remaining characters
   *  in the array two places to the right, which makes room to replace the space with the '%20'.
   * 
   * @param s String - the string to replace spaces in.
   * @param trueLength int - the actual # of characters in the string (ignoring trailing spaces)
   * @return String - the string with the spaces replaced
   */
  private static String replaceSpaces(String s, int trueLength) {
    char[] chars = s.toCharArray();
    int totalLength = s.length();

    for (int i = 0; i < trueLength; i++) {
      if (chars[i] == ' ') {
        shiftRight(chars, i + 1, totalLength);
        chars[i] = '%';
        chars[i + 1] = '2';
        chars[i + 2] = '0';
      }
    }

    return new String(chars);
  }



  /**
   * Question: 1.4
   * Description: Write a method to replace all spaces in a string with '%20'. You may assume that
   *  the string has sufficient space at the end of the string to hold the additional characters, and
   *  that you are given the 'true' length of the string.
   * Solution: Use the String.replaceAll method to replace all spaces with %20
   * 
   * @param s String - the string to replace spaces in.
   * @return String - the string with the spaces replaced
   */
  private static String replaceSpaces2(String s) {
    return s.replaceAll("\\s", "%20");
  }



  /**
   * Helper function that shifts each of the characters in a character array
   *  to the right two places, starting from the end and moving backward in
   *  the array until a specified starting index.
   */
  private static void shiftRight(char[] chars, int start, int length) {
    for (int i = length - 1; i > start; i--) {
      chars[i] = chars[i - 2];
    }
  }


  
  public static void main(String[] args) {
    System.out.println(replaceSpaces("Mr John Smith    ", 13));
    System.out.println(replaceSpaces("Hootie And The Blowfish      ", 23));
    System.out.print('\n');

    System.out.println(replaceSpaces2("Mr John Smith"));
    System.out.println(replaceSpaces2("Hootie And The Blowfish"));
  }

}
