class Solution 
{
    private int far(int[]nums2,int value,int start)
    {
        int low=start;
        int high=nums2.length-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums2[mid]>=value)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return high;

    }
    public int maxDistance(int[] nums1, int[] nums2) 
    {
        int maxDis=0;
        for(int i=0;i<nums1.length;i++)
        {
            int idx=far(nums2,nums1[i],i);
            if(idx!=-1)
            {
                int dis=idx-i;
                if(dis>maxDis) maxDis=dis;
            }
        }

        return maxDis;


        
    }
}