package Greedy;


import java.util.Arrays;
import java.util.PriorityQueue;

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
 1) sort the 2D array by their departure time in ASC order so that we can iterate in departing manner where we are processig a train which depart earlier
 2) Whatever trains we are processing and eligible to stay on the platform and which has no time conflict with other trains, we store those trains in the meanHeap
 3) We can also use the map to track all the trains which comes to specefic platform, but we have to scan the entire map to understand which platform gets free earliest for the future train which required scan of all the entries in the map,
    instead minHeap will give us the direct answer
 4) if any train needs a new platform, then first we check the size of the minHeap, if we have enough platform then we'll add it in the heap,
 5) if any train needs a new platform and minHeap is full then we will discard that train which means, we don't have enough platform
 6) Whenever we add anything new to minHeap, we count that as an eligible train.
 7) at last, return the count which defines, total number of trains we can accomodate.
 8)
 ------------------------------------------------------------------------------------------------------------------------

 Time : n log(n)
 Space :

 //TODO: this can be solved without Map and MinHeap as initial array would be already sorted by their departure time....so at most we need iteration over each...think of it
 ------------------------------------------------------------------------------------------------------------------------

 */
public class _21_Maximum_Trains_Without_Platform {

    public static int maximumTrainWithoutPlatforms(int totalPlatforms, int[][] trains) {

        Arrays.sort(trains, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int count = 0;
        for(int[] comingTrain : trains){
            int arrTime = comingTrain[0];
            int departTime = comingTrain[1];

            if(!minheap.isEmpty()){
                if(arrTime <= minheap.peek() && minheap.size() < totalPlatforms){ // cannot use existing platform, but we have other empty platform
                    minheap.add(departTime);
                    count++;
                }else if(arrTime <= minheap.peek() && minheap.size() >= totalPlatforms){ // cannot use existing platform, and also don't have enough platform, then just discard the train
                    // we are keeping this empty for the learning purpose in the future, so that we can remember this.
                }else if(arrTime > minheap.peek()){ // we can use existing platform
                    minheap.poll();
                    minheap.add(departTime);
                    count++;
                }
            }else{
                minheap.add(departTime);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        // Test 1: base case from problem
        test("Base case",
                2,
                new int[][]{{900,1000},{930,1100},{1010,1200},{1030,1130},{1200,1300}},
                4);

        // Test 2: all trains fit, no conflicts
        test("All trains fit",
                3,
                new int[][]{{900,1000},{910,1010},{920,1020}},
                3);

        // Test 3: only 1 platform, trains are sequential
        test("1 platform sequential",
                1,
                new int[][]{{900,1000},{1001,1100},{1101,1200}},
                3);

        // Test 4: only 1 platform, all trains overlap
        test("1 platform all overlap",
                1,
                new int[][]{{900,1100},{950,1050},{1000,1200}},
                1);

        // Test 5: k platforms, all trains overlap — only k fit
        test("k=2 all overlap",
                2,
                new int[][]{{900,1100},{900,1100},{900,1100},{900,1100}},
                2);

        // Test 6: single train
        test("Single train",
                1,
                new int[][]{{900,1000}},
                1);

        // Test 7: exact boundary — new arrival == departure (should NOT reuse)
        test("Boundary arrival == departure",
                1,
                new int[][]{{900,1000},{1000,1100}},
                1);

        // Test 8: new arrival just after departure (should reuse)
        test("Boundary arrival just after departure",
                1,
                new int[][]{{900,1000},{1001,1100}},
                2);

        // Test 9: more platforms than trains
        test("More platforms than trains",
                10,
                new int[][]{{900,1000},{930,1100},{1010,1200}},
                3);

        // Test 10: large k, heavy overlap
        test("Large k heavy overlap",
                3,
                new int[][]{{900,1200},{900,1200},{900,1200},{900,1200},{900,1200}},
                3);
    }

    static void test(String label, int k, int[][] trains, int expected) {
        int result = maximumTrainWithoutPlatforms(k, trains);
        String status = result == expected ? "PASS" : "FAIL";
        System.out.printf("[%s] %s | expected=%d got=%d%n", status, label, expected, result);
    }
}