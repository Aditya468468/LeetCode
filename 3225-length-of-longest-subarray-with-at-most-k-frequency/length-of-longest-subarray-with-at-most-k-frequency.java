class Solution {
    public int maxSubarrayLength(int[] nums, int k) 
    {
        
        Map<Integer,Integer> map=new HashMap<>();
        int maxLen=0;   
        int n=nums.length;
        int left=0;
        for(int right=0;right<n;right++)
        {
            int num=nums[right];
            map.put(num,map.getOrDefault(num,0)+1);
            while(map.get(num)>k)
            {
                int x=nums[left];
                map.put(x,map.get(x)-1);
                if(map.get(x)==0)
                {
                    map.remove(x);
                }
                left++;
            }
            int len=right-left+1;
            maxLen=Math.max(maxLen,len);
        }


        return maxLen;

    }
}
