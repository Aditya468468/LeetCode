class Solution 
{
    public int rev(int x)
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
            int x=rev(nums[i]);
            if(map.containsKey(nums[i]))
            {
                int dis=map.get(nums[i]);
                min=Math.min(i-dis,min);
            }
            map.put(x,i);

        }
        if(min==Integer.MAX_VALUE) return -1;

        return min;


        
    }
}