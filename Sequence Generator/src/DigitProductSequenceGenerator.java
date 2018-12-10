//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: DigitProductSequenceGenerator.java
// Files: ArithmeticSequenceGenerator.java, Sequence.java,
//////////////////// GeometricSequenceGenerator.java, FibonacciSequenceGenerator.java,
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
import java.util.ArrayList; // import arraylist
import java.util.Iterator; // import iterator

/**
 * This class represents a sequence generator for a digit product sequence
 * 
 * @author Reece Lardy
 */
public class DigitProductSequenceGenerator {
  private final int INIT; // initial number
  private final int SIZE; // size of sequence
  private ArrayList<Integer> sequence; // ArrayList object storing the sequence

  // constructor
  public DigitProductSequenceGenerator(int init, int size) {
    // throw exception if init parameter is invalid
    if (init <= 0) {
      throw new IllegalArgumentException(
          "WARNING: The starting element for digit product sequence cannot be less than or equal to zero.");
    }
    // throw exception if size parameter is invalid
    if (size <= 0) {
      throw new IllegalArgumentException("WARNING: CANNOT create a sequence with size <= zero.");
    }
    // set variables equal to input parameters
    this.SIZE = size;
    this.INIT = init;
    // create an empty arraylist to hold the sequence
    sequence = new ArrayList<Integer>();
    // generate the sequence
    generateSequence();
  }

  /**
   * Generates the digit product sequence using a series of math equations
   */
  public void generateSequence() {
    // empty the array list
    sequence.clear();
    // add the first element in the sequence to the array list
    sequence.add(this.INIT);
    // create a variable to store the last element added to the array list
    int last = this.INIT;
    // while the array is smaller than the size of the sequence
    while (sequence.size() < this.SIZE) {
      // if the last element is smaller than 10
      if (last < 10) {
        // add double the last element to the array list and update the last variable
        sequence.add(last * 2);
        last = last * 2;
      }
      // if the last element is 10 or greater
      else {
        // create a string to hold the last value
        String nums = Integer.toString(last);
        // store the ones value of the last element in the ones int
        int ones = Character.getNumericValue(nums.charAt(nums.length() - 1));
        // store the rest of the value in the tens int
        int tens = Integer.parseInt(nums.substring(0, nums.length() - 1));
        // treat a ones value of 0 as 1
        if (ones == 0) {
          ones = 1;
        }
        // add the new element to the array list and update the last variable
        sequence.add(last + (tens * ones));
        last = (last + (tens * ones));
      }
    }
  }

  /**
   * Returns an iterator for the digit product sequence
   * 
   * @returns Iterator<Integer> that works with the digit product sequence
   */
  public Iterator<Integer> getIterator() {
    // return the iterator
    return sequence.iterator();
  }

  /**
   * Returns the sequence to be used in test methods
   * 
   * @returns Arraylist<Integer> that is the digit product sequence
   */
  public ArrayList<Integer> getSequence() {
    // return the sequence for test methods
    return sequence;
  }
}
