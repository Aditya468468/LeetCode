class Solution {
    public int minOperations(String s) 
    {
        char[] nums = s.toCharArray();
        Arrays.sort(nums);
        int j=0;
        while(j<nums.length && nums[j]=='a') 
        {
            j++;
        }
        if(j==nums.length) return 0;
        int ops = 0;
        char prev = nums[j];
        for (int i=j+1;i<nums.length;i++) 
        {
            if (nums[i] == prev) continue;   // skip duplicates
            ops += nums[i] - prev;           // move to next distinct char
            prev = nums[i];
        }
        ops += (26-(prev-'a'))%26;     // final move to 'a'
        return ops;
    }
}