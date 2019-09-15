import java.util.Arrays;

public class _621TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        for (char c: tasks){
            freq[c-'A'] += 1;
        }

        int intervalCountOfMostFrequentTask = 0;

        for (int i = 0; i < 26; i += 1){
            intervalCountOfMostFrequentTask  = Math.max(intervalCountOfMostFrequentTask , freq[i]);
        }

        int partCount = intervalCountOfMostFrequentTask  - 1;

        int NumOfMostFreuqenctTasks = 0;
        for (int i = 0; i < 26; i += 1){
            if (freq[i] == intervalCountOfMostFrequentTask) NumOfMostFreuqenctTasks++;
        }
        int emptySlot = partCount * (n + 1 - NumOfMostFreuqenctTasks);
        int availableTasks = tasks.length - intervalCountOfMostFrequentTask * NumOfMostFreuqenctTasks;
        int idle = Math.max(0, emptySlot - availableTasks);
        return idle + tasks.length;
    }
}
