package Greedy;

import java.util.PriorityQueue;

/**

PROBLEM: https://www.geeksforgeeks.org/problems/minimize-cash-flow/1

------------------------------------------------------------------------------------------------------------------------

Approach:
1) Intuition: build the balance sheet and find out the biggest debtor with the biggest creditor each time using MinHeap and MaxHeap and settled between them.
2)
3) create a balance sheet which shows how much person owes/receives, not to whom, just the balance.
4) iterate the balance sheet and store them in minHeap(if <0) or maxHeap(if >0)
5) minHeap will give the biggest debtor
6) maxHeap will give the biggest creditor
7) we wil settle between the biggest debtor and biggest creditor because that will minimize the net cash flow transaction and because we are choosing the BIGGEST
8)
9) minHeap and MaxHeap also store the index of the person, so that when we settle them, we can understand if who is owing and who is receiving
10) when we settle this, we also store them in the output array
11) Every settlement guarantees at least one person is fully settled per transaction
12) if there is anything unsettled we store them into the minHeap or maxHeap accordingly

------------------------------------------------------------------------------------------------------------------------

Time :
 Two nested loops → O(n²)
 Building balanceSheet array iteration → O(n)
 Adding to heaps → O(n log n) — n people, each add is log n
 While loop → at most n iterations, each poll/add is log n → O(n log n)
 So Overall =  O(n² + n log n) == n²

Space :
 balanceSheet: O(n)
 minHeap + maxHeap: O(n)
 Overall = O(n)

------------------------------------------------------------------------------------------------------------------------

*/
class _27_Minimize_Cashflow {

    public int[][] minCashFlow(int[][] transaction) {

        int n = transaction.length;
        int[] balanceSheet = new int[n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
               if(i!=j){
                   balanceSheet[i] = balanceSheet[i] - transaction[i][j];
                   balanceSheet[j] = balanceSheet[j] + transaction[i][j];
               }
            }
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);


        for(int i=0; i<n; i++){
            if(balanceSheet[i] < 0){
                minHeap.add(new int[]{balanceSheet[i], i});
            }else{
                maxHeap.add(new int[]{balanceSheet[i], i});
            }
        }

        int[][] output = new int[n][n];
        while(!minHeap.isEmpty() && !maxHeap.isEmpty()){
            int[] min = minHeap.poll();
            int[] max = maxHeap.poll();

            int debt = Math.min(-min[0], max[0]);

            output[min[1]][max[1]] =  output[min[1]][max[1]] +  debt;

            int remainingDebt = min[0] + max[0];

            if(remainingDebt < 0){
                minHeap.add(new int[]{remainingDebt, min[1]});
            }else if(remainingDebt > 0){
                maxHeap.add(new int[]{remainingDebt, max[1]});
            }
        }
        return output;
    }
}
