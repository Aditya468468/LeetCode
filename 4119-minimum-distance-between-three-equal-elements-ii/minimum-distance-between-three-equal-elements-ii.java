class Solution {
    public int minimumDistance(int[] nums) 
    {
        Map<Integer,List<Integer>> map=new HashMap<>();
        int n=nums.length;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],new ArrayList<>());

            }
            map.get(nums[i]).add(i);
            if(map.get(nums[i]).size()>2)
            {
                List<Integer> list=map.get(nums[i]);
                int k=list.get(list.size()-1);
                int j=list.get(list.size()-2);
                int l=list.get(list.size()-3);
                int val=(k-j)+(k-l)+(j-l);
                if(val<min) min=val;

            }
        }
        if(min==Integer.MAX_VALUE) return -1;

        return min;
        
    }
}