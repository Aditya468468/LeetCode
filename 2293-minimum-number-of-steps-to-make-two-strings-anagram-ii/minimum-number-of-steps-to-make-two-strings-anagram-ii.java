class Solution {
    public int minSteps(String s, String t) 
    {
        int[] freqS=new int[26];
        int[] freqT=new int[26];
        for(char x:s.toCharArray())
        {
            freqS[x-'a']++;
        }
         for(char x:t.toCharArray())
        {
            freqT[x-'a']++;
        }
        int ops=0;
        for(int i=0;i<26;i++)
        {
            ops+=Math.abs(freqS[i]-freqT[i]);

        }

        return ops;
        
        
    }
}