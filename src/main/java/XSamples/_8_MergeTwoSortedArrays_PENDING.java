package XSamples;

public class _8_MergeTwoSortedArrays_PENDING {

// Only sorting what is mis-placed
// Time Complexity: O(min(m, n) * (m + n))
// Space Complexity : O(1)
    public void mergeArrays(int[] a, int[] b) {

        if(a.length == 0 || b.length == 0) return;


        while(a[a.length - 1] > b[0]){
            int temp = a[a.length - 1];
            a[a.length - 1] = b[0];
            b[0] = temp;
            sortA(a);
            sortB(b);
        }
    }

    public void sortA(int[] arr){
        int last = arr.length - 1;
        while(last > 0 && arr[last] < arr[last - 1]){
            int temp = arr[last];
            arr[last] = arr[last - 1];
            arr[last - 1] = temp;
            last--;
        }
    }

    public void sortB(int[] arr){
        int first = 0;
        while(first < arr.length - 1 && arr[first] > arr[first + 1]){
            int temp = arr[first];
            arr[first] = arr[first + 1];
            arr[first + 1] = temp;
            first++;
        }
    }
}



//a[] = [2, 4, 7, 10]
//b[] = [3, 8]
//O(n+m) * log(n + m)  --> TODO
// 2, 2, 3, 4, 7, 10



// Output: a[] = [2, 2, 3, 4],
//         b[] = [7, 10]


