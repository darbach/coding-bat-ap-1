package edu.cnm.deepdive;

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
}
