//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: FibonacciSequenceGenerator.java
// Files: ArithmeticSequenceGenerator.java, Sequence.java,
//////////////////// GeometricSequenceGenerator.java, DigitProductSequenceGenerator.java,
//////////////////// SequenceGeneratorTests.java
// Course: CS300 Fall 2018
//
// Author: Reece Lardy
// Email: RLardy@wisc.edu
// Lecturer's Name: Alexander Brooks
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Iterator; // import iterator

/**
 * This class represents a sequence generator for a fibonacci sequence
 * 
 * @author Reece Lardy
 * @implements Iterator
 */
public class FibonacciSequenceGenerator implements Iterator<Integer> {
  private final int SIZE; // number of elements in this sequence
  private int prev; // previous item in the sequence with respect to the current iteration
  private int next; // next item in the sequence with respect to the current iteration
  private int generatedCount; // number of items generated so far


  // constructor
  public FibonacciSequenceGenerator(int size) {
    // throw exception if size parameter is invalid
    if (size <= 0) {
      throw new IllegalArgumentException("WARNING: CANNOT create a sequence with size <= zero.");
    }
    // set size to input paramater size
    this.SIZE = size;
    // set variables to the beginning of the fibonacci sequence
    next = 1;
    prev = 0;
    generatedCount = 0;
  }


  /**
   * Checks to see if there is another element to add to the sequence
   * 
   * @return boolean representing if the amount of generated elements in the sequence is less than
   *         size
   * @see hasNext() in iterator
   */
  @Override
  public boolean hasNext() {
    // time complexity: O(1)
    return generatedCount < SIZE;
  }

  /**
   * Returns the next element in the fibonacci sequence and changes next field to current and finds
   * the new next element
   * 
   * @return boolean representing if the amount of generated elements in the sequence is less than
   *         size
   * @see next() in iterator
   */
  @Override
  public Integer next() {
    // time complexity: O(1)
    if (!hasNext()) // check if the current element has a next element in this sequence
      return null;
    int num = prev; // initialize local variable to hold the previous number in the sequence
    int current = next; // set the current element to next
    generatedCount++; // increment the number of generated elements so far
    next = next + prev; // set the next element
    prev = current; // set the new previous element to the old current element
    return num; // return the current number as the generated one
  }
}
