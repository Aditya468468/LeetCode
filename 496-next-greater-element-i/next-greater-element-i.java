class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        Map<Integer,Integer> map=new HashMap<>();
        int []ans=new int[nums1.length];

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<nums2.length;i++)
        {
            while(!st.isEmpty() && st.peek()<nums2[i])
            {
                int x=st.pop();
                map.put(x,nums2[i]); //Update if found 
            }
            st.push(nums2[i]);
            map.put(nums2[i],-1); //first we keep as -1 
        }

        for(int i=0;i<nums1.length;i++)
        {
            ans[i]=map.get(nums1[i]);
        }

        return ans;

        
    }
}