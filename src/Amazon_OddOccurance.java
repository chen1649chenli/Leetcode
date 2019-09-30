public class Amazon_OddOccurance {
    int getOdd(int[] arr){
        int ans = 0;
        for (int i: arr){
            ans ^= i;
        }
        return ans;
    }
}
