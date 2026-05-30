class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) 
    {
        int MOD=1000_000_007;
        ArrayList<Integer> list=new ArrayList<>();
        // Need to generate all Sub arrays.
        for(int i=0;i<n;i++)
        {
            int sum=0;
            for(int j=i;j<n;j++)
            {
                sum=(sum+nums[j])%MOD;
                list.add(sum);

            }

        }
        Collections.sort(list);
        int totalSum=0;
        for(int i=left-1;i<right;i++)
        {
            totalSum=(totalSum+list.get(i))%MOD;
        }


        return totalSum;
    }
}