public class _004MedianOfTwoSortedArrays {
    //solution 1: brutal force. O(m + n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[len1 + len2];
        int a = 0, b = 0, i = 0;
        while(a < len1 && b < len2){
            if (nums1[a] <= nums2[b]){
                arr[i++] = nums1[a++];
            }else{
                arr[i++] = nums2[b++];
            }
        }
        if (a == len1){
            while(b < len2){
                arr[i++] = nums2[b++];
            }
        }else{
            while(a < len1){
                arr[i++] = nums1[a++];
            }
        }

        if ((len1 + len2) % 2 ==1){
            return 1.0 * arr[(len1 + len2 - 1)/2];
        }else{
            int idx = (len1 + len2) / 2;
            return (arr[idx] * 0.5 + arr[idx - 1] * 0.5);
        }
    }
}
