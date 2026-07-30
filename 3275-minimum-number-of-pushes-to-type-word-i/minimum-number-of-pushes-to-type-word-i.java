class Solution {
    public int minimumPushes(String word) 
    {
        int n=word.length();
        int[]freq=new int[26];
        for(int i=0;i<n;i++)
        {
            char ch=word.charAt(i);
            freq[ch-'a']++;
        }

        Arrays.sort(freq); //We Sort it by freq
        int keyUsed=0; // Used digits,As we can only use 8 digits-->digits/8
        int min=0;
        int times=1; // initally we can press all key 1 times
        for(int i=freq.length-1;i>=0;i--)//by desc order so higher freq can be mapped to lower ones
        {
            int freqOf=freq[i];
            if(freq[i]==0) continue;
            if(keyUsed==8)//used all 8 keys
            {
                times++; //Times inc
                keyUsed=0; //Reset 

            }
            min+=(1L)*(times*freqOf);
            keyUsed++;
        }

        return min;
    }
}