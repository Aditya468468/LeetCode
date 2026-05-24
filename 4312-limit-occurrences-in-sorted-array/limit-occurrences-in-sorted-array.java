class Solution {
    public int[] limitOccurrences(int[] nums, int k) 
    {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(nums[0]);
        int n=nums.length;
        int cnt=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]==nums[i])
            {
                if(cnt<k)
                {
                    cnt++;
                    list.add(nums[i]);
                }
            }
            else if(nums[i-1]!=nums[i])
            {
                cnt=1;
                list.add(nums[i]);
            }
        }
        int[]ans=new int[list.size()];
        int idx=0;
        for(int x:list)
        {
            ans[idx++]=x;
        }

        return ans;

        
    }
}