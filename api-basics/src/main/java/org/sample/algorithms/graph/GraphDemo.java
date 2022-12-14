package org.sample.algorithms.graph;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;

public class GraphDemo {

  static class NetworkGraph {

    int vertex;
    LinkedList<Integer> myNetwork[]; // adjacency list representation.

    // constructor to initilize the graph and elements internally
    NetworkGraph(int vertex) {
      this.vertex = vertex;
      myNetwork = new LinkedList[vertex];

      for (int i = 0; i < vertex; i++) {
        myNetwork[i] = new LinkedList<>();
      }
    }
  }

  static void addVertexEdge(NetworkGraph myGraph, int edgeStart, int edgeEnd) {
    myGraph.myNetwork[edgeStart].add(edgeEnd);
    myGraph.myNetwork[edgeEnd].add(edgeStart); // is this representing a undirected graph
  }

  static void outputGraph(NetworkGraph myGraph) {
    System.out.println("\nVertex");
    System.out.println("Head\tConnections");

    for (int i = 0; i < myGraph.vertex; i++) {
      System.out.print(i + "\t\t");
      for (Integer traverseGraph : myGraph.myNetwork[i]) {
        System.out.print(" ->" + traverseGraph);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Instant start = Instant.EPOCH;
    int vertex = 9;
    NetworkGraph myNetworkGraph = new NetworkGraph(vertex);
    addVertexEdge(myNetworkGraph, 0, 3);
    addVertexEdge(myNetworkGraph, 0, 4);
    addVertexEdge(myNetworkGraph, 0, 7);
    addVertexEdge(myNetworkGraph, 1, 2);
    addVertexEdge(myNetworkGraph, 1, 3);
    addVertexEdge(myNetworkGraph, 1, 5);
    addVertexEdge(myNetworkGraph, 1, 8);
    addVertexEdge(myNetworkGraph, 5, 2);
    addVertexEdge(myNetworkGraph, 6, 7);
    addVertexEdge(myNetworkGraph, 6, 8);
    addVertexEdge(myNetworkGraph, 6, 0);

    Instant end = Instant.now();
    System.out.println("\nTime elapsed: " + Duration.between(start, end).toNanos() + " nanos");
    outputGraph(myNetworkGraph);
  }
}
