package edu.cnm.deepdive;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
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
    System.out.println("\nRUNNING scoresIncreasing() TEST...");
    for (int i = 0; i < siParams.length; i++) {
      String param = Arrays.toString(siParams[i]);
      boolean expected = siExpected[i];
      boolean actual = ap1.scoresIncreasing(siParams[i]);
      System.out.printf("PARAM, %s; EXPECTED, %s; ACTUAL %s%n",
          param, expected, actual);
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
    System.out.println("\nRUNNING scores100() TEST...");
    for (int i = 0; i < scores100Params.length; i++) {
      String param = Arrays.toString(scores100Params[i]);
      boolean expected = scores100Expected[i];
      boolean actual = ap1.scores100(scores100Params[i]);
      System.out.printf("PARAM, %s; EXPECTED, %s; ACTUAL %s%n",
          param, expected, actual);
      assertEquals(actual, expected);
    }
  }
}