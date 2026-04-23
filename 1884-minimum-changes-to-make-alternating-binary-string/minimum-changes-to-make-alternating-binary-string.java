class Solution {
    public int minOperations(String s) 
    {
        int cnt1=0; //01010
        int cnt2=0; //10101

        for(int i=0;i<s.length();i++)
        {
            char exp1;
            char exp2;
            if(i%2==0)
            {
                exp1='0';
                exp2='1';

            }
            else 
            {
                exp1='1';
                exp2='0';
            }
            char c=s.charAt(i);
            if(c!=exp1)
            {
                cnt1++;
            } 
            else 
            {
                cnt2++;
            }
        }

        return Math.min(cnt1,cnt2);


    }

    
}