class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) 
    {
        TreeMap<Integer,Integer> neg=new TreeMap<>();
        int n=nums.length;
        int []res=new int[n-k+1];
        int idx=0;
        int left=0;
        for(int right=0;right<nums.length;right++)
        {
            if(nums[right]<0)
            {
                neg.put(nums[right],neg.getOrDefault(nums[right],0)+1);
            }
            while(right-left+1>k)
            {
                    if(nums[left]<0)
                    {
                        neg.put(nums[left],neg.getOrDefault(nums[left],0)-1);
                        if(neg.get(nums[left])==0)
                        {
                            neg.remove(nums[left]);
                        }
                    }
                    left++;
            }
            if(right-left+1==k)
            {
                int temp=0;
                boolean find=false;
                for(Map.Entry<Integer,Integer> it:neg.entrySet())
                {
                    int key=it.getKey();
                    temp+=it.getValue();
                    if(temp>=x)
                    {
                        res[idx++]=key;
                        find=true;
                        break;
                    }
                }
                if(!find)
                {
                    res[idx++]=0;
                }

            }
        }

        return res;
    }
}