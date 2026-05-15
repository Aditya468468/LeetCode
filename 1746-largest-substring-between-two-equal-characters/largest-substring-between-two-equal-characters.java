class Solution 
{
    public class Pair
    {
        int first;
        int last;
        public Pair(int first,int last)
        {
            this.first=first;
            this.last=last;
        }
    }
    public int maxLengthBetweenEqualCharacters(String s) 
    {
        HashMap<Character,Pair> map=new HashMap<>();
        char []nums=s.toCharArray();
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            char x=nums[i];
            if(!map.containsKey(x))
            {
                map.put(x,new Pair(i,i));// First and last same.
            }
            else if(map.containsKey(x))
            {
                int pos=map.get(x).first;
                int len=i-pos+1; //Len of subarray
                len=len-2; //exclude the similar.
                max=Math.max(max,len);
                map.get(x).last=i;
            }
           
        }
        if(max==Integer.MIN_VALUE)
        {
            return -1;
        }
        return max;
    }
}