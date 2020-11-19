package uet.oop.bomberman.entities;

import edu.princeton.cs.algs4.Graph;

/**
 * Created by hello on 11/19/2020.
 */
public class DFS {
    public static void main(String[] strings){
        Graph g = new Graph(86);
        g.addEdge(0, 1);
        g.addEdge(0, 29);

        g.addEdge(1, 2);

        for(int w : g.adj(0)){
            System.out.println(0 + "-" + w);
        }

    }
}
