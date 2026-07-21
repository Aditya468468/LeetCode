class Solution {
    public int maxActiveSectionsAfterTrade(String s) 
    {
        s= "1"+s+"1";
        int n=s.length();
        int Ones=0;
        for (int i=1;i<n-1;i++) 
        {
            if (s.charAt(i)=='1') Ones++;
        }
        int []prefixZero=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='1')
            {
                prefixZero[i]=cnt;
                cnt=0;
            }
            else
            {
                cnt++;
            }
        }
    
        cnt=0;
        int []suffixZero=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            if(s.charAt(i)=='1')
            {
                suffixZero[i]=cnt;
                cnt=0;
            }
            else
            {
                cnt++;
            }
        }
        
        //Lets find max
        int maxGain=0; //Greedy Chooses More Surrounded Segment
        int idx=-1;
        for(int i=1;i<n-1;i++)
        {
            if(s.charAt(i)=='1' &&(i==0 || s.charAt(i-1)=='0'))
            {
                int j=i; // Last One of block
                while(j+1<n && s.charAt(j+1)=='1')
                {
                    j++;
                }
                if(j+1<n && s.charAt(j+1)=='0')
                {
                    int gain=prefixZero[i]+suffixZero[j];
                    maxGain=Math.max(maxGain, gain);
                }

                i=j;//Go find another 1 starting a block;

            }

        }
       

        return Ones+maxGain;
        
    }
}