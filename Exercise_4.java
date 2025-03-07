// Time Complexity : nlog(n) - at each step, a mid value is calculated and array is divided based on mid value.
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MergeSort 
{ 
    // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    void merge(int arr[], int l, int m, int r) {  
        int[] temp = new int[r-l+1];
        int left = l, right = m+1, tmpPtr = 0;

        while(left<=m && right<=r){
            if(arr[left] > arr[right]){
                temp[tmpPtr++] = arr[right++];
            }else{
                temp[tmpPtr++] = arr[left++];
            }
        }

        while(left <= m){
            temp[tmpPtr++] = arr[left++];
        }

        while(right <= r){
            temp[tmpPtr++] = arr[right++];
        }

        for(int i=l;i<=r;i++){
            arr[i] = temp[i-l];
        }
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(int arr[], int l, int r) { 
        if(l == r){
            return;
        }

        int mid = l + (r-l)/2;
        sort(arr, l, mid);
        sort(arr, mid+1, r);

        merge(arr, l, mid, r);
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    // Driver method 
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        MergeSort ob = new MergeSort(); 
        ob.sort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    } 
} 