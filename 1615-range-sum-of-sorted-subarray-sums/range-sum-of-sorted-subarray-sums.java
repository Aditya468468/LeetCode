class Solution 
{
    public void countSort(ArrayList<Integer> list)
    {
        int max=Integer.MIN_VALUE;
        for(int x:list)
        {
            if(x>max) max=x;
        }
        int []freq=new int[max+1];
        for(int i=0;i<list.size();i++)
        {
            freq[list.get(i)]++;
        }
        int idx=0;
        for(int i=0;i<freq.length;i++)
        {
            while(freq[i]!=0)
            {
             
                list.set(idx,i);
                freq[i]--;
                idx++;
            }
            
        }
    }
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
        //Collections.sort(list);
        //Lets COUNT_SORT.
        countSort(list);
        int totalSum=0;
        for(int i=left-1;i<right;i++)
        {
            totalSum=(totalSum+list.get(i))%MOD;
        }


        return totalSum;
    }
}