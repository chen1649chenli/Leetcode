import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _973KClosestPoints {
    public int[][] kClosest(int[][] points, int K) {
        int low = 0, high = points.length - 1;
        quickSelect(points, low, high, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void quickSelect(int[][] points, int l, int h, int K){
        if (l == h) return;
        int pos = partition(points, l, h);
            if (pos == K){
                return;
            } else if(pos > K){
                quickSelect(points, l, pos - 1, K);
            } else{
                quickSelect(points, pos + 1, h, K);
            }
    }

    private int partition(int[][] points, int l, int h){
        int[] pivot = points[l];
        int pIndex = l;
        swap(points, l, h);
        for (int i = l; i < h; i++){
            if (compare(points[i], pivot) < 0){
                swap(points, pIndex, i);
                pIndex++;
            }
        }
        swap(points, pIndex, h);
        return pIndex;
    }

    private void swap(int[][] points, int l, int h){
        int[] swapTmp = points[l];
        points[l] = points[h];
        points[h] = swapTmp;
    }

    private int compare(int[] a, int[] b){
        return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1];
    }
}
