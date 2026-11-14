class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;
        int n = nums.size();
        
        // We can use prefix sums or maintain the window sum properly.
        // Let's iterate over all possible starting positions or use a proper window:
        for (int i = 0; i < n; i++) {
            int sum = 0;
            // For a strict O(n) or O(n * r) where r is a small constant bound (r <= 50 typically),
            // checking lengths from l to r starting at i is optimal and runs in O(n * r) ~ O(n).
            for (int len = l; len <= r && i + len - 1 < n; len++) {
                if (len == l) {
                    // Compute sum for the first window of size l
                    sum = 0;
                    for (int k = i; k < i + len; k++) {
                        sum += nums.get(k);
                    }
                } else {
                    // Slide by adding the new element
                    sum += nums.get(i + len - 1);
                }
                
                if (sum > 0) {
                    min = Math.min(min, sum);
                }
            }
        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}