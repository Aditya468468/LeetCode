class Solution {
    public int numberOfBeams(String[] bank) 
    {
        int prevCnt=0;
        int total=0;
        for(int i=0;i<bank.length;i++)
        {
            int cnt=0;
            for(int j=0;j<bank[i].length();j++)
            {
                char c=bank[i].charAt(j);
                if(c=='1')
                {
                    cnt++;
                }
            }
            total+=(prevCnt*cnt);
            if(cnt!=0)
                prevCnt=cnt;

        }

        return total;
        
    }
}