class Solution {
    public int numberOfSubstrings(String s) 
    {
        int lastIdxA=-1;
        int lastIdxB=-1;
        int lastIdxC=-1;
        int cnt=0;
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            if(x=='a') lastIdxA=i;
            else if(x=='b') lastIdxB=i;
            else lastIdxC=i;
            int min=(Math.min(lastIdxA,Math.min(lastIdxB,lastIdxC)));
            if(min!=-1)
            {
                cnt+=(min+1);
            }
        }
        
        return cnt;
        
    }
}