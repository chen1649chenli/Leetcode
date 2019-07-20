public class _682BaseballGame {
    public int calPoints(String[] ops) {
        if (ops == null || ops.length == 0) return 0;
        int[] score = new int[ops.length];
        int pointer = 0;

        for (String str: ops){
            if (str.equals("C")){
                score[pointer -1] = 0;
                pointer -= 2;
            } else if(str.equals("D")){
                score[pointer] = 2 * score[pointer - 1];
            } else if(str.equals("+")){
                score[pointer] = score[pointer - 1] + score[pointer - 2];
            } else{
                score[pointer] = Integer.parseInt(str);
            }
            pointer += 1;
        }
        int sum = 0;
        for (int a = 0; a < pointer; a += 1){
            sum += score[a];
        }
        return sum;
    }
}
