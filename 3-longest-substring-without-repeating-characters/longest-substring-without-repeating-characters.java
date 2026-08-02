class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        HashMap<Character,Integer> map=new HashMap<>();
        int maxLen=0;
        int left=0;
        int n=s.length();

        for(int right=0;right<n;right++)
        {
            char ch=s.charAt(right);

            if(map.containsKey(ch))
            {
                left=Math.max(map.get(ch)+1,left);
            }
            map.put(ch,right);
            int len=right-left+1;
            maxLen=Math.max(maxLen,len);
        }

        return maxLen;
        
    }
}