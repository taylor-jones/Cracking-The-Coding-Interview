/**
 * Question: 1.2
 * Name: Check Permutation
 * Description: Given two strings, write a method to decide if one is a permutation of the other.
 * Solution: The strings must pass two inspections to be considered a permutation of each other:
 *  1) They should be the same length.
 *  2) Their sorted contents should be equal.
 */


/**
 * Helper function that returns the sorted version of a string.
 */
const sorted = s => {
  return s
    .split('')
    .sort()
    .join('');
};


/**
 * Determines if two strings are a permutation of each other using two conditions:
 * 1) The strings must be the same length.
 * 2) Their sorted contents must be the same.
 */
const isPermutation = (s1, s2) => {
  if (s1.length !== s2.length) {
    return false;
  }

  return (sorted(s1) === sorted(s2));
};



const a = 'care';
const b = 'race';
const c = 'rack';
const d = 'cares';
const e = 'car';
const f = '';

console.log(`${a}\t|\t${a}\t|\t${isPermutation(a, a)}`);
console.log(`${a}\t|\t${b}\t|\t${isPermutation(a, b)}`);
console.log(`${a}\t|\t${c}\t|\t${isPermutation(a, c)}`);
console.log(`${a}\t|\t${d}\t|\t${isPermutation(a, d)}`);
console.log(`${a}\t|\t${e}\t|\t${isPermutation(a, e)}`);
console.log(`${a}\t|\t${f}\t|\t${isPermutation(a, f)}`);