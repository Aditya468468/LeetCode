class Solution {
    public int maximumLengthSubstring(String s) 
    {
        Map<Character,Integer> map=new HashMap<>();
        int maxLen=0;   
        int n=s.length();
        int left=0;
        for(int right=0;right<n;right++)
        {
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>2)
            {
                char c=s.charAt(left);
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)
                {
                    map.remove(c);
                }
                left++;
            }
            int len=right-left+1;
            maxLen=Math.max(maxLen,len);
        }


        return maxLen;

        
    }
}