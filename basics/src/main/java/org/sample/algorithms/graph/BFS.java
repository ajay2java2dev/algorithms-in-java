package org.sample.algorithms.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

    static class Graph {

        int V;
        LinkedList adjList[];

        public Graph(int V) {
            this.V = V;
            this.adjList = new LinkedList[V];

            for (int i = 0; i<adjList.length; i++) {
                LinkedList<Integer> linkedList = new LinkedList();
                adjList[i] = linkedList;
            }
        }

        public boolean addEdge(int src, int dst) {
            adjList[src].add(dst);
            return true;
        }

        public void traverseBFS (int source) {
            if (source > -1) {

                boolean visited [] = new boolean[V];//array indexes are as per the index assigned to the graph values
                visited[source] = true;

                LinkedList<Integer> queue = new LinkedList();
                queue.add(source);

                while (queue.size() > 0) {

                    source = queue.poll();
                    System.out.println(source + " Vertex");

                    Iterator<Integer> iterator = adjList[source].listIterator();

                    while (iterator.hasNext()) {
                        int n = iterator.next();

                        if (!visited[n]) {
                            visited[n] = true;
                            queue.add(n);
                            //add you logic here.

                            //IDDFS can help in both DFS and BFS integration by controlling the depth of the traversal as well as check the immediate neighbours
                        }
                    }
                }
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

        g.traverseBFS(0);

    }


}
