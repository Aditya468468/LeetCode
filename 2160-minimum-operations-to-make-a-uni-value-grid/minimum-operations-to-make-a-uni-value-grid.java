class Solution {
    public int minOperations(int[][] grid, int x) 
    {
        int n=grid.length;
        int m=grid[0].length;
        int[]nums=new int[n*m];
        for(int i=0;i<n*m;i++)
        {
            nums[i]=grid[i/m][i%m];
        }
        Arrays.sort(nums);
        for(int num:nums)
        {
            if((num-nums[0])%x!=0) return -1;
        }
        
        if(nums.length==2) return (nums[1]-nums[0])/x;

        int size=nums.length;
        //if size is even-> 2 Mids
        if(size%2==0)
        {
            int ops1=0;
            int ops2=0;
            int mid=size/2;
            int r1=nums[mid];
            int r2=nums[mid-1];
            // For mid
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]<r1)
                {
                    int val=r1-nums[i];
                    ops1+=(val)/x;

                }
                else if(nums[i]>r1)
                {
                    int val=nums[i]-r1;
                    ops1+=val/x;
                }
            }
             for(int i=0;i<nums.length;i++)
            {
                if(nums[i]<r2)
                {
                    int val=r2-nums[i];
                    ops2+=(val)/x;

                }
                else if(nums[i]>r2)
                {
                    int val=nums[i]-r2;
                    ops2+=val/x;
                }
            }
            return Math.min(ops1,ops2);
        }
        else
        {
            int ops1=0;
            int mid=size/2;
            int r1=nums[mid];
             for(int i=0;i<nums.length;i++)
            {
                if(nums[i]<r1)
                {
                    int val=r1-nums[i];
                    ops1+=(val)/x;

                }
                else if(nums[i]>r1)
                {
                    int val=nums[i]-r1;
                    ops1+=val/x;
                }
            }

            return ops1;

            
        }
    }
}