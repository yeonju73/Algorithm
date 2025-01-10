import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_24444 {

    public static int[] bfs(ArrayList<ArrayList<Integer>> graph, int startNode){
        int[] visited = new int[graph.size()];
        int order = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = order++;

        while(!queue.isEmpty()){
            ArrayList<Integer> currentNode = graph.get(queue.poll());
            currentNode.sort(Integer::compareTo);

            for (Integer node : currentNode) {
                if (visited[node] == 0) {
                    visited[node] = order++;
                    queue.add(node);
                }
            }
        }
        return visited;
    }

    public static void putEdge(ArrayList<ArrayList<Integer>> graph, int from, int to){
        graph.get(from).add(to);
        graph.get(to).add(from); // 양방향 간선
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 정점 수, 간선 수, 시작 정점
        String s = in.readLine();
        st = new StringTokenizer(s);

        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken()) - 1;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(nodeNum);

        for (int i = 0; i < nodeNum; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeNum; i++) {
            s = in.readLine();
            st = new StringTokenizer(s);
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            putEdge(graph, from, to);
        }

        int[] visited = bfs(graph, startNode);

        for (int i = 0; i < nodeNum; i++){
            out.write(visited[i] + "\n");
        }
        out.flush();
        out.close();
        in.close();
    }
}
