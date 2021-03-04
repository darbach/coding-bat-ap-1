package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class AP1Test {

  AP1 ap1 = new AP1();

  @Test
  void scoresIncreasing() {
    int[][] siParams = {
        {1, 3, 4},
        {1, 3, 2},
        {1, 1, 4},
        {1, 1, 2, 4, 4, 7},
        {1, 1, 2, 4, 3, 7},
        {-5, 4, 11}
    };
    boolean[] siExpected = {
        true,
        false,
        true,
        true,
        false,
        true
    };
//    System.out.println("\nRUNNING scoresIncreasing() TEST...");
    for (int i = 0; i < siParams.length; i++) {
      String param = Arrays.toString(siParams[i]);
      boolean expected = siExpected[i];
      boolean actual = ap1.scoresIncreasing(siParams[i]);
      //System.out.printf("PARAM, %s; EXPECTED, %s; ACTUAL %s%n", param, expected, actual);
      assertEquals(actual, expected);
    }
  }

  @Test
  void scores100() {
    int[][] scores100Params = {
        {1, 100, 100},
        {1, 100, 99, 100},
        {100, 1, 100, 100},
        {100, 1, 100, 1},
        {1, 2, 3, 4, 5},
        {1, 2, 100, 4, 5}
    };
    boolean[] scores100Expected = {
        true,
        false,
        true,
        false,
        false,
        false,
    };
//    System.out.println("\nRUNNING scores100() TEST...");
    for (int i = 0; i < scores100Params.length; i++) {
      String param = Arrays.toString(scores100Params[i]);
      boolean expected = scores100Expected[i];
      boolean actual = ap1.scores100(scores100Params[i]);
//      System.out.printf("PARAM, %s; EXPECTED, %s; ACTUAL %s%n", param, expected, actual);
      assertEquals(actual, expected);
    }
  }


  @Test
  void scoresClump() {
    int[][] scoresClumpParams = {
        {3, 4, 5},
        {3, 4, 6},
        {1, 3, 5, 5},
        {2, 4, 5, 6},
        {2, 4, 5, 7},
        {2, 4, 4, 7},
        {3, 3, 6, 7, 9},
        {3, 3, 7, 7, 9},
        {4, 5, 8},
    };
    boolean[] scoresClumpExpected = {
        true,
        false,
        true,
        true,
        false,
        true,
        false,
        true,
        false
    };
//    System.out.println("\nRUNNING scoresClump() TEST...");
    for (int i = 0; i < scoresClumpParams.length; i++) {
      String param = Arrays.toString(scoresClumpParams[i]);
      boolean expected = scoresClumpExpected[i];
      boolean actual = ap1.scoresClump(scoresClumpParams[i]);
//      System.out.printf("PARAM, %s; EXPECTED, %s; ACTUAL %s%n", param, expected, actual);
      assertEquals(actual, expected);
    }
  }

  @Test
  void scoresAverage() {
    int[][] scoresAverageParams = {
        {2, 2, 4, 4},
        {4, 4, 4, 2, 2, 2},
        {3, 4, 5, 1, 2, 3},
        {5, 6},
        {5, 4},
        {5, 4, 5, 6, 2, 1, 2, 3},
    };
    int[] scoresAverageExpected = {
        4,
        4,
        4,
        6,
        5,
        5
    };
//    System.out.println("\nRUNNING scoresAverage() TEST...");
    for (int i = 0; i < scoresAverageParams.length; i++) {
      String param = Arrays.toString(scoresAverageParams[i]);
      int expected = scoresAverageExpected[i];
      int actual = ap1.scoresAverage(scoresAverageParams[i]);
//      System.out.printf("PARAM, %s; EXPECTED, %s; ACTUAL %s%n", param, expected, actual);
      assertEquals(actual, expected);
    }
  }

  @Test
  void wordsCount() {
    class Param {

      public final String[] words;
      public final int length;

      public Param(String[] words, int length) {
        this.words = words;
        this.length = length;
      }

      @Override
      public String toString() {
        return String.format("%s, %d", Arrays.toString(words), length);
      }
    }
    Param[] params = {
        new Param(new String[]{"a", "bb", "b", "ccc"}, 1),
        new Param(new String[]{"a", "bb", "b", "ccc"}, 3),
        new Param(new String[]{"a", "bb", "b", "ccc"}, 4),
        new Param(new String[]{"xx", "yyy", "x", "yy", "z"}, 1),
        new Param(new String[]{"xx", "yyy", "x", "yy", "z"}, 2),
        new Param(new String[]{"xx", "yyy", "x", "yy", "z"}, 3)
    };
    int[] expectedResults = {
        2,
        1,
        0,
        2,
        2,
        1
    };
//    System.out.println("\nRUNNING wordsCount() TEST...");
    for (int i = 0; i < params.length; i++) {
      String param = params[i].toString();
      int expected = expectedResults[i];
      int actual = ap1.wordsCount(params[i].words, params[i].length);
//      System.out.printf("PARAMS: %s; EXPECTED, %s; ACTUAL %s%n", param, expected, actual);
      assertEquals(actual, expected);
    }
  }

  @Test
  void wordsFront() {
    class Param {

      public final String[] words;
      public final int length;

      public Param(String[] words, int length) {
        this.words = words;
        this.length = length;
      }

      @Override
      public String toString() {
        return String.format("%s, %d", Arrays.toString(words), length);
      }
    }
    Param[] params = {
        new Param(new String[]{"a", "b", "c", "d"}, 1),
        new Param(new String[]{"a", "b", "c", "d"}, 2),
        new Param(new String[]{"a", "b", "c", "d"}, 3),
        new Param(new String[]{"a", "b", "c", "d"}, 4),
        new Param(new String[]{"Hi", "There"}, 1),
        new Param(new String[]{"Hi", "There"}, 2)
    };
    String[][] expectedResults = {
        {"a"},
        {"a", "b"},
        {"a", "b", "c"},
        {"a", "b", "c", "d"},
        {"Hi"},
        {"Hi", "There"}
    };
//    System.out.println("\nRUNNING wordsFront() TEST...");
    for (int i = 0; i < params.length; i++) {
      String param = params[i].toString();
      String[] expected = expectedResults[i];
      String[] actual = ap1.wordsFront(params[i].words, params[i].length);
//      System.out.printf("PARAMS: %s; EXPECTED, %s; ACTUAL %s%n", param,
//          Arrays.toString(expected), Arrays.toString(actual));
      assertArrayEquals(actual, expected);
    }
  }

  @Test
  void wordsWithoutList() {
    class Param {

      public final String[] words;
      public final int length;

      public Param(String[] words, int length) {
        this.words = words;
        this.length = length;
      }

      @Override
      public String toString() {
        return String.format("%s, %d", Arrays.toString(words), length);
      }
    }
    Param[] params = {
        new Param(new String[]{"a", "bb", "b", "ccc"}, 1),
        new Param(new String[]{"a", "bb", "b", "ccc"}, 3),
        new Param(new String[]{"a", "bb", "b", "ccc"}, 4),
        new Param(new String[]{"xx", "yyy", "x", "yy", "z"}, 1),
        new Param(new String[]{"xx", "yyy", "x", "yy", "z"}, 2)
    };
    String[][] expectedResults = {
        {"bb", "ccc"},
        {"a", "bb", "b"},
        {"a", "bb", "b", "ccc"},
        {"xx", "yyy", "yy"},
        {"yyy", "x", "z"}
    };
//    System.out.println("\nRUNNING wordsFront() TEST...");
    for (int i = 0; i < params.length; i++) {
      String param = params[i].toString();
      String[] expected = expectedResults[i];
      List<String> actualList = ap1.wordsWithoutList(params[i].words, params[i].length);
      String[] actual = new String[actualList.size()];
      actual = actualList.toArray(actual);
//      System.out.printf("PARAMS: %s; EXPECTED, %s; ACTUAL %s%n", param,
//          Arrays.toString(expected), Arrays.toString(actual));
      assertArrayEquals(actual, expected);
    }
  }
}