package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 PROBLEM: https://www.geeksforgeeks.org/problems/maximum-trains-for-which-stoppage-can-be-provided/1

 ------------------------------------------------------------------------------------------------------------------------

 Approach: [Platform of trains are fixed from start]
 1) collect all the train which are associated with the same platform in Map
 2)
 3) sort the list of array on each platform in ASC order by their departure time
 4)
 5) We are sorting by departure time, because earlier the train left
 6) Earlier the platform becomes empty, and early it gets empty, more train we can accommodate
 7)
 8) start iterating each of the intervals on each platform
 9) if they are overlapping then discard otherwise increase the totalTrainCounter
10) This problem is almost same as merge interval, just have to understand how to sort initially.
 ------------------------------------------------------------------------------------------------------------------------

 Time: O(n log n) The total work across all platforms is still n log n — even if all trains are on one platform, you're sorting n elements once.
       The nested loops together visit each train exactly once total across all platforms, so that's O(n).
       Sorting dominates at O(n log n).
 Space: O(n) The map stores every train exactly once. O(n).
 ------------------------------------------------------------------------------------------------------------------------

 */
public class _21_Maximum_Trains_With_Platforms {

    public int maxStop(int totalPlatforms, int[][] trains) {

        Map<Integer, List<int[]>> map = new HashMap<>();

        for(int[] train : trains){ //O(n)
            int arrival   = train[0];
            int departure = train[1];
            int platform  = train[2];

            if(map.containsKey(platform)){
                List<int[]> list = map.get(platform);
                list.add(new int[]{arrival, departure});
                map.put(platform, list);
            }else{
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{arrival, departure});
                map.put(platform, list);
            }
        }

        int totalTrainCount = 0;
        for (var entry : map.entrySet()) {
            List<int[]> list = entry.getValue();

            list.sort((a,b) -> a[1] - b[1]);

            int[] currTrain = list.get(0);

            int trainCountOnEachPlatform = 1;
            for(int i=1; i<list.size(); i++){
                int[] futureTrain = list.get(i);

                if(futureTrain[0] >= currTrain[1]){
                    trainCountOnEachPlatform = trainCountOnEachPlatform + 1;
                    currTrain = futureTrain;
                }
            }
            totalTrainCount =  totalTrainCount + trainCountOnEachPlatform;
        }
        return  totalTrainCount;
    }
}