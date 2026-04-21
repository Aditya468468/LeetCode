class Solution {
    public List<Integer> findAnagrams(String s, String p) 
    {
        List<Integer> ans=new ArrayList<>();
        //Matching map
        int []freq=new int[26];
        for(char ch:p.toCharArray())
        {
            freq[ch-'a']++;
        }
        int n=s.length();
        int k=p.length();
        int left=0;
        int []freq2=new int[26];
        for(int right=0;right<n;right++)
        {
            freq2[s.charAt(right)-'a']++;
            while(right-left+1>k)
            {
                freq2[s.charAt(left)-'a']--;
                left++;
            }
            if(right-left+1==k)
            {
                boolean isValid=true;
                for(int i=0;i<26;i++)
                {
                    if(freq[i]!=freq2[i])
                    {
                        isValid=false;
                        break;
                    }
                }

                if(isValid)
                {
                    ans.add(left);
                }

            }

        }
        
        return ans;
    }
}