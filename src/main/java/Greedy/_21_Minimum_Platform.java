package Greedy;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 PROBLEM: https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

 ------------------------------------------------------------------------------------------------------------------------

 Approach:
 1) sort by arrival time, because we don't want to messed up the time-travel issue
 2) use minHeap instead of Queue, because minHeap can balance itself and always guarantee to give us the minDeparture time which queue cannot give us because we sorted by the arrival time
 3) if we can accommodate train on the platform, use the platform
 4) if cannot, then assign a new platform
 5) minHeap will give us the totalPlatform we have used at any point of time.

 ------------------------------------------------------------------------------------------------------------------------

 Below approach won't work, because here we are sorting by their departure time which may change the order of the arrival time while processing,
 which means that we may process 9:00 AM train later and 11:00 AM train earlier which is timing bug, so it is always better to process them in
 their correct timing order.
 */

//public class _21_Minimum_Platform {
//
//    public int minPlatform(int arr[], int dep[]) {
//
//        int[][] trains = new int[arr.length][2];
//        for(int i=0; i<arr.length; i++){
//            trains[i][0] = arr[i];
//            trains[i][1] = dep[i];
//        }
//        Arrays.sort(trains, (a,b) -> a[1] - b[1]);
//        Queue<Integer> queue = new LinkedList<>();
//
//        for(int[] train: trains){
//
//            int futureArr = train[0];
//            int futureDep = train[1];
//
//            if(queue.isEmpty()){
//                queue.add(futureDep);
//            }else{
//
//                if(futureArr > queue.peek()){
//                    queue.poll();
//                    queue.add(futureDep);
//                }else{
//                    queue.add(futureDep);
//                }
//            }
//        }
//
//        return queue.size();
//    }
//}

/**
 * Below solution does the exact opposite of the above solution.
 * Here we sort by their arrival time, which is change the order of departure time.
 * now because departure time order has been shuffled or changed, we cannot use the QUEUE because QUEUE will not give us min departure time when
 * we do the queue.peek(), so instead we use MinHeap to ensure that it will balance itself and always give us the min departure time during
 * minHeap.peek()
 *
 *
 * WHICH MEANS, if the problem ask for the MAX TRAIN STOPPAGE then we can skip and sort by departure
 * but when problem ask for the min platform then we have to fit all the train, and we cannot skip, and we must follow the arrival timeline.
 */

/**

 TIME:
 Building array: O(n)
 Sorting: O(n log n)
 Loop: n iterations × log k per heap operation = O(n log n) worst case when k=n
 Total: O(n) + O(n log n) + O(n log n) = O(n log n) ✅

 Space:
 trains array: O(n)
 PriorityQueue worst case: O(n)
 Total: O(n) + O(n) = O(n)
 */

class _21_Minimum_Platform {
    public int minPlatform(int arr[], int dep[]) {

        int[][] trains = new int[arr.length][2];
        for(int i=0; i<arr.length; i++){
            trains[i][0] = arr[i];
            trains[i][1] = dep[i];
        }
        Arrays.sort(trains, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int[] train: trains){

            int futureArr = train[0];
            int futureDep = train[1];

            if(minHeap.isEmpty()){
                minHeap.add(futureDep);
            }else{

                if(futureArr > minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(futureDep);
                }else{
                    minHeap.add(futureDep);
                }
            }
        }

        return minHeap.size();
    }
}