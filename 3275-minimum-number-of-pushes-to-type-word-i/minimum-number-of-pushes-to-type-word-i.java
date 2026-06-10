class Solution {
    public int minimumPushes(String word) 
    {
        int []freq=new int[26];
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            freq[c-'a']++;
        }
        Arrays.sort(freq);
        long cnt=0;
        long score=1;
        long min=0;
        for(int i=freq.length-1;i>=0;i--)
        {
            if(freq[i]!=0)
            {
                min+=(1L)*(freq[i]*score);
                cnt++;
            }
            if(cnt==8)
            { 
                score++; //Will score more now
                cnt=0;
            }
        }


        return (int)min;
    }
}