public class _042TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int lo = 0, hi = height.length -1, leftMax = height[lo], rightMax = height[hi];
        int total = 0;
        while(lo < hi){
            if (leftMax <= rightMax){
                total += leftMax - height[lo];
                lo += 1;
                leftMax = Math.max(leftMax, height[lo]);
            }else{
                total += rightMax - height[hi];
                hi -= 1;
                rightMax = Math.max(rightMax, height[hi]);
            }

        }
        return total;
    }
}
