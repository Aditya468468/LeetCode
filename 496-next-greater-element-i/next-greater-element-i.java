class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        int n=nums1.length;
        int m=nums2.length;
        int []idx=new int[n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(nums1[i]==nums2[j])
                {
                    idx[i]=j;
                    break;
                }
            }
        }
        int []result=new int[n];
        for(int i=0;i<n;i++)
        {
            boolean find=false;
            for(int j=idx[i]+1;j<m;j++)
            {
                if(nums2[j]>nums1[i])
                {
                   
                    result[i]=nums2[j];
                    find=true;
                    break;
                }
            }
            
            if(!find) result[i]=-1;
        }

        return result;
        
        
    }
}