//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION ///////////////////////
// Title: SequenceGeneratorTests.java
// Files: ArithmeticSequenceGenerator.java, Sequence.java,
//////////////////// GeometricSequenceGenerator.java, DigitProductSequenceGenerator.java,
//////////////////// FibonacciSequenceGenerator.java
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
 * This class represents a series of tests for the functionality of classes of the Sequence
 * Generator project
 * 
 * @author Reece Lardy
 */
public class SequenceGeneratorTests {
  /**
   * Tests the GeometricSequenceGenerator class and returns false if any tests fail
   * 
   * @return boolean representing if the tests were passed or not
   */
  public static boolean geometricSequenceGeneratorTest() {
    GeometricSequenceGenerator test = new GeometricSequenceGenerator(1, 2, 5);
    if (!test.hasNext()) {
      System.out.println("GeometricSequenceGenerator hasNext test failed.");
      return false;
    }
    if (test.next() != 1) {
      System.out.println("GeometricSequenceGenerator next test failed.");
      return false;
    }
    return true;
  }

  /**
   * Tests the FibonacciSequenceGenerator class and returns false if any tests fail
   * 
   * @return boolean representing if the tests were passed or not
   */
  public static boolean fibonacciSequenceGeneratorTest() {
    FibonacciSequenceGenerator test = new FibonacciSequenceGenerator(5);
    if (!test.hasNext()) {
      System.out.println("FibonacciSequenceGenerator hasNext test failed.");
      return false;
    }
    if (test.next() != 0) {
      System.out.println("FibonacciSequenceGenerator next test failed.");
      return false;
    }
    return true;
  }

  /**
   * Tests the DigitProductSequenceGenerator class and returns false if any tests fail
   * 
   * This method should return true if your DigitProductSequenceGenerator allows the user to create
   * a digit-product sequence with the provided initial number and the provided size. Make sure that
   * the sequence is stored in the sequence instance field, your getIterator() method returns an
   * Iterator over the generated sequence, and the constructor of your DigitProductSequenceGenerator
   * throws the appropriate exceptions with the appropriate error messages if the provided
   * parameters to generate this sequence are NOT valid.
   * 
   * @return boolean representing if the tests were passed or not
   */
  public static boolean digitProductSequenceGeneratorTest() {
    try {
      int[] command = {3, 0, 5}; // parameters for sequence command with invalid init
      Sequence sequence = new Sequence(command); // create new sequence object with command
                                                 // parameters
      // if exception isnt caught this code will run and print an error message and return false
      System.out.println("DigitProductSequenceGenerator invalid init test failed.");
      return false;
    } catch (IllegalArgumentException e) {

    }
    try {
      int[] command = {3, 5, 0}; // parameters for sequence command with invalid size
      Sequence sequence = new Sequence(command); // create new sequence object with command
                                                 // parameters
      // if exception isnt caught this code will run and print an error message and return false
      System.out.println("DigitProductSequenceGenerator invalid size test failed.");
      return false;
    } catch (IllegalArgumentException e) {

    }
    int[] command = {3, 5, 5}; // parameters for sequence command
    Sequence sequence = new Sequence(command); // create new sequence object with command parameters
    DigitProductSequenceGenerator test = new DigitProductSequenceGenerator(5, 5); // create test
                                                                                  // sequence
    test.generateSequence(); // generate the test sequence
    String seq = "DIGIT_PRODUCT sequence: "; // initialize the String seq to compare to the sequence
                                             // string
    // Use a for-each loop to traverse the sequence and add the different numbers of the sequence
    // to its string representation, separated by a single space
    for (Integer i : test.getSequence())
      seq += i + " ";
    // if the sequences are not the same print a test failed message
    if (!sequence.toString().equals(seq.toString())) {
      System.out.println("DigitProductSequenceGenerator sequences test failed.");
      return false;
    }
    // if getIterator does not return an instance of Iterator<?>, print a test failed message
    if (!(test.getIterator() instanceof Iterator<?>)) {
      System.out.println(
          "DigitProductSequenceGenerator getIterator was not an instance of Iterator<>. Test failed.");
      return false;
    }
    // if all tests passed, return true
    return true;
  }

  /**
   * main method that calls the test methods and returns the status of the methods
   * 
   * @param args
   */
  public static void main(String[] args) {
    // initialize the test variable to true
    boolean total = true;
    // calls GeometricSequenceGeneratorTest() and if it returns false, set test variable to false
    if (!geometricSequenceGeneratorTest()) {
      total = false;
    }
    // calls FibonacciSequenceGeneratorTest() and if it returns false, set test variable to false
    if (!fibonacciSequenceGeneratorTest()) {
      total = false;
    }
    // calls DigitProductSequenceGeneratorTest() and if it returns false, set test variable to false
    if (!digitProductSequenceGeneratorTest()) {
      total = false;
    }
    // if every test passed, print a message to let the user know that
    if (total) {
      System.out.println("All tests Passed!");
    }
  }
}
