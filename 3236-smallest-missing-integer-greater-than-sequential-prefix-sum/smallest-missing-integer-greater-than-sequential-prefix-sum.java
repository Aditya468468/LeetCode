class Solution {
    public int missingInteger(int[] nums) 
    {

        int prev=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]-prev==1)
            {
                sum+=nums[i];
                prev=nums[i];
            }
            else
            {
                break;
            }

        }
        HashSet<Integer> set=new HashSet<>();
        for(int x:nums)
        {
            set.add(x);
        }
        while(set.contains(sum))
        {
            sum=sum+1;
        }

        return sum;

        
    }
}