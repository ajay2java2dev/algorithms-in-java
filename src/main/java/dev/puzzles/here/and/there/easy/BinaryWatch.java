package dev.puzzles.here.and.there.easy;

import java.util.ArrayList;
import java.util.List;

/*
Problem Statement: given an input (num) which represents the number of bits being ON,
create a binary watch which showcases hours <= 11 and minutes <=59.

We can consider this as a 64 bit digital watch since the minutes would range from 0 to 59.
*/
public class BinaryWatch {

  /**
   * Approach: 1) We first need to interate over all the hours and their respective minutes. 2) For
   * each hour , convert it into digital minutes and take the sum. 3) For the sum, then get the bit
   * value using Integer.bitCount ( )
   *
   * @param num
   * @return
   */
  public static List<String> bitWatch(int num) {
    List<String> list = new ArrayList<>();

    if (num <= 0 || num >= 60) {
      return null;
    }

    for (int i = 0; i <= 11; i++) {
      for (int j = 0; j <= 59; j++) {
        int bitValue = Integer.bitCount(i * 64 + j); //TODO: Find out why 64 ???
        if (bitValue == num) {
          list.add(String.format("%d:%02d", i, j));
        }
      }
    }

    return list;
  }

  public static void main(String[] args) {
	  List<String> bitList = bitWatch(1);

	  for (int i = 0; i < bitList.size(); i++) {
        System.out.println(bitList.get(i));
	  }
  }
}
