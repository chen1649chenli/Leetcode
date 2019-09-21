import java.util.*;

public class AmazonOA_CriticalConnections {
    private int id;
    private int[] ids;
    private int[] low;
    private List<Integer>[] graph;

    public List<List<Integer>> findBridges(int n, int[][] edges) {
        List<List<Integer>> bridges = new ArrayList<>();
        graph = buildGraph(n, edges);
        ids = new int[n + 1];
        low = new int[n + 1];
        id = 1;
        visit(1, -1, bridges);
        return bridges;
    }

    private void visit(int at, int parent, List<List<Integer>> bridges){
        low[at] = id;
        ids[at] = id;
        id += 1;

        for(int to: graph[at]){
            if (to == parent) continue;
            if(ids[to] == 0){// has not visited
                visit(to, at, bridges);
                low[at] = Math.min(low[at], low[to]);
                if (ids[at] < low[to]){
                    bridges.add(Arrays.asList(at, to));
                }
            }else{
                low[at] = Math.min(low[at], low[to]);
            }
        }
    }

    private List<Integer>[] buildGraph(int n, int[][] edges){
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i <= n; i += 1){
            graph[i] = new ArrayList<>();
        }
        for (int[] edge: edges){
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }

    public static void main(String[] args){
        int n = 5; int[][] edges = new int[][]{{1,2}, {1, 3}, {3, 4}, {1, 4}, {4, 5}};
        AmazonOA_CriticalConnections app =  new AmazonOA_CriticalConnections();
        List<List<Integer>> res = app.findBridges(n, edges);
        for (List<Integer> ans: res){
            System.out.println(ans.get(0) + "-" + ans.get(1));
        }
        System.out.println("---------------------------------");
        n = 6; edges = new int[][]{{1,2}, {1, 3}, {2, 3}, {2, 4}, {2, 5}, {4, 6}, {5, 6}};
        res = app.findBridges(n, edges);
        for (List<Integer> ans: res){
            System.out.println(ans.get(0) + "-" + ans.get(1));
        }
        System.out.println("---------------------------------");
        n = 9; edges = new int[][]{{1, 2}, {1, 3}, {2, 3}, {3, 4}, {3, 6}, {4, 5}, {6, 7}, {6, 9}, {7, 8}, {8, 9}};
        res = app.findBridges(n, edges);
        for (List<Integer> ans: res){
            System.out.println(ans.get(0) + "-" + ans.get(1));
        }
        System.out.println("---------------------------------");
    }
}
