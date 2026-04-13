class Solution {
    public long[] distance(int[] nums) 
    {
        int n=nums.length;
        long []arr=new long[n];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int x=nums[i];
            if(!map.containsKey(x))
            {
                map.put(x,new ArrayList<>());
            }
            map.get(x).add(i);
        }
        for(Map.Entry<Integer,List<Integer>> it:map.entrySet())
        {
            int key=it.getKey();
            List<Integer> list=it.getValue();
            if(list.size()==1)
            {
                arr[list.get(0)]=0;
            }
            else
            {
        
                long totalSum=0;
                for(int i=0;i<list.size();i++)
                {
                    totalSum+=list.get(i);
                }
                long preSum=0;
                for(int i=0;i<list.size();i++)
                {
                    long suff=totalSum-preSum-list.get(i);
                    long left=((long)(i)*(long)list.get(i))-preSum;
                    long right=suff-((long)(list.size()-i-1)*(long)list.get(i));
                    long val=left+right;
                    arr[list.get(i)]=val;
                    preSum+=list.get(i);

                }

            }

        }

        return arr;
        
    }
}