class Solution {
    public boolean increasingTriplet(int[] arr) 
    {
        int n = arr.length;
        int[] smaller = new int[n];
        int[] greater = new int[n];

        // Track smaller element on left
        int minIdx = 0;
        smaller[0] = -1;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[minIdx]) {
                minIdx = i;
                smaller[i] = -1;
            } else {
                smaller[i] = minIdx;
            }
        }

       
        int maxIdx = n - 1;
        greater[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[maxIdx]) {
                maxIdx = i;
                greater[i] = -1;
            } else {
                greater[i] = maxIdx;
            }
        }

        // Find valid triplet
        for (int i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
               
                return true;
            }
        }

        return false;
        
    }
}