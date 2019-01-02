/**
 * Question: 1.4
 * Title: Palindrome Permutation
 *
 * Description: Given a string, write a function to check if it is a permutation
 *  of a palindrome. A palindrome is a word or phrase that is the same forwards
 *  and backwards. A permutation is a rearrangement of letters. The palindrome
 *  does not need to be limited to just dictionary words.
 *
 * Solution: Normalize the input string to all lowercase, and remove special characters.
 *  Then, split the string into an array and track the # of characters that are present
 *  an odd # of times. If the string has an even numbered length, all characters should
 *  be present an even number of times. If the string has an odd-numbered length, one
 *  character should be present an odd number of times, and the rest should be present
 *  an even number of times.
 *
 * Runtime: O(n)
 *
 * Example:
 *    Input: Tact Coa
 *    Output: True (permutations: "taco cat", "atco cta", etc.)
 */
const isPalindromePermutation = s => {
  let currCount = 0;
  let oddCount = 0;
  const charMap = new Map();

  // normalize the input string and determine if it's length is odd or even.
  const converted = s.toLowerCase().replace(/[^a-z]/g, '');
  const hasEvenLength = converted.length % 2 === 0;
  const chars = converted.split('');

  // count the # of times each character is present.
  chars.forEach(char => {
    if (charMap.has(char)) {
      currCount = charMap.get(char) + 1;
    } else {
      currCount = 1;
    }

    charMap.set(char, currCount);

    /* To keep a running total of the # of characters that are present an odd # of times,
    *  we'll increment or decrement the # of odd characters found (oddCount) based on the
    *  whether or not the current character has been found an even # of times or not. */
    if (currCount % 2 === 0) {
      oddCount -= 1;
    } else {
      oddCount += 1;
    }
  });

  if ((hasEvenLength && oddCount > 0) || (!hasEvenLength && oddCount !== 1)) {
    return false;
  }

  return true;
};


//
// Examples
//
console.log(isPalindromePermutation('Tact Coa'));   // true
console.log(isPalindromePermutation('foo bar'));    // false
console.log(isPalindromePermutation('taco Cat'));   // true
console.log(isPalindromePermutation('PPTOOST'));    // true
