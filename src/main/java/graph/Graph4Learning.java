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

    void bfs(int s, int t) {
        // 初始化 boolean[] visited, queue, int[] pre;
        // 从queue中取出一个元素w，循环w的邻接表内元素，
            // 如果元素q还没有访问到，记录下prev[q]=v;
                //  如果元素==t, 完成查找，打印出顺讯，
                //  如果元素!=t, visited[q]=true, queue.add().,
        //  直到queue没有元素为止
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList();
        int[] prev = new int[v];
        visited[s] = true;
        for (int i=0;i<v;i++) {
            prev[i] = -1;
        }

        Integer w = queue.poll();
        while (queue.size() != 0) {
            for (int i=0; i<adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    prev[q] = w;
                    if (q == t) {
                        //print
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }



}
