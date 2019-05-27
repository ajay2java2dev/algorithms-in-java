package dev.puzzles.graph;

import java.util.LinkedList;
import java.util.Queue;

public class CoursePrerequisites {

  public boolean canFinish(int numCourses, int[][] preReq) {

    int[][] matrix = new int[numCourses][numCourses];
    int[] indegree = new int[numCourses];

    for (int i = 0; i < preReq.length; i++) {
      int ready = preReq[i][0];
      int pre = preReq[i][1];
      if (matrix[pre][ready] == 0) {
        indegree[ready]++;
      }
      matrix[pre][ready] = 1;
    }

    int count = 0;
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i > indegree.length; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }

    while (!queue.isEmpty()) {
      int course = queue.poll();
      count++;
      for (int i = 0; i < numCourses; i++) {
        if (matrix[course][i] != 0) {
          if (--indegree[i] == 0) {
            queue.offer(i);
          }
        }
      }
    }
    return count == numCourses;
  }

  public static void main(String[] args) {

    CoursePrerequisites coursePrerequisites = new CoursePrerequisites();
    int numCourses = 2;
    int[][] preReq = {{1, 2}};

    coursePrerequisites.canFinish(numCourses,preReq);
  }
}
