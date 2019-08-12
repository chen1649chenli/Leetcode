import java.util.*;

public class _078Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>());
        q.add(null);

        for (int i = 0; i < nums.length; i++){
            if (q.peek() == null) q.poll();
            while(q.peek() != null){
                List<Integer> list = q.poll();
                q.add(new ArrayList<>(list));
                list.add(nums[i]);
                q.add(new ArrayList<>(list));
            }
            q.add(null);
        }
        for (List<Integer> list: q){
            if (list != null){
                ans.add(list);
            }
        }
        return ans;
    }
}
