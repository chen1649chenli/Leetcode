public class AmazonOA_RollDice {
    public int rollDice(int[] arr){
        int size = arr.length;
        int[] count = new int[6];
        for (int i : arr){
            count[i - 1] += 1;
        }
        int minRoll = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i += 1){
            int res = size - count[i] + count[6 - 1 - i];
            minRoll = Math.min(res, minRoll);
        }
        return minRoll;
    }
}
