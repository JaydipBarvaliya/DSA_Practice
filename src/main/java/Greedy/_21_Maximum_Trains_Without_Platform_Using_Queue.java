package Greedy;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

 Approach: PENDING
 1)
 2)
 3)
 4)
 5)
 6)
 7)
 8)
 ------------------------------------------------------------------------------------------------------------------------

 Time:  O(n) + O(nlogn) = O(n log n).
 Space: The queue stores one departure time per platform, not one per train. So no matter how many trains there are, the queue never grows beyond k
 ------------------------------------------------------------------------------------------------------------------------
 */
public class _21_Maximum_Trains_Without_Platform_Using_Queue {

    public static int maximumTrainWithoutPlatformsUsingQueue(int totalPlatforms, int[][] trains) {

        Arrays.sort(trains, (a, b) -> a[1] - b[1]);
        Queue<Integer> queue = new LinkedList<>();

        int count = 0;
        for(int[] train : trains){
            int futureArr = train[0];
            int futureDep = train[1];

            if(queue.isEmpty()){
                queue.add(futureDep);
                count++;
            }else{

                int currDep = queue.peek();

                if(currDep < futureArr){ // use existing platform
                    queue.poll();
                    queue.add(futureDep);
                    count++;
                }else if(queue.size() < totalPlatforms){ // assign a new platform
                    queue.add(futureDep);
                    count++;
                }
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
        int result = maximumTrainWithoutPlatformsUsingQueue(k, trains);
        String status = result == expected ? "PASS" : "FAIL";
        System.out.printf("[%s] %s | expected=%d got=%d%n", status, label, expected, result);
    }
}