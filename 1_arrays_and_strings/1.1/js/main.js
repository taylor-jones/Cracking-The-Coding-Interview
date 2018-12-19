/**
 * Question: 1.1
 * Description: Implement an algorithm to determine if a string has all unique characters.
 * Solution: Split the string into an array. Then use a Set to remove any duplicates. If the
 *  two arrays are the same length, then no duplicates were removed, meaning the string has
 *  all unique characters.
 * 
 * @param s - string
 * @return boolean
 */
const hasAllUniqueCharacters = s => {
  const chars = s.split('');
  const uniques = [...new Set(chars)];
  return chars.length === uniques.length;
};


/**
 * Question: 1.1
 * Description: Implement an algorithm to determine if a string has all unique characters.
 * Variation: Ignore spaces.
 * Solution: Same solutation as the first version, except filter out any spaces in the argued
 *  string after splitting it into an array.
 * 
 * @param s - string
 * @return boolean
 */
const hasAllUniqueCharacters2 = s => {
  const chars = s.split('').filter(c => c != ' ');
  const uniques = [...new Set(chars)];
  return chars.length === uniques.length;
};


/**
 * Question: 1.1
 * Description: Implement an algorithm to determine if a string has all unique characters.
 * Variation: Ignore case.
 * Solution: Same solution as the first version, except convert the argued string to 
 *  lowercase before splitting it into an array.
 * 
 * @param s - string
 * @return boolean
 */
const hasAllUniqueCharacters3 = s => {
  const chars = s.toLowerCase().split('');
  const uniques = [...new Set(chars)];
  return chars.length === uniques.length;
};



console.log(hasAllUniqueCharacters("foO")); 
console.log(hasAllUniqueCharacters("fog"));
console.log(hasAllUniqueCharacters("the quick brown fox jumps over the lazy dog"));
console.log(hasAllUniqueCharacters("Cwm fjord bank glyphs vext quiz")); // spaces are not ignored, so they're seen as duplicates
console.log('\n');

console.log(hasAllUniqueCharacters2("foO")); 
console.log(hasAllUniqueCharacters2("fog"));
console.log(hasAllUniqueCharacters2("the quick brown fox jumps over the lazy dog"));
console.log(hasAllUniqueCharacters2("Cwm fjord bank glyphs vext quiz"));  // spaces are ignored, so they're not seen as duplicates
console.log('\n');

console.log(hasAllUniqueCharacters3("foO")); // case-insensitive, so o & O are considered duplcates.
console.log(hasAllUniqueCharacters3("fog"));
console.log(hasAllUniqueCharacters3("the quick brown fox jumps over the lazy dog"));
console.log(hasAllUniqueCharacters3("Cwm fjord bank glyphs vext quiz"));  // spaces are ignored, so they're not seen as duplicates
console.log('\n');