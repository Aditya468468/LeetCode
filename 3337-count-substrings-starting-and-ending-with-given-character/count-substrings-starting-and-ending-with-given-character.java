class Solution {
    public long countSubstrings(String s, char c) 
    {
        if(s.length()==0) return 0;
        long cnt=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==c)
            {
                cnt++; 
            }
        }
        // 1-a cont-1, 2-a's -> 2,3-a's->3
        // 1+2+3+...n = n*(n+1)/2.
        return (cnt*(cnt+1))/2;
        
    }
}