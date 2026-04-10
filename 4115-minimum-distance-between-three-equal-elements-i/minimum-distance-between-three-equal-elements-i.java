class Solution {
    public int minimumDistance(int[] nums) 
    {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i=0;i<n;i++)
        {
            if(!map.containsKey(nums[i]))
            {
                map.put(nums[i],new ArrayList<>());
            }
            List<Integer> list = map.get(nums[i]);
            list.add(i);
            if (list.size()>=3)
            {
                int x=list.size();
                int k=list.get(x - 1);
                int j=list.get(x - 2);
                int p=list.get(x - 3);
                int value = (k - p) + (j - p) + (k - j);
                if (value<min)
                {
                    min=value;
                }
            }
        }
        if (min==Integer.MAX_VALUE) return -1;
        return min;
    }
}