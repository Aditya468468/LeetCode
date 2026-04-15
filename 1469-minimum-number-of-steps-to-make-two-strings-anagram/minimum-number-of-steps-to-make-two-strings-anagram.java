class Solution {
    public int minSteps(String s, String t) 
    {

        //length will be same only naa.
        int n=s.length();
        if(n!=t.length()) return -1;

        int[]freq=new int[26];// Using freq Array.
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            freq[x-'a']++;
        }
        for(int i=0;i<n;i++)
        {
            char x=t.charAt(i);
            freq[x-'a']--;
           
        }
        int need=0;
        
        for(int i=0;i<freq.length;i++)
        {
            if(freq[i]>0)
            {
                need+=freq[i];
            }
        }
        return need;

        
    }
}