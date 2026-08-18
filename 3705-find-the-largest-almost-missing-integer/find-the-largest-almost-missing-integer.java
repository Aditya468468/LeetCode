class Solution {
    public int largestInteger(int[] nums, int k) 
    {
        List<List<Integer>> list=new ArrayList<>();

        int n=nums.length;
        List<Integer> temp=new ArrayList<>();
        int left=0;
        for(int right=0;right<n;right++)
        {
            temp.add(nums[right]);
            while(right-left+1>k)
            {
                temp.remove(0);
                left++;
            }
            if(right-left+1==k)
            {
                list.add(new ArrayList<>(temp));
            }
        }
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<list.size();i++)
        {
            List<Integer> num=list.get(i);
            Set<Integer> set=new HashSet<>(num);
            for(int x:set)
            {
                map.put(x,map.getOrDefault(x,0)+1);
            }
            
        }
        
        int ans=-1;
        for(Map.Entry<Integer,Integer> it:map.entrySet())
        {
            if(it.getValue()==1)
            {
                ans=Math.max(ans,it.getKey());
            }
        }
        

        return ans;
    }
}