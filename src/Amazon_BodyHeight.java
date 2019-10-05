/* 给一个数组,代表一组人的身高。然后输出一个数组,表示在当前人之后的所有 比他高的人里,
离他最近的人的身高。比如输入是[3, 6, 7, 2, 3] 输出就是[6, 7, null, 3, null]。
我给出了俩解,都是O(n2)的。她希望得到一个O(n)的解 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Amazon_BodyHeight {
    public int[] find(int[] nums){
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i -= 1){
            if (stack.isEmpty()){
                ans[i] = -1;

            }else{
                while(!stack.isEmpty() && stack.peek() <= nums[i]){
                    stack.pop();
                }
                if (stack.isEmpty()){
                    ans[i] = -1;
                }else{
                    ans[i] = stack.peek();
                }
            }
            stack.push(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = new int[]{3, 6, 7, 2, 3};
        Amazon_BodyHeight app = new Amazon_BodyHeight();
        int[] ans = app.find(nums);
        for (int i: ans){System.out.println(i);}
    }
}
