class Solution {
    public void moveZeroes(int[] nums) 
    {
        int anchor=0;
        for(int scout=0;scout<nums.length;scout++)
        {
            if(nums[scout]!=0)
            {
                nums[anchor]=nums[scout];
                anchor++;
            }
        }
        for(int i=anchor;i<nums.length;i++)
        {
            nums[i]=0;
        }
    }
}