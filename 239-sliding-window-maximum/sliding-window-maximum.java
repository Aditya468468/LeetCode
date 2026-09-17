class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) 
    {

        TreeMap<Integer,Integer> map = new TreeMap<>();
        int n=nums.length;
        int []ans=new int[n-k+1];

        int left=0;
        for(int right=0;right<n;right++)
        {
            int num=nums[right];
            map.put(num,map.getOrDefault(num,0)+1);

            while(right-left+1>k)
            {
                int x=nums[left];
                map.put(x,map.get(x)-1);
                if(map.get(x)==0)
                {
                    map.remove(x);
                }

                left++;
            }

            if(right-left+1==k)
            {
                ans[left]=map.lastKey();
                //ans[right-k+1]=map.lastKey();
            }
        }

        return ans;


        
    }
}