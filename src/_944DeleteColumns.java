public class _944DeleteColumns {
    public int minDeletionSize(String[] A) {
        int length = A[0].length();
        int num = A.length;
        int count = 0;
        for (int i = 0; i < length; i += 1){
            for (int j = 1; j < num; j += 1){
                if (A[j].charAt(i) < A[j - 1].charAt(i)){
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }
}
