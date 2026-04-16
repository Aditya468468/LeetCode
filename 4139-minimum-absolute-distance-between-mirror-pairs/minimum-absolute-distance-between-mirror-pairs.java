class Solution {
    public int reverse(int x)
    {
        int rev=0;
        while(x!=0)
        {
            int ld=x%10;
            rev=(rev*10)+ld;
            x/=10;
        }
        return rev;
    }
    public int minMirrorPairDistance(int[] nums) 
    {
        HashMap<Integer,Integer> map=new HashMap<>();

        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            int x=nums[i];
            int rev=reverse(x);
            if(map.containsKey(x))
            {
                int dis=i-map.get(x);
                if(dis<min) min=dis;
            }

            // as we need min-> We keep updating
            map.put(rev,i);
        }

        if (min==Integer.MAX_VALUE) 
        {
            return -1;
        }

        return min;
        
    }
}