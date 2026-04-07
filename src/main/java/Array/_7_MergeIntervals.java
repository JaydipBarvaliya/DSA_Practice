package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**

 PROBLEM: https://leetcode.com/problems/merge-intervals/description/
 ------------------------------------------------------------------------------------------------------------------------

 Approach:
 1) sort based on start time and scan from left to right
 2) or
 3) sort based on end time and scan from right to left
 4) start iterating internals from 1 to n
 5) if 2nd internal's start time is middle of 1st internal start and end time or exactly same as 1st interval's end time then there is overlap
 6) merge those two interval which are overlapping, otherwise store them and move forward
 7)

 NOTE To Remember:
 Sort based on the start time because we are scanning from left to right. we can also sort based on the end time, but in that
 case we have to start the scanning from the right end side. when we sort based on the start time, we know that start times are
 sorted and 2nd start time is greater than 1st start time, so we don't have to worry about start time anymore,
 and we can directly compare the 2nd interval's start time with 1st interval's end time.

 ------------------------------------------------------------------------------------------------------------------------

 Time : O(nlog) because of sorting
 Space : O(n) result List that in the worst case holds all n intervals. That's O(n) space.
 ------------------------------------------------------------------------------------------------------------------------

 */

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