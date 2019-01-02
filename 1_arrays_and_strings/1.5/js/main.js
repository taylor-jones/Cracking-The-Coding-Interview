/**
 * Question: 1.5
 * Title: One Away
 * Description: There are three types of edits that can be performed on strings:
 *  insert a character, remove a character, or replace a character. Given two strings,
 *  write a function to check if they are one edit (or zero edits) away,
 */



/**
   * Helper function that checks if a single character replacement in
   *  s1 would make it the same as s2.
   *
   * Solution: Loop through the two strings. If, at any point, the characters
   *  at the same index are not the same, then check if the replacement flag is
   *  already set. If so, this isn't the first flagged character, so more than one
   *  replacement would be needed. Otherwise, set the flag and keep comparing characters.
   *
   * Pre-requisites: The strings are assumed to be the same length.
   *
   * @param s1 string
   * @param s2 string
   * @return boolean - true if a single character can be replaced in
   *  s1 to make it the same as s2, false if not.
   */
const oneReplaceAway = (s1, s2) => {
  let replacementFlag = false;

  for (let i = 0; i < s1.length; i++) {
    if (s1.charAt(i) !== s2.charAt(i)) {
      if (replacementFlag) {
        return false;
      }

      replacementFlag = true;
    }
  }

  return true;
};



/**
   * Helper function that checks if a single character can be inserted
   *  into s1 which would make it the same as s2.
   *
   * Solution: Keep track of seperate indexes for each of the two strings,
   *  and use those indexes to compare the characters in the respective strings.
   *  Anytime the characters aren't the same, we'll move forward one index position
   *  in s2 and check for equality. However, if the two characters aren't the same
   *  and we've already moved forward in s2, then we know the two strings would
   *  require more than one insertion to be the same, so short-circuit the while loop
   *  by returning false.
   *
   * @param s1 string
   * @param s2 string
   * @return boolean - true if a single character can be inserted into
   *  s1 to make it the same as s2, false if not.
   */
const oneInsertAway = (s1, s2) => {
  let i = 0;
  let j = 0;

  while (i < s1.length && j < s2.length) {
    if (s1.charAt(i) !== s2.charAt(j)) {
      // if the characters aren't the same and the indexes aren't the same,
      // then the strings are at minimum 2 edits away from each other.
      if (i !== j) {
        return false;
      }

      j += 1;
    } else {
      // if the characters are the same, move to the next index in both strings.
      i += 1;
      j += 1;
    }
  }

  return true;
};



/**
   * Check if two strings are one edit away from each other.
   *
   * Solution: First check if the strings are the same. If so, no edit is needed.
   *  Next, verify that they don't have a length difference greater than one. If they
   *  do, we know they need more than one edit, so we can return false. Then, if we
   *  havent yet returned, we know the two strings are not equal, but they are either
   *  the same length or have a length difference of one. If they're the same length,
   *  use the helper function oneReplaceAway to determine if one character change would
   *  make the strings the same. Otherwise, if they aren't the same length, use the
   *  helper function oneInsertAway (passing the shorter of thw two strings as s1 and
   *  the longer of the two strings as s2), which will determine if the can insert one
   *  character into s1 to make it the same as s2.
   *
   * Runtime: O(n), where n is the length of the shorter of the two strings.
   *
   * @param s1 string
   * @param s2 string
   * @return boolean - true if a single edit can make the two strings the same,
   *  false if not.
   */
const oneAway = (s1, s2) => {
  // Check if the two strings are the same, in which case they are zero away.
  if (s1 === s2) {
    return true;
  }

  const len1 = s1.length;
  const len2 = s2.length;

  // Check if the two strings have a length difference greater than one,
  // which would ensure they are more than one change away from each other.
  if (Math.abs(len1 - len2) > 1) {
    return false;
  }

  // Otherwise, they are either the same length or have a length difference of one.
  if (len1 > len2) {
    return oneInsertAway(s2, s1);
  } if (len2 > len1) {
    return oneInsertAway(s1, s2);
  }
  return oneReplaceAway(s1, s2);
};



//
// Examples
//
console.log(oneAway('pale', 'ple'));       // true
console.log(oneAway('pales', 'pale'));     // true
console.log(oneAway('pale', 'bale'));      // true
console.log(oneAway('pale', 'bake'));      // false
console.log(oneAway('pale', 'whale'));     // false
console.log(oneAway('pale', ''));          // false
