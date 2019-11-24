import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _406QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 1) return people;
        int n = people.length;
        int[][] ans = new int[n][2];

        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]){
                return b[0] - a[0];
            }else{
                return a[1] - b[1];
            }
        });

        List<int[]> list = new LinkedList<>();
        for (int[] person: people){
            list.add(person[1], person);
        }
        int idx = 0;
        for (int[] person: list){
            ans[idx++] = person;
        }
        return ans;
    }
}
