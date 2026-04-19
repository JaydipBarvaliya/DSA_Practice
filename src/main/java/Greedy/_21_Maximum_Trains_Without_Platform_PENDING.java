package Greedy;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 TODO:
 1) find number of trains that can be stopped at station ( trains have their fixed platform number) // SOLVED
 2) find number of trains that can be stopped at station ( trains have no fixed platform number and number of platforms are fixed ) // CURRENT
 3) find number of platforms to accommodate given trains ( no platform information at all, you can add new platform if required) // NEXT

 PROBLEM:
 You are given n trains, each with an arrival time and departure time. You have exactly k platforms available.
 A train can be assigned to any free platform.
 A platform is free if the previous train on it has already departed before the new train arrives (i.e. newArrival > prevDeparture).
 Maximize the number of trains you can stop.
 ------------------------------------------------------------------------------------------------------------------------

 Input:
 k = 2
 trains[][] = [[900,1000], [930,1100], [1010,1200], [1030,1130], [1200,1300]]


 //TODO: this can be solved without Map and MinHeap as initial array would be already sorted by their departure time....so at most we need iteration over each...think of it


 1 --> [1030,1130]
 2 --> [930,1100]


 minHeap  == K

 Output:
 4

 Explanation:
 We have 2 platforms and 5 trains.
 Trains T1(900-1000) and T2(930-1100) are assigned to platform 1 and 2 respectively since both are free.
 When T4 arrives at 1030, platform 1 is already free (T1 left at 1000), so T4 gets platform 1.
 When T3 arrives at 1010, both platforms are still occupied (T2 leaves at 1100, T4 leaves at 1130), so T3 cannot be accommodated.
 When T5 arrives at 1200, platform 1 is free (T4 left at 1130), so T5 gets platform 1 or 2 anything is fine.
 Hence maximum 4 trains (T1, T2, T4, T5) can be accommodated.
 ------------------------------------------------------------------------------------------------------------------------

 Approach:
 1)
 2)
 3)
 4)
 5)
 6)
 7)
 8)
 9)

 ------------------------------------------------------------------------------------------------------------------------

 Time :
 Space :

 ------------------------------------------------------------------------------------------------------------------------

 */
public class _21_Maximum_Trains_Without_Platform_PENDING {

    public int maximumTrainWithoutPlatforms(int totalPlatforms, int[][] trains) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1; i<=totalPlatforms; i++){
            map.put(i, null);
        }

        Arrays.sort(trains, (a, b) -> a[1] - b[1]);

    }

}