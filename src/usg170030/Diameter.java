/**
 * @author;
 *          1. Utkarsh Gandhi (usg170030)
 *          2. Rutuja Kaushike (rnk170000)
 */
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
        BFSOO b = breadthFirstSearch(g, g.getVertex(1));
        int max = 0;
        Vertex src = null;
        int distance = 0;

        for (Vertex u : g) {
            distance  = b.getDistance(u);
            if (max < distance) {
                src = u;
                max = distance;
            }
        }

        b = breadthFirstSearch(g, src);
        int diameter = 0;

        for (Vertex u : g) {
            diameter = Math.max(diameter, b.getDistance(u));
        }

        return diameter;
    }

    public static void main(String[] args) throws Exception {
        String string = "8 7   1 2 1   1 3 1   2 4 1   2 5 1   4 6 1   5 7 1   7 8 1  0";
        Scanner in;
        // If there is a command line argument, use it as file from which
        // input is read, otherwise use input from string.
        in = args.length > 0 ? new Scanner(new File(args[0])) : new Scanner(string);
        // Read graph from input
        Graph g = Graph.readGraph(in);
        int s = in.nextInt();
        g.printGraph(false);

        System.out.println("The Diameter of Graph is: " + Diameter.diameter(g));

    }
}
