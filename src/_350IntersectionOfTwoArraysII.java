import java.util.*;

public class _350IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int size1 = nums1.length;
        for (int i = 0; i < size1; i += 1){
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        int size2 = nums2.length;
        for (int j = 0; j < size2; j += 1){
            if (map.containsKey(nums2[j])){
                stack.push(nums2[j]);
                if (map.get(nums2[j]) == 1){
                    map.remove(nums2[j]);
                }else{
                    map.put(nums2[j],map.get(nums2[j]) -1);
                }

            }
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int k = 0; k < size; k += 1){
            res[k] = stack.pop();
        }
        return res;
    }
}
