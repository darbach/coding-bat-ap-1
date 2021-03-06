package edu.cnm.deepdive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CodingBat's first set of Java exercises for AP CS medium problems.
 * <p>
 * https://codingbat.com/java/AP-1
 *
 * @author Daniel Arbach
 * @version 1.0
 * @since 2021-02-24
 */
public class AP1 {

  /**
   * Given an array of scores, return true if each score is equal or greater than the one
   * before. The array will be length 2 or more.
   *
   * scoresIncreasing([1, 3, 4]) → true
   * scoresIncreasing([1, 3, 2]) → false
   * scoresIncreasing([1, 1, 4]) → true
   *
   * @param scores An array of ints.
   * @return True, if each successive array element is equal to or greater than the previous element.
   */
  public boolean scoresIncreasing(int[] scores) {
    boolean isIncreasing = true;
    for (int i = 0; i <= scores.length - 2; i++) {
      if (scores[i] > scores[i + 1]) {
        isIncreasing = false;
        break;
      }
    }
    return isIncreasing;
  }

  /**
   * Given an array of scores, return true if there are scores of 100 next to each other in
   * the array. The array length will be at least 2.
   *
   * scores100([1, 100, 100]) → true
   * scores100([1, 100, 99, 100]) → false
   * scores100([100, 1, 100, 100]) → true
   *
   * @param scores An array of length 2 or more.
   * @return  True, if two adjacent elements are 100.
   */
  public boolean scores100(int[] scores) throws IllegalArgumentException {
    if (scores.length < 2) {
      throw new IllegalArgumentException("Input array must have at least 2 elements");
    }
    boolean found = false;
    for (int i = 0; i <= scores.length - 2; i++) {
      if ((scores[i] == 100) && (scores[i + 1] == 100)) {
        found = true;
        break;
      }
    }
    return found;
  }

  /**
   * Given an array of scores sorted in increasing order, return true if the array
   * contains 3 adjacent scores that differ from each other by at most 2, such as
   * with {3, 4, 5} or {3, 5, 5}.
   *
   * scoresClump([3, 4, 5]) → true
   * scoresClump([3, 4, 6]) → false
   * scoresClump([1, 3, 5, 5]) → true
   *
   * @param scores An int array in sorted ascending order.
   * @return True if array contains 3 adjacent scores differing by at most 2.
   */
  public boolean scoresClump(int[] scores) {
    boolean found = false;
    for (int i = 0; i <= scores.length - 3; i++) {
      if (scores[i + 2] - scores[i] <= 2) {
        found = true;
        break;
      }
    }
    return found;
  }

  /**
   * Given an array of scores, compute the int average of the first half and the second half,
   * and return whichever is larger. We'll say that the second half begins at index length/2.
   * The array length will be at least 2. To practice decomposition, write a separate helper
   * method
   *
   * int average(int[] scores, int start, int end) { which computes the average of the elements
   * between indexes start..end. Call your helper method twice to implement scoresAverage().
   * Write your helper method after your scoresAverage() method in the JavaBat text area. Normally
   * you would compute averages with doubles, but here we use ints so the expected results are
   * exact.
   *
   * scoresAverage([2, 2, 4, 4]) → 4
   * scoresAverage([4, 4, 4, 2, 2, 2]) → 4
   * scoresAverage([3, 4, 5, 1, 2, 3]) → 4
   *
   * @param scores An array of at least length 2
   * @return The max of the average of the first vs. second half of the array.
   * @throws IllegalArgumentException If input array is less than 2 elements.
   */
  public int scoresAverage(int[] scores) throws IllegalArgumentException {
    if (scores.length < 2) {
      throw new IllegalArgumentException();
    }
    int middle = scores.length / 2;
    return Math.max(average(scores, 0, middle - 1),
        average(scores, middle, scores.length - 1));
  }
  private int average(int[] scores, int start, int end) {
    int sum = 0;
    for (int i = start; i <= end; i++) {
      sum += scores[i];
    }
    return sum / (end - start + 1);
  }

  /**
   * Given an array of strings, return the count of the number of strings with the given length.
   *
   * wordsCount(["a", "bb", "b", "ccc"], 1) → 2
   * wordsCount(["a", "bb", "b", "ccc"], 3) → 1
   * wordsCount(["a", "bb", "b", "ccc"], 4) → 0
   *
   * @param words Array of Strings.
   * @param len String length we are looking for.
   * @return Count of the number of strings with length len.
   */
  public int wordsCount(String[] words, int len) {
    int count = 0;
    for (String word : words) {
      if (word.length() == len) {
        count++;
      }
    }
    return count;
  }

  /**
   * Given an array of strings, return a new array containing the first N strings. N will
   * be in the range 1..length.
   *
   * wordsFront(["a", "b", "c", "d"], 1) → ["a"]
   * wordsFront(["a", "b", "c", "d"], 2) → ["a", "b"]
   * wordsFront(["a", "b", "c", "d"], 3) → ["a", "b", "c"]
   *
   * @param words Array of Strings.
   * @param n Number of array elements to copy.
   * @return A string array of n elements.
   */
  public String[] wordsFront(String[] words, int n) {
    return Arrays.copyOfRange(words, 0, n);
  }

  /**
   * Given an array of strings, return a new List (e.g. an ArrayList) where all the strings
   * of the given length are omitted. See wordsWithout() below which is more difficult
   * because it uses arrays.
   *
   * wordsWithoutList(["a", "bb", "b", "ccc"], 1) → ["bb", "ccc"]
   * wordsWithoutList(["a", "bb", "b", "ccc"], 3) → ["a", "bb", "b"]
   * wordsWithoutList(["a", "bb", "b", "ccc"], 4) → ["a", "bb", "b", "ccc"]
   *
   * @param words An array of strings.
   * @param len Length to filter.
   * @return A List with all the Strings of length len removed.
   */
  public List<String> wordsWithoutList(String[] words, int len) {
    ArrayList<String> filtered = new ArrayList<>();
    for (String s : words) {
      if (s.length() != len) {
        filtered.add(s);
      }
    }
    return filtered;
  }
}
