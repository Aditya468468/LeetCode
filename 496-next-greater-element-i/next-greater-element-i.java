class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        int n=nums1.length;
        int m=nums2.length;
       // if(n>m) return nextGreaterElement(nums2,nums1);
        // this way nums1-> Always smaller (update)-> Ques ensured nums1<nums2
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(nums1[i]==nums2[j])
                {
                    map.put(nums1[i],j);
                }
            }
        }
        int []result=new int[n];
        for(int i=0;i<n;i++)
        {
            boolean find=false;
            for(int j=map.get(nums1[i])+1;j<m;j++)
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