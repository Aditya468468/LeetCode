class Solution 
{
    
    public int maxLengthBetweenEqualCharacters(String s) 
    {
        HashMap<Character,Integer> map=new HashMap<>();
        char []nums=s.toCharArray();
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            char x=nums[i];
            if(!map.containsKey(x))
            {
                map.put(x,i);
            }
            else
            {
                int pos=map.get(x);
                int len=i-pos+1; //Len of subarray
                len=len-2; //exclude the similar.
                max=Math.max(max,len);
            }
           
        }
        if(max==Integer.MIN_VALUE)
        {
            return -1;
        }
        return max;
    }
}