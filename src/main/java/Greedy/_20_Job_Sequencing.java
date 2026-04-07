package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

/**

 PROBLEM: https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

 ------------------------------------------------------------------------------------------------------------------------

 Approach:
 1) Create a 2D array of deadline and profit
 2) Sort that 2D array by Profit descending, because we want maximum profit
 3) Create a parent[] array which denotes the DSU( Dis-joint union concept) and initialize with same index as a value
 4) DSU function will tell us where to find next available slot --> from right to left side order
 5) If DSU give us the answer, calculate the profit
 6) If DSU has no answer, which means there is no available slot
 7)
 8) In DSU parent[i] = i (all slots free)
 9)

 ------------------------------------------------------------------------------------------------------------------------

 Time : n(iterating deadline array) + nlog(n) Sorting the array ==
        n + n log n
        Taking n common: = n(1 + log n) ==> And n(1 + log n) simplifies to just O(n log n) because log n dominates 1.

 Space : O(n) ==  jobs array + parent array

 ------------------------------------------------------------------------------------------------------------------------


 Your fillup idea is actually smart. Let me explain exactly why it still TLEs with a concrete example.

 Worst case scenario:
 n = 10^5 jobs
 All deadlines = 10^5
 Profits = all different
 Your fillup breaks when fillup == maxDeadline. But to GET there:
 Job 1: deadline=100000 → scans slot 100000 → free ✅ fillup=1
 Job 2: deadline=100000 → scans 100000 (taken), 99999 (free) ✅ fillup=2
 Job 3: deadline=100000 → scans 100000, 99999, 99998 ✅ fillup=3
 Job 4: deadline=100000 → scans 100000, 99999, 99998, 99997 ✅ fillup=4
 ...
 See the pattern? Each job scans more slots than the previous one. Total scans:
 1 + 2 + 3 + ... + n = O(n²)
 fillup only helps AFTER the slots are full. The damage happens WHILE filling them.

 DSU fixes exactly this:
 Job 1: find(100000) → instant → slot 100000 ✅
 Job 2: find(100000) → parent says go to 99999 → instant ✅
 Job 3: find(100000) → parent says go to 99998 → instant ✅
 No scanning. Every job finds its slot in nearly O(1).

 Your intuition with fillup was correct — just applied at the wrong end. DSU is essentially doing the same thing but proactively storing the shortcut instead of reactively breaking the loop.

 */

public class _20_Job_Sequencing {

    public ArrayList<Integer> jobSequencing(int[] deadlines, int[] profits) {

        // step 1: sort by profit descending
        // hint: create a 2D array of {deadline, profit} pairs and sort

        int[][] jobs = new int[deadlines.length][2];

        int maxDeadline = 0;
        for(int i=0; i<deadlines.length; i++){
            jobs[i][0] = deadlines[i];
            jobs[i][1] = profits[i];
            maxDeadline = Math.max(maxDeadline, deadlines[i]);
        }

        Arrays.sort(jobs, (a,b) -> b[1] - a[1]);

        // step 2: create parent array
        int[] parent = new int[maxDeadline +  1];
        for (int i = 0; i <= maxDeadline; i++){
            parent[i] = i;
        }

        int finalProfit = 0;
        int jobCounter = 0;
        int fillup = 0;
        for (int[] job : jobs) {
            int deadline = job[0];
            int profit = job[1];

            if(fillup == maxDeadline) break;

            int point = find(parent, deadline);
            if( point != 0){
                parent[point] = point - 1; // mark slot as taken --> "Slot point is now taken. If anyone asks for it again, go to point - 1 instead."
                finalProfit = finalProfit + profit;
                jobCounter = jobCounter + 1;
                fillup++;
            }

        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(jobCounter);
        list.add(finalProfit);
        return list;
    }

    public int find(int[] parent, int x){
        if(parent[x] == x) return x;
        parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}
