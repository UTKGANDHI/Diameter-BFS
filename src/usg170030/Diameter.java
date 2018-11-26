package usg170030;

import rbk.BFSOO;
import rbk.Graph;

import java.io.File;
import java.util.Scanner;
import rbk.Graph.Vertex;

import static rbk.BFSOO.breadthFirstSearch;


public class Diameter {

    /**
     * diameter : calculates the diameter of a given graph using BFS algorithm
     * @param g
     * @return diameter of the graph
     */
    public static int diameter(Graph g) {

        Vertex maxVertex = null;
        int max  = 0;

        BFSOO b = breadthFirstSearch(g, g.getVertex(1));

        for(Vertex u: g) {
            maxVertex = u;
            max = Math.max(max, b.getDistance(u));
        }

        breadthFirstSearch(g, maxVertex);

        int dia  = 0;
        for(Graph.Vertex u: g) {
            dia = Math.max(max, b.getDistance(u));
        }
        return dia;
    }

    public static void main(String[] args) throws Exception {
        String string = "8 7   1 2 2   1 3 3   2 4 5   2 5 4   4 6 1   5 7 1   7 8 2  0";
        Scanner in;
        // If there is a command line argument, use it as file from which
        // input is read, otherwise use input from string.
        in = args.length > 0 ? new Scanner(new File(args[0])) : new Scanner(string);
        // Read graph from input
        Graph g = Graph.readDirectedGraph(in);
        int s = in.nextInt();
        g.printGraph(false);

        System.out.println("The Diameter of Graph is: " + Diameter.diameter(g));

    }
}
