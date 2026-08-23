class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) 
    {
        Set<Integer> set=new HashSet<>();
        for(int x:nums)
        {
            set.add(x);
        }
        List<List<Integer>> ans=new ArrayList<>();
        int start=-1;
        for(int i=lower;i<=upper;i++)
        {
            if(set.contains(i))
            {
                if(start==-1)
                {
                    continue;

                }
                int end=i-1;
                ans.add(new ArrayList<>(List.of(start,end)));
                start=-1;
                continue;
                
            }

            if(start==-1)
            {
                start=i;
            }

        }
        if(start!=-1)
        {
            ans.add(new ArrayList<>(List.of(start,upper)));
        }

        return ans;
        
    }
}