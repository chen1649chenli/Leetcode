public class _004MedianOfTwoSortedArrays {
    //solution 1: brutal force. O(m + n)
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
////        int len1 = nums1.length;
////        int len2 = nums2.length;
////        int[] arr = new int[len1 + len2];
////        int a = 0, b = 0, i = 0;
////        while(a < len1 && b < len2){
////            if (nums1[a] <= nums2[b]){
////                arr[i++] = nums1[a++];
////            }else{
////                arr[i++] = nums2[b++];
////            }
////        }
////        if (a == len1){
////            while(b < len2){
////                arr[i++] = nums2[b++];
////            }
////        }else{
////            while(a < len1){
////                arr[i++] = nums1[a++];
////            }
////        }
////
////        if ((len1 + len2) % 2 ==1){
////            return 1.0 * arr[(len1 + len2 - 1)/2];
////        }else{
////            int idx = (len1 + len2) / 2;
////            return (arr[idx] * 0.5 + arr[idx - 1] * 0.5);
////        }
////    }

    //solution 2: use binary search

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int x = nums1.length;
        int y = nums2.length;
        int lo = 0, hi = x;
        while(lo <= hi){
            int posX = (hi - lo) / 2 + lo;
            int posY = (x + y + 1) / 2 - posX;

            int maxLeftX = (posX == 0) ? Integer.MIN_VALUE : nums1[posX - 1];
            int minRightX = (posX == x) ? Integer.MAX_VALUE : nums1[posX];

            int maxLeftY = (posY == 0) ? Integer.MIN_VALUE : nums2[posY - 1];
            int minRightY = (posY == y) ? Integer.MAX_VALUE : nums2[posY];

            if (maxLeftX <= minRightY && minRightX >= maxLeftY){
                if ((x + y) % 2 == 1){
                    return (double) Math.max(maxLeftX, maxLeftY);
                } else{
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                }
            }else if(maxLeftX > minRightY){
                hi = posX - 1;
            }else{
                lo = posX + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}
