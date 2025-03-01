/*
 * *** Zach Kofira / Section 002 ***
 *
 * This HashingProblems object contains three methods / problems that you must
 * complete utilize the HashMap object within the Java's Collection Framework Library.
 *
 * The three methods / problems you need to solve are:
 *  - getAverage
 *  - odd
 *  - twoSums
 */

import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;

class HashingProblems {

    /*
     * Method getAverage()
     *
     * This method accepts two parameters. The first is a HashMap object, while the second
     * is an array of integers. This method must compute the average of the values for each
     * 'key' that is found in BOTH the HashMap and the array.
     *
     * For example, if only the keys 1 and 2 from the array are present in the HashMap, and
     * lets say their values were 10 and 20, respectively, then the average is calculated
     * as (10+20)/2 = 15. Lets also say the keys ‘7’ and ‘8’ are in the array, but those keys
     * are not present in the HashMap. That means their corresponding values in the HashMap
     * are not included in the average calculation.
     */

    public double getAverage(HashMap<Integer, Integer> map, int[] array) {

        /*
         * ADD YOUR CODE HERE - DO NOT FORGET TO ADD YOU NAME AT TOP OF FILE
         *
         * Note: if NO values found in common between the HashMap and supplied array,
         * returning 0.0 is NOT correct, as that is not the average value. Whereas
         * returning 0.0/0.0 IS correct (which would return a non-number).
         */

        //initialize variables to find average
        double amount = 0.0;
        double total = 0.0;

        //for each number in the array, if there is a matching key, add the keys value to total and add 1 to amount
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                amount++;
                total += map.get(array[i]);
            }
        }
        //return average by dividing total by amount
         return total / amount;
  }


    /*
     * Method odd()
     *
     * This method accepts a HashMap object, and returns an ArrayList object with the
     * values of the corresponding keys that are odd.
     */

  public ArrayList<String> odd(HashMap<Integer, String> map) {
    
      ArrayList<String> result = new ArrayList<>();

      /*
       * ADD YOUR CODE HERE
       *
       * Hint: Consider iterating over the HashMap using the keySet method.
       */

      //check each key, and add the value of each odd key
      map.keySet().forEach(k -> {
          if (k % 2 == 1) {
              result.add(map.get(k));
          }
      });

      return result;
  }


  /*
   * Method twoSums()
   *
   * You ARE to solve this problem in time complexity O(n). The submittals will be spot checked.
   *
   * Problem statement:
   * Suppose you are given an integer array containing the values [1,4,5,7,8,9] along with the
   * value k=4, where k is the difference between two array elements. How many times does k appear
   * in that list?
   *
   * With the above numbers, it will be three times:
   *    k = 4
   *    (5 - 1) = k
   *    (8 - 4) = k
   *    (9 - 5) = k
   *    k appears 3 times.
   *
   * All combinations must be considered. But, any other combination of the numbers in the array
   * results in a difference value that is not equal to k (k=4 in this case).
   *
   * This can be solved using nested for-loops, checking all combinations of the values in the array.
   * But the time complexity would be O(n^2).
   *
   * In order to solve this problem in O(n) complexity, utilize a HashMap (or a HashSet).
   *
   * You are two solve this using a HashMap (or you can use a HashSet, which is implemented
   * using HashMap). To solve this, you should populate the HashMap (or HashSet) based on
   * the array (this will be complexity time on the order of 'n'). After populating the HashMap,
   * consider a for-loop that does a lookup (probe) of the HashMap (or HashSet) on each iteration
   * of the loop. This will also have a complexity on the order of 'n', as the hashing probes are a
   * constant time complexity (after removing any constant based on collisions).
   *
   * This will result in a time complexity of O(n) for the overall method.
   *
   * NOTE: Solving using a HashMap or HashSet is fine (either is okay). HashSet may be easier to code?
   */

  public int twoSums(int[] numbers, int k) {

      /*
       * ADD YOUR CODE HERE
       */

      //initialize sum
      int sum = 0;

      //put the whole array into a hashset
      HashSet tracker = new HashSet();
      for (int i = 0; i < numbers.length; i++) {
          tracker.add(numbers[i]);
      }

      //look for differences of 4, add 1 to sum if one is found
      for (int i = 0; i < numbers.length; i++) {
          if (tracker.contains(numbers[i] + k)) {
              sum++;
          }
      }
      return sum;
  }

} /* end class HashingProblems */
