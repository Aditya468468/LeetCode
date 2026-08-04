class Solution {
    public List<Integer> findMissingElements(int[] nums) 
    {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        Set<Integer> set=new HashSet<>();
        for(int x:nums)
        {
            set.add(x);
            max=Math.max(max,x);
            min=Math.min(min,x);
        }

        List<Integer> list=new ArrayList<>();
        for(int i=min;i<=max;i++)
        {
            if(!set.contains(i))
            {
                list.add(i);
            }
        }

        return list;
        
    }
}