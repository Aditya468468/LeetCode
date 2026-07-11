class Solution {
    public int[] singleNumber(int[] nums) 
    {
        int xor=0;
        for(int x:nums)
        {
            xor=xor^x;
        }
        
        int diffBit=(xor&(xor-1))^(xor);
        
        int a=0;
        int b=0;
        
        for(int i=0;i<nums.length;i++)
        {
            if((nums[i]&diffBit)!=0)
            {
                a=a^nums[i];
            }
            else
            {
                b=b^nums[i];
            }
        }

        return new int[]{a,b};
        
    }
}