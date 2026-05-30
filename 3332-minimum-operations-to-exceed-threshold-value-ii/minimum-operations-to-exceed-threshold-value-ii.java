class Solution 
{
    public int minOperations(int[] nums, int k) 
    {
        int n=nums.length;
        TreeMap<Long,Integer> map=new TreeMap<>();
        for(int i=0;i<n;i++)
        {
            map.put((long)nums[i],map.getOrDefault((long)nums[i],0)+1);
        }
        long ops=0;
        while(map.firstKey()<k)
        {
            long x=map.firstKey();
            map.put(x,map.get(x)-1);
            if(map.get(x)==0)
            {
                map.remove(x);
            }
            //int y=map.higherKey(x);
            long y=map.firstKey();
            map.put(y,map.get(y)-1);
            if(map.get(y)==0)
            {
                map.remove(y);
            }
            long val=Math.min(x,y)*2L+Math.max(x,y);
            map.put(val,map.getOrDefault(val,0)+1);
            ops++;
        }

        return (int)ops;
        
        
    }
}