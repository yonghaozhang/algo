package graph;


import java.util.LinkedList;
import java.util.Queue;

public class Graph4Learning {

    private boolean found = false;

    private static final int UNVISITED = -1;

    private int v;

    private LinkedList<Integer> adj[];

    public Graph4Learning(int v) {
        this.v = v;
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);

    }

    public void bfs(int s, int t) {
        if (s == t) return;
        //初始化
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i=0; i<v; i++ ){
            prev[i] = UNVISITED;
        }

        while (queue.size()!=0) {
           Integer w = queue.poll();
           for (int i=0; i< adj[w].size(); i++) {
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


    public void dfs(int s, int t) {
        int[] prev = new int[v];
        boolean[] visit = new boolean[v];
        for (int i=0; i<v; i++) {
            prev[i] = UNVISITED;
        }



    }


    private void recDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found) return;
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i=0; i<adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recDfs(q, t, visited, prev);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t]!=UNVISITED && t!=s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

}
