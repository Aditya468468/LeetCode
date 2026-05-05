class Solution {
    public int minSteps(String s, String t) 
    {
        int[] freqS=new int[26];
        int[] freqT=new int[26];
        for(char x:s.toCharArray())
        {
            freqS[x-'a']++;
        }
        int ans=0;
        for(char x:t.toCharArray())
        {
            freqT[x-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(freqS[i]<freqT[i])
            {
                ans+=freqT[i]-freqS[i];
            }
        }

        return ans;

        
    }
}