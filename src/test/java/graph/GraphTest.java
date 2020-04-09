package graph;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author toby Zhang
 * @date 2020-04-02 18:14
 * @description
 */
public class GraphTest {

    /**
     *
     * @throws Exception
     */
    @Test
    public void testBFS() throws Exception {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);

        graph.bfs(0, 6);
    }


    @Test
    public void testDFS() throws Exception {
        Graph graph = new Graph(8);
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);

        graph.dfs(0, 6);
    }


}