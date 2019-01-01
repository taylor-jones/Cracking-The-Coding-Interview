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
const isUnique = s => {
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
const isUnique2 = s => {
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
const isUnique3 = s => {
  const chars = s.toLowerCase().split('');
  const uniques = [...new Set(chars)];
  return chars.length === uniques.length;
};



console.log(isUnique('foO'));
console.log(isUnique('fog'));
console.log(isUnique('the quick brown fox jumps over the lazy dog'));
console.log(isUnique('Cwm fjord bank glyphs vext quiz')); // spaces are not ignored, so they're seen as duplicates
console.log('');

console.log(isUnique2('foO'));
console.log(isUnique2('fog'));
console.log(isUnique2('the quick brown fox jumps over the lazy dog'));
console.log(isUnique2('Cwm fjord bank glyphs vext quiz')); // spaces are ignored, so they're not seen as duplicates
console.log('');

console.log(isUnique3('foO')); // case-insensitive, so o & O are considered duplcates.
console.log(isUnique3('fog'));
console.log(isUnique3('the quick brown fox jumps over the lazy dog'));
console.log(isUnique3('Cwm fjord bank glyphs vext quiz')); // spaces are ignored, so they're not seen as duplicates
console.log('');
