public class StringCompression {

  /**
   * Question: 1.6
   * Description: Implement a method to perform basic string compression using the counts of 
   *  repeated characters. For example, the string aabbcccccaaa would become a2b1c5a3. If the
   *  'compressed' string would not become smaller than the original string, your method should
   *  return the original string. You can assume the string has only upper and lower case letters.
   * Solution: 
   * Runtime:
   * 
   * @param s - String to compress
   * @return String - the compressed (or not) string.
   */
  private static String compressed(String s) {
    int size = compressedLength(s);
    if (size >= s.length()) {
      return s;
    }

    // create a new string buffer, and start tracking from the 1st character.
    StringBuffer buff = new StringBuffer();
    char prev = s.charAt(0);
    int count = 1;

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == prev) {
        // it's a repeated character, so increase the count.
        count += 1;
      } else {
        // it's a new character, so update the string buffer and 
        // update the tracked character and count.
        buff.append(prev);
        buff.append(count);
        prev = s.charAt(i);
        count = 1;
      }
    }

    // make sure to append the last character and count
    buff.append(prev);
    buff.append(count);
    return buff.toString();
  }



  /**
   * Helper function that determines what the length would be
   *  after compressing a given string.
   * 
   * @param s - String that would be compressed
   * @return int - the total length that the string would have after compressing.
   */
  private static int compressedLength(String s) {
    if (s == null || s.isEmpty())  {
      return 0;
    }

    char prev = s.charAt(0);
    int size = 0;
    int count = 1;

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == prev) {
        count += 1;
      } else {
        prev = s.charAt(i);
        size += 1 + String.valueOf(count).length();
        count = 1;
      }
    }

    size += 1 + String.valueOf(count).length();
    return size;
  }


  /**
   * Examples
   */
  public static void main(String[] args) {
    String a = "The black cat";
    String b = "aaabbbccc";
    String c = "cccaannaaddaa";

    System.out.println(a + ": " + compressed(a));    // would not be shortened by compressing
    System.out.println(b + ": " + compressed(b));
    System.out.println(c + ": " + compressed(c));
  }

}
