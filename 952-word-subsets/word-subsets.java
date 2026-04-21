class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) 
    {
        //We need max-freq of char ..as if max exists smaller do exists.
        int []freq=new int[26];
        // Lets Build.
        for(int i=0;i<words2.length;i++)
        {
            String s=words2[i];
            int []temp=new int[26];
            for(int j=0;j<s.length();j++)
            {
                char ch=s.charAt(j);
                temp[ch-'a']++;
            }
            //Updating Max-Freq
            for(int j=0;j<26;j++)
            {
                if(temp[j]>freq[j])
                {
                  freq[j]=temp[j];
                }
            }
        }
        //Process the words1.
        List<String> list=new ArrayList<>();
        for(int i=0;i<words1.length;i++)
        {
            String s=words1[i];
            int []freq2=new int[26];
            for(int j=0;j<s.length();j++)
            {
                char ch=s.charAt(j);
                freq2[ch-'a']++;
            }
            //Lets Check if they are Universal
            boolean isValid=true;
            for(int j=0;j<26;j++)
            {
                if(freq[j]>freq2[j])
                {
                    isValid=false;
                }
            }
            
            if(isValid) list.add(s);
        }

            return list;       
    }
}