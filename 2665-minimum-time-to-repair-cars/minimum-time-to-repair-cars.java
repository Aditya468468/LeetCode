class Solution {
    public boolean canRepair(int []nums,int cars,long time)
    {
        long count=0;
        for(int i=0;i<nums.length;i++)
        {
            long x=(long)Math.sqrt((double)time/nums[i]);
            count+=x;
            if(count>=cars) return true;
        }

        return false;

    }
    public long repairCars(int[] ranks, int cars) 
    {
        long low=1;
        int max=Integer.MIN_VALUE;
        for(int x:ranks)
        {
            if(x>max) max=x;
        }
        long high=(long)max*cars*cars;
       
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            if(canRepair(ranks,cars,mid))
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }

        return low;


        
    }
}