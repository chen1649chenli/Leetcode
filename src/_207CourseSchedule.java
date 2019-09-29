import java.util.List;

public class _207CourseSchedule {
    boolean[] visited;
    boolean[] onStack;
    boolean hasCycle;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj= new List[numCourses];
        for (int i = 0; i < numCourses; i += 1){
            adj[i] = new ArrayList<>();
        }
        for (int[] pair: prerequisites){
            adj[pair[1]].add(pair[0]);
        }
        visited = new boolean[numCourses];
        onStack = new boolean[numCourses];

        for (int v = 0; v < numCourses; v += 1){
            dfs(adj, visited, v, onStack);
        }
        return !hasCycle;
    }

    private void dfs(List<Integer>[] adj, boolean[] visited, int v, boolean[] onStack){
        visited[v] = true;
        onStack[v] = true;
        for (int w: adj[v]){
            if (this.hasCycle){
                return;
            }else if (!visited[w]){
                dfs(adj, visited, w, onStack);
            }else if(onStack[w]){
                this.hasCycle = true;
                return;
            }
        }
        onStack[v] = false;
    }
}
