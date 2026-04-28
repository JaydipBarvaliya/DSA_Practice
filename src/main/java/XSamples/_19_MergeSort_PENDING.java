package XSamples;



/**

 PROBLEM: Implement Merge Sort
 ------------------------------------------------------------------------------------------------------------------------

 Approach:
 1) Given an unsorted array
 2) Divide the array in 2 halves until you reach the single element
 3) As soon as you reach the single element, go back with the same element
 4) Send your left half and right half for sorting and return the sorted array as a result

 ------------------------------------------------------------------------------------------------------------------------

 Time : n log(n)
            log(n) levels of recursion (halving each time)
            at the first level we have 2 half and each half has N/2 elements = 2*(N/2) = N
            at the second level we have  4 half and each half has N/4 elements = 4*(N/4) = N
            so we are doing log(n) for N times that's why Nlog(N)
 Space : log(n) recursion stack

 ------------------------------------------------------------------------------------------------------------------------
 */

//TODO: Below solution is not in-place solution, do that
public class _19_MergeSort_PENDING {

    void mergeSort(int arr[], int i, int j) {
        divide(arr,i,j);
    }

    int[] divide(int[] arr, int i, int j){

        if(i == j) return new int[]{arr[i]};

        int mid = (i+j)/2;

        int[] left  = divide(arr, i, mid);
        int[] right = divide(arr, mid+1, j);

        return merge(left, right);
    }

    int[] merge(int[] arr1, int[] arr2){

        int i = 0;
        int j = 0;
        int idx = 0;
        int[] newArr = new int[arr1.length + arr2.length];

        while(i<arr1.length && j<arr2.length){

            if(arr1[i] < arr2[j]){
                newArr[idx] =  arr1[i];
                i++;
            }else{
                newArr[idx] = arr2[j];
                j++;
            }
            idx++;
        }

        while(j < arr2.length){
            newArr[idx] = arr2[j];
            j++;
            idx++;
        }

        while(i < arr1.length){
            newArr[idx] = arr1[i];
            i++;
            idx++;
        }
        return newArr;
    }
}
