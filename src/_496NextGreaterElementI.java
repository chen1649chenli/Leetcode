public class _496NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /** handle corner case when nums1 is an empty array */
        if (nums1 == null || nums1.length == 0) return new int[]{};

        /** create the return array */
        int[] ans = new int[nums1.length];

        /** use the helper function to get the next greater element */
        for (int i = 0; i < nums1.length; i += 1){
            ans[i] = helper(nums1[i], nums2);
        }

        return ans;
    }

    public int helper(int x, int[] arr){
        boolean flag  = false;
        for (int i = 0; i < arr.length; i += 1){
            if (arr[i] == x) flag = true;
            if (arr[i] > x && flag) return arr[i];
        }
        return -1;
    }
}
