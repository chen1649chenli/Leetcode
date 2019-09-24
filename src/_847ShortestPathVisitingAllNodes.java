import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _847ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        int size = graph.length;
        Queue<Path> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int fullMask = (1<< size) - 1;

        for (int i = 0; i < size; i += 1){
            Path path = new Path(i, 1<<i);
            q.offer(path);
            visited.add(path.toString());
        }
        q.offer(null);
        int step = 0;
        while(q.size() > 1){
            Path path = q.poll();
            if (path == null){
                q.offer(null);
                step += 1;
                continue;
            }
            if (path.mask == fullMask){
                return step;
            }

            for (int nextNode: graph[path.currNode]){
                Path nextPath = new Path(nextNode, path.mask | 1<<nextNode);
                if (!visited.contains(nextPath.toString())){
                    q.offer(nextPath);
                    visited.add(nextPath.toString());
                }
            }
        }
        return step;
    }


    class Path {
        int mask;
        int  currNode;

        public Path(int currNode, int mask){
            this.mask = mask;
            this.currNode = currNode;
        }

        public String toString(){
            return this.currNode + "" + this.mask;
        }
    }
}
