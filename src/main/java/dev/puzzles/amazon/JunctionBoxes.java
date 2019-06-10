package dev.puzzles.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


//Actual Test Id: 23280666247798
public class JunctionBoxes {

  public static List<String> orderedJunctionBoxes(int numberOfBoxes, List<String> boxList) {
    // WRITE YOUR CODE HERE
    List<String> newGenBoxes = new ArrayList<String>();
    List<String> oldGenBoxes = new ArrayList<String>();

    if (numberOfBoxes > 0 && boxList != null && !boxList.isEmpty()) {

      // iterate to find the oldest boxes first
      for (int i = 0; i < numberOfBoxes; i++) {
        String box = boxList.get(i);
        String firstContent = box.substring(0, box.indexOf(' '));
        String secondContent = box.substring(box.indexOf(' ') + 1);

        char[] secondContentArr = secondContent.toCharArray();
        if (Character.isLetter(secondContentArr[0])) {
          oldGenBoxes.add(box);
        } else if (Character.isDigit(secondContentArr[0])) {
          newGenBoxes.add(box);
        }
      }

      Collections.sort(
          oldGenBoxes,
          new Comparator<String>() {
            @Override
            public int compare(String box1, String box2) {
              if (box1.compareTo(box2) != 0) {
                return box1.compareTo(box2);
              } else {

                String secondContent1 = box1.substring(box1.indexOf(' ') + 1);
                String secondContent2 = box2.substring(box2.indexOf(' ') + 1);

                return secondContent1.compareTo(secondContent2);
              }
            }
          });

      oldGenBoxes.addAll(newGenBoxes);
    }

    return oldGenBoxes;
  }

  public static void main(String[] args) {
    int a = 4;
    List<String> strings = new ArrayList<>();
    strings.add("m12 jog mid pet");
    strings.add("wz3 34 54 398");
    strings.add("a1 alps cow bar");
    strings.add("x4 45 21 7");
    orderedJunctionBoxes(a, strings);
  }
}
