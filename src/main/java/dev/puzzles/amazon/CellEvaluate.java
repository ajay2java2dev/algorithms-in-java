package dev.puzzles.amazon;

import java.util.ArrayList;
import java.util.List;

public class CellEvaluate {

  public List<Integer> cellCompete(int[] states, int days) {
    // WRITE YOUR CODE HERE
    List<Integer> finalCellState = new ArrayList<Integer>();

    if (states != null && states.length > 0 && days > 0) {

      // iterate over given state of the cells and save init state
      int[] currTmpState = new int[states.length - 1];

      for (int i = 0; i < states.length - 1; i++) {
        currTmpState[i] = states[i];
      }

      // iterate for each day
      for (int j = days; j > 0; j--) {

        // setting first cells and the last cells and interchange
        currTmpState[0] = 0 ^ states[1];
        currTmpState[states.length - 1] = 0 ^ states[states.length - 2];

        // now compute for 1 to (states - 2) houses
        for (int i = 1; i < states.length - 2; i++) {
          currTmpState[i] = states[i - 1] ^ states[i + 1];
        }

        // update the states for next day once computation is over
        for (int i = 0; i < states.length - 1; i++) {
          states[i] = currTmpState[i];
        }
      }

      for (int i = 0; i < states.length - 1; i++) {
        finalCellState.add(currTmpState[i]);
      }
    }

    return finalCellState;
  }
}
