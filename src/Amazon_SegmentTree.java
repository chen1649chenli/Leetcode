public class SegmentTree {
    int[] st;
    int arrLength;

    void constructST(int[] arr){
        int height = (int)(Math.ceil(Math.log(arr.length)/Math.log(2)));
        int size = (int) Math.pow(2, height + 1) - 1;
        st = new int[size];
        constructSTHelper(arr, 0, arr.length - 1, 0);
    }

    void constructSTHelper(int[] arr, int lo, int hi, int curr){
        this.arrLength = arr.length;
        if (lo == hi){
            st[curr] = arr[lo];
            return;
        }
        int mid = (hi - lo) / 2 + lo;
        constructSTHelper(arr, lo, mid, curr * 2 + 1);
        constructSTHelper(arr, mid + 1, hi, curr * 2 + 2);
        st[curr] = minVal(st[curr * 2 + 1], st[curr * 2 + 2]);
    }

    int query(int qs, int qe){

        return queryHelper(qs, qe, 0, arrLength - 1, 0);

    }

    int queryHelper(int qs, int qe, int lo, int hi, int curr){
        if (lo >= qs && hi <= qe) return st[curr];
        if (hi < qs || lo > qe) return Integer.MAX_VALUE;

        int mid = (hi - lo) / 2 + lo;
        return minVal(queryHelper(qs, qe, lo, mid, curr * 2 + 1),
                queryHelper(qs, qe, mid + 1, hi, curr * 2 + 2));
    }

    int minVal(int x, int y){
        return (x < y)? x: y;
    }

    public static void main(String[] args){
        int[] data = new int[]{-1, 2, 4, 0};
        SegmentTree app = new SegmentTree();
        app.constructST(data);
        System.out.println(app.query(1, 2));
    }
}
