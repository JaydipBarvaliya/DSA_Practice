package Greedy;

import java.util.PriorityQueue;

/**

PROBLEM: https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1

------------------------------------------------------------------------------------------------------------------------

Approach:
1) intuition: the less cost we calculate initially, the less we have to carry further, which will generate the lesser total answer
2) so try to sort them by ASC order which will give us smaller cost first
3) then add them into the minHeap because we have to add totalCost into the array each time which requires sorting
4) and minheap make sense here to do it everytime
5) track the totalCost each time
6)

------------------------------------------------------------------------------------------------------------------------

Time :
 -> logN-1 + logN-2 + logN-3 ...+ logN-N = N*Log(N)
 -> logN  + logN + logN ...+ logN = N*Log(N)
 -> Building heap: O(n log n)
 -> Each iteration: 2 polls + 1 add = O(log n), and we do ~n iterations
 -> Total: O(n log n)


 Space : O(n) — not O(log n)
 -> initially we are storing all the elements in the minHeap so space would be O(n)
 -> log(n) space would be if we were doing something recursive like merge sort where only the call stack grows,
    but here we are growing actual minHeap itself.
------------------------------------------------------------------------------------------------------------------------



*/
class _25_Minimum_Cost_Of_Ropes {

    public static int minCost(int[] arr) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);

        for(int num : arr){
            minHeap.add(num);
        }
        int total = 0;

        while(!minHeap.isEmpty()){
            int firstNum =  minHeap.poll();
            if(minHeap.isEmpty()) break;
            int secNum   = minHeap.poll();
            int sum = firstNum + secNum;
            total = total + sum;
            minHeap.add(sum);
        }
        return total;

    }
}
