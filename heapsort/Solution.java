package heapsort;

import com.sun.deploy.util.SyncAccess;

import java.util.Arrays;

public class Solution {

    public  void heapSort(int arr[], int n){
        //Rearranging the array
        for(int i=n/2-1;i>=0;i--) {
            heapify(arr, n, i);
        }
        //Extraction of element one by one
        for(int i=n-1;i>=0;i--) {
            int temp= arr[i];
            arr[i]= arr[0];
            arr[0] =temp;
            heapify(arr, i, 0);
        }
        Arrays.stream(arr).forEach(temp->System.out.print(temp+" " ));
        System.out.println();
    }

    public void heapify(int arr[], int n, int i) {
        int larg= i;
        int left= 2*i+1;
        int right= 2*i+2;

        if(left<n && arr[left]>arr[larg]) {
            larg=left;
        }
        if(right<n && arr[right]>arr[larg]) {
            larg=right;
        }

        if(larg!=i) {
            int temp= arr[larg];
            arr[larg]=arr[i];
            arr[i]= temp;
            heapify(arr, n, larg);
        }
    }
    public static void main(String args[]) {
        int arr[]= new int[]{4,10,3,5,1};
        int len= arr.length;
        Solution solution= new Solution();
        solution.heapSort(arr, len);
    }
}
