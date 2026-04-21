class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        for (int x : nums) sum += x;

        // If total sum not divisible → impossible
        if (sum % k != 0) return false;

        int target = sum / k;

        // Sort descending (helps prune faster)
        Arrays.sort(nums);
        reverse(nums);

        boolean[] used = new boolean[nums.length];

        return backtrack(nums, used, k, 0, 0, target);
    }

    private boolean backtrack(int[] nums, boolean[] used,
                              int k, int start, int currSum, int target) {

        // All buckets filled
        if (k == 0) return true;

        // Current bucket filled → move to next bucket
        if (currSum == target) {
            return backtrack(nums, used, k - 1, 0, 0, target);
        }

        for (int i = start; i < nums.length; i++) {

            if (used[i]) continue;

            // Skip duplicates (optional optimization)
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            if (currSum + nums[i] > target) continue;

            used[i] = true;

            if (backtrack(nums, used, k, i + 1, currSum + nums[i], target))
                return true;

            used[i] = false; // backtrack

            // Optimization: if first element fails, no need to try others
            if (currSum == 0) break;
        }

        return false;
    }

    private void reverse(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }
    }
}