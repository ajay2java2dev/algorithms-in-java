package org.sample.algorithms.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS {

    static class Graph {

        int V;
        LinkedList adjList[];

        public Graph(int V) {
            this.V = V;
            this.adjList = new LinkedList[V];

            for (int i = 0; i<adjList.length; i++) {
                LinkedList linkedList = new LinkedList();
                adjList[i] = linkedList;
            }
        }

        public boolean addEdge(int src, int dst) {
            adjList[src].add(dst);
            return true;
        }


        public void DFSUtil (int V, boolean visited[]) {

            visited[V] = true;
            // there is no queue implementation here.

            System.out.println(V + " Visited");
            Iterator<Integer> i = adjList[V].listIterator();

            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    DFSUtil(n, visited);

                    //IDDFS can help in both DFS and BFS integration by controlling the depth of the traversal as well as check the immediate neighbours
                }
            }
        }


        public void traverseDFS (int source) {
            if (source > -1) {
                boolean visited [] = new boolean[V];//array indexes are as per the index assigned to the graph values
                DFSUtil(source,visited);
            }
        }
    }


    public static void main(String[] args) {
        Graph g  = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(0,4);

        g.traverseDFS(0);

    }


}
