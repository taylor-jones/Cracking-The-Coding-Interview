# Cracking The Coding Interview
The goal is to implement and demonstrate solutions to each of the problems in Cracking The Coding Interview - 5th Edition, using each of:
- C
- C++
- Java
- JavaScript
- Python

The goal is to solve each problem using each language. However, the over-arching goal is understanding, rather than completion, so this I'm using this repo as a journal of sorts, while I work through the book and work on improving my understanding of the languages and concepts. 

<br>

### 1. Arrays and Strings

| #  	| Description| C   | C++ | Java  | JS  | Python
|---  |---  |---  |---  |---  |---  |---  
|1.1	|Implement an alogirthm to determine if a string has all unique characters. What if you cannot use additional data structures?	|	  |	  |	[Java](1_arrays_and_strings/1.1/java/Main.java)  | [JS](1_arrays_and_strings/1.1/js/main.js)  |  
|1.2	|Implement a function void recerse(char* str) in C or C++ which reverses a null-terminated string.	| [C](1_arrays_and_strings/1.2/main.c)	  |	[C++](1_arrays_and_strings/1.2/main.cpp)  |	  |    |  
|1.3	| Given two strings, write a method to decide if one is a permutation of the other.	| 	| [C++](1_arrays_and_strings/1.3/cpp/main.cpp)	| [Java](1_arrays_and_strings/1.3/java/Main.java)	|  |  
|1.4	|	Write a method to replace all spaces in a string with '%20'. |	| 	|	[Java](1_arrays_and_strings/1.4/java/Main.java)  | [JS](1_arrays_and_strings/1.4/js/main.js) |  
|1.5	|	Implement a method to perform basic string compression using the counts of repeated characters. |	  | [C++](1_arrays_and_strings/1.5/cpp/main.cpp)	 |	[Java](1_arrays_and_strings/1.5/java/Main.java)  |  |  
|1.6	| Given an image represented by a NxN matrix, where each pixel in the images is 4 bytes, write a method to rotate the image by 90 degrees.	|	  |	  |	  |   |  
|1.7	|	Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0. |	  |	  |	  |   |  
|1.8	|	Assume you have a method isSubString which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubString. |	  |	  |	  |  |  

<br>

### 2. Linked Lists

| #  	| Description| C   | C++ | Java  | JS  | Python
|---  |---  |---  |---  |---  |---  |---  
|2.x  | Singly-linked list |  |   | [Java](2_linked_lists/java/LinkedList.java)  |   | 
|2.x  | Doubly-linked list |  |   |   |   | 
|2.x  | Circularly-linked list |   |   |   |   | 
|2.1	|	Write code to remove duplicates from an unsorted linked list.  |	  |	  | [Java*](2_linked_lists/java/LinkedList.java)  |   |  
|2.2	| Implement an algorithm to find the kth to last element of a singly-linked list.  | 	|	  | [Java*](2_linked_lists/java/LinkedList.java)  |   |
|2.3	| Implement an algorithm to delete a node in the middle of a singly-linked list, given only access to that node.	| 	|   | 	|   |  
|2.4	|	Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. |	  | 	|	  |   |  
|2.5	|	You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list. |	  |   |	  |   |  
|2.6	| Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.  |	  |	  |	  |   |  
|2.7	|	Implement a function to check if a linked list is a palindrome. |	  |	  |	  |   |  


\* Some of the solutions are in the same file as the their corresponding linked-list implementations.