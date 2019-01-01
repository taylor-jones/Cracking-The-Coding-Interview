/**
 * Question: 1.3
 * Name: URLify
 * Description: Write a method to replace all spaces in a string with '%20'. You may assume that
 *  the string has sufficient space at the end of the string to hold the additional characters, and
 *  that you are given the 'true' length of the string.
 * Solution: Use regex to replace all instances of a space with %20.
 *
 * @param s string - the string to replace spaces in.
 * @param trueLength number - the actual # of characters in the string (ignoring trailing spaces)
 * @return string - a new string with the replaced spaces
 */
const replaceSpaces = s => {
  return s.replace(/\s/g, '%20');
};


console.log(replaceSpaces('Hootie And The Blowfish'));
