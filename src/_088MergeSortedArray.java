public class _088MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0;
        int j = 0;
        int[] nums1_ = new int[nums1.length];
        while (i < m &&j < n){
            if (nums1[i] < nums2[j]){
                nums1_[i+j] = nums1[i];
                i += 1;
            }else{
                nums1_[i+j] = nums2[j];
                j += 1;
            }
        }
        if(i == m){
            while(j < n){
                nums1_[i + j] = nums2[j];
                j += 1;
            }
        }else{
            while(i < m){
                nums1_[i + j] = nums1[i];
                i += 1;
            }

        }
        for (int v = 0; v < m + n; v++){
            nums1[v] = nums1_[v];
        }
    }
}
