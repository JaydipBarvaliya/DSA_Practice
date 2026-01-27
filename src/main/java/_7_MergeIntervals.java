import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Sort based on the start time because we are scanning from left to right. we can also sort based on the end time, but in that case we have to start the scanning from the right end side.
//when we sort based on the start time, we know that start times are sorted and 2nd start time is greater than 1st start time, so we don't have to worry about that, and we can directly compare the 2nd start time with 1st end time.

class _7_MergeIntervals {
    public int[][] merge(int[][] intervals) {

        if(intervals.length == 0) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0]; // [15, 18]

        for(int i=1; i< intervals.length; i++){

            if(intervals[i][0] <= current[1]){
                current[1] = Math.max(current[1], intervals[i][1]);
            }else{
                result.add(current);
                current = intervals[i];
            }
        }

        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}