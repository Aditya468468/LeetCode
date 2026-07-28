class Solution 
{
    public void reverse(StringBuilder str)
    {
        int i=0;
        int j=str.length()-1;
        while(i<j)
        {
            char temp=str.charAt(i);
            str.setCharAt(i,str.charAt(j));
            str.setCharAt(j,temp);
            i++;
            j--;
        }
    }
    public String smallestPalindrome(String s) 
    {
        StringBuilder left=new StringBuilder();
        StringBuilder right=new StringBuilder();
        StringBuilder middle=new StringBuilder();
        int[]freq=new int[26];
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            int frequency=freq[i];
            char ch=(char)('a'+i);
            if(frequency==1) 
            {
                middle.append(ch);
                continue;
            }
           
            for(int j=0;j<frequency/2;j++)
            {
                left.append(ch);
                right.append(ch);

            }
            if(frequency%2==1) middle.append(ch);
            
        }

        //Reverse 
        reverse(right);
        left.append(middle);
        left.append(right);  //Append
        String ans=left.toString(); 

        return ans;

        
    }
}