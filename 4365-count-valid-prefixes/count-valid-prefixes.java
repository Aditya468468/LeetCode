class Solution {
    public int countValidPrefixes(String s) 
    {
        //Well there can be two valid conf
        int n=s.length();
        int cntZero=0;
        int cntOne=0;
        int cnt=0;
        for(int i=0;i<n;i++)
            {
                if(s.charAt(i)=='0')
                {
                    cntZero++;
                }
                else
                {
                    cntOne++;
                }
                int length=(i+1);
                if(Math.abs(cntOne-cntZero)<=1)
                {
                    cnt++;
                }
            }

        return cnt;
        
        
    }
}