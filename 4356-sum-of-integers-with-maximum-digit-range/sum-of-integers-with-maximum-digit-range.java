class Solution {
    public int maxDigitRange(int[] nums) 
    {
        int maxRange=Integer.MIN_VALUE;
        int n=nums.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int digit=nums[i];
            int temp=digit;
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            while(temp!=0)
            {
                int ld=temp%10;
                max=Math.max(max,ld);
                min=Math.min(min,ld);
                temp/=10;
            }
            int range=max-min;
            if(!map.containsKey(range))
            {
                map.put(range,new ArrayList<>());
            }
            map.get(range).add(digit);
            maxRange=Math.max(maxRange,range);
        }
        List<Integer> list=map.get(maxRange);
        int res=0;
        for(int x:list)
        {
            res+=x;
        }

        return res;
        
    }
}