public class _852PeakIndex {
    public int peakIndexInMountainArray(int[] A) {
        int start = 0, end = A.length - 1;
        int ans = 0;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1]){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }
}
