import java.util.*;
public class _957PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int size = cells.length;
        Map<String, Integer> set = new HashMap<>();
        boolean hasLoop = false;
        int loopSize = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < N; i += 1){
            cells = nextDay(cells);
            String str = Arrays.toString(cells);
            count += 1;
            if (!set.containsKey(str)){
                set.put(str, i);
            }else{
                hasLoop = true;
                loopSize = i - set.get(str);
                break;
            }
        }
        if (hasLoop){
            int n = (N - count) % loopSize;
            for (int i = 0; i < n; i += 1){
                cells = nextDay(cells);
            }
        }
        return cells;
    }

    private int[] nextDay(int[] cells){
        int[] tmp = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i += 1){
            tmp[i] = (cells[i - 1] == cells[i + 1])? 1: 0;
        }
        return tmp;
    }
}
