class Solution {
    public int[] arrayRankTransform(int[] arr) 
    {
       
        int[]nums=Arrays.copyOf(arr,arr.length);
        Arrays.sort(arr);
        Map<Integer,Integer> map=new HashMap<>();
        int rank=0;
        for(int x:arr)
        {
            if(!map.containsKey(x))
            {
                rank++;
                map.put(x,rank);
            }

        }
        for(int i=0;i<nums.length;i++)
        {
            int r=map.get(nums[i]);
            nums[i]=r;
        }

        return nums;
        
    }
}