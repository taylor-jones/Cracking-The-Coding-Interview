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
  const chars = s.split('').filter(c => c !== ' ');
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



/**
 * Examples
 */
const a = 'foO';
const b = 'big red hat';
const c = 'the quick brown fox jumps over the lazy dog';
const d = 'Cwm fjord bank glyphs vext quiz';

console.log('\n*** Testing isUnique1 (spaces not ignored, case sensitive)');
console.log(`${a}: ${isUnique(a)}`);
console.log(`${b}: ${isUnique(b)}`);
console.log(`${c}: ${isUnique(c)}`);
console.log(`${d}: ${isUnique(d)}`);

console.log('\n*** Testing isUnique2 (spaces not ignored, case sensitive)');
console.log(`${a}: ${isUnique2(a)}`);
console.log(`${b}: ${isUnique2(b)}`);
console.log(`${c}: ${isUnique2(c)}`);
console.log(`${d}: ${isUnique2(d)}`);

console.log('\n*** Testing isUnique3 (spaces ignored, case insensitive)');
console.log(`${a}: ${isUnique3(a)}`);
console.log(`${b}: ${isUnique3(b)}`);
console.log(`${c}: ${isUnique3(c)}`);
console.log(`${d}: ${isUnique3(d)}\n`);
