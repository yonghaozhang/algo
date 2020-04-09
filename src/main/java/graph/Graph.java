package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author toby Zhang
 * @date 2020-04-02 15:24
 * @description
 */
public class Graph {

    private int v; // vertex 顶点下标 0， 1，2，3....
    private LinkedList<Integer> adj[]; // 用邻接表表示图

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }


    /**
     * 添加边
     *
     * @param s 顶点
     * @param t 顶点
     */
    public void addEdge(int s, int t) {  // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先算法
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (s == t) return;
       // ------- 初始化 visited, queue, prev ------//
        boolean[] visited = new boolean[v]; // visited是用来记录已经被访问的顶点，避免顶点被重复访问。
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<Integer>(); // queue 是一个队列，用来存储已经被访问，但相连的顶点还没有被访问的顶点。
        queue.add(s);
        int[] prev = new int[v]; // 记录搜索路径
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        // -------------------------------------//
        while (queue.size() != 0) {
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); ++i) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        this.print(prev, s, t);
                        return;
                    }else {
                        visited[q] = true;
                        queue.add(q);
                    }
                }
            }
        }
    }

    //-------------------------------------------

    boolean found = false; // 全局变量或者类成员变量。当找到终止点t后，我们就不再递归继续查找。

    /**
     * 深度有限算法
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        // ========= 初始化 ===========
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        //=============================
        this.recurDfs(s, t, visited, prev);
        print(prev, s, t);

    }


    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }


    /**
     * 递归打印出s ---> t 的路径
     * @param prev
     * @param s
     * @param t
     */
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s,  prev[t]);
        }
        System.out.println(t + " ");
    }

}









