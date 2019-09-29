import java.util.*;

public class _210CourseScheduleII {
    boolean hasCycle;
    boolean[] onStack;
    boolean[] visited;
    List<Integer>[] adj;
    Stack<Integer> reversePost;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        onStack = new boolean[numCourses];
        visited = new boolean[numCourses];
        reversePost = new Stack<>();
        adj = new List[numCourses];
        for (int i = 0; i < numCourses; i += 1){
            adj[i] = new ArrayList<>();
        }
        for (int[] pair: prerequisites){
            adj[pair[1]].add(pair[0]);
        }
        for (int v = 0; v < numCourses; v += 1){
            if (!visited[v])  dfs(adj, v);
            if (hasCycle) return new  int[]{};
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while (!reversePost.isEmpty()){
            ans[idx] = reversePost.pop();
            idx += 1;
        }
        return ans;
    }

    private void dfs(List<Integer>[] adj, int v){
        visited[v] = true;
        onStack[v] = true;
        for (int w: adj[v]){
            if (hasCycle) return;
            if(!visited[w]){
                dfs(adj, w);
            }else if (onStack[w]){
                hasCycle = true;
                return;
            }
        }
        reversePost.push(v);
        onStack[v] = false;
    }
}
