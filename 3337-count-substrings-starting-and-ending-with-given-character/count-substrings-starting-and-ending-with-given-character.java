class Solution {
    public long countSubstrings(String s, char c) 
    {
        if(s.length()==0) return 0;
        long ans=0;
        long cnt=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==c)
            {
                cnt++; // 1-a cont-1, 2-a's -> 2,3-a's->3
                ans+=cnt; //(1+2+3).
            }
        }

        return ans;
        
    }
}