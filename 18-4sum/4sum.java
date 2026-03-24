class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        int n=nums.length;
        HashSet<List<Integer>> ans=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                HashSet<Integer> set=new HashSet<>();
                for(int k=j+1;k<n;k++)
                {
                    long sum=(long)nums[i]+nums[j]+nums[k];
                    long find=(long)target-sum;
                     if(find >= Integer.MIN_VALUE && find <= Integer.MAX_VALUE 
                        && set.contains((int) find))
                    {
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add((int)find);
                        Collections.sort(list);
                        ans.add(list);
                    }
                    set.add(nums[k]);
                }
            }
        }
    
        List<List<Integer>> list=new ArrayList<>(ans);

        return list;
        
    }
}