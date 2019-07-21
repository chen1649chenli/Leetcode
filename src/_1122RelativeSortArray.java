import java.util.*;

public class _1122RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] dict = new int[1001];
        for (int i : arr1){
            dict[i] += 1;
        }
        int pointer = 0;
        for (int j : arr2){
            while(dict[j] > 0){
                arr1[pointer++] = j;
                dict[j] -= 1;
            }
        }
        for (int k = 0; k < dict.length; k += 1){
            while (dict[k] > 0){
                arr1[pointer++] = k;
                dict[k] -= 1;
            }
        }
        return arr1;
    }
}
