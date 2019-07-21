import java.util.Arrays;

public class _108ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int h){
        if (l > h){
            return null;
        }

        int mid = l + (h - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, l, mid - 1);
        node.right = helper(nums, mid + 1, h);
        return node;
    }
}
