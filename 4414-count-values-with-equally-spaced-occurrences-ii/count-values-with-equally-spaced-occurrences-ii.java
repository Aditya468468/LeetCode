class Solution {
    public int countSpecialIntegers(int[] nums) 
    {
        int n=nums.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        int ans=0;
        for(Map.Entry<Integer,List<Integer>> it:map.entrySet())
        {
            int key=it.getKey();
            List<Integer> list=it.getValue();
            if(list.size()<3) continue;
            int diff=list.get(1)-list.get(0);
            boolean valid=true;
            for(int i=1;i<list.size();i++)
            {
                if(list.get(i)-list.get(i-1)!=diff)
                {
                    valid=false;
                    break;
                }
            }

            if(valid) ans++;

        }

        return ans;
        
    }
}