class Solution {
    public int minFlips(String s) 
    {
        int n=s.length();
        // There can be only 2-combinations.-> 0101010.. & 1010101..
        int op1=0;
        //0->even and 1-> odd;
        int op2=0;
        //1-> even & 0-> odd
        //As ques involves rotation..Lets Go with t=s+s to find all of them as
        // substrings to work better.
        String t=s+s;
        int left=0;
        int ans=Integer.MAX_VALUE;
        for(int right=0;right<2*n;right++)
        {
            char x=t.charAt(right);
            char expected1; // for-> 010101
            char expected2; // for-> 101010
            if(right%2==0)
            {
                expected1='0';
                expected2='1';
            }
            else 
            {
                expected1='1';
                expected2='0';
            }
            if(x!=expected1) op1++;
            if(x!=expected2) op2++;

            if(right-left+1>n) //shrink
            {
                char prev=t.charAt(left);
                char prevExpected1;
                char prevExpected2;
                if (left%2==0) {
                    prevExpected1 = '0';
                    prevExpected2 = '1';
                } 
                else {
                    prevExpected1 = '1';
                    prevExpected2 = '0';
                }

                if (prev!=prevExpected1) {
                    op1--;
                }
                if (prev!=prevExpected2) {
                    op2--;
                }
                left++;
            }
            if(right-left+1==n)
            {
                ans=Math.min(ans,Math.min(op1,op2));
            }

        }

        return ans;
    }
}