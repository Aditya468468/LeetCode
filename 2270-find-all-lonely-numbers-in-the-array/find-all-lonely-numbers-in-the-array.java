class Solution {
    public List<Integer> findLonely(int[] nums) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int x=nums[i];
            int y=x-1;
            int z=x+1;
            if(map.containsKey(x) && !map.containsKey(y) && !map.containsKey(z))
            {
                if(map.get(x)==1)
                {
                    list.add(x);
                }
            }
        }

        return list;
    }
}