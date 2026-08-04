class Solution {
    public String minWindow(String s, String t) 
    {
        Map<Character,Integer> tMap=new HashMap<>();
        int n=t.length();
        for(int i=0;i<n;i++)
        {
            char ch=t.charAt(i);
            tMap.put(ch,tMap.getOrDefault(ch,0)+1);
        }
        int matched=0;
        int minLen=Integer.MAX_VALUE;
        int left=0;
        int lIdx=-1;
        int rIdx=-1;
        Map<Character,Integer> sMap=new HashMap<>();
        for(int right=0;right<s.length();right++)
        {
            char ch=s.charAt(right);
            sMap.put(ch,sMap.getOrDefault(ch,0)+1);
            if(tMap.containsKey(ch))
            {
                if(tMap.get(ch).equals(sMap.get(ch)))
                {
                    matched++;
                }
            }
            while(matched==tMap.size())
            {
               
                char c=s.charAt(left);
                if(right-left+1<minLen)
                {
                    lIdx=left;
                    rIdx=right; // left and Right of valid ans
                    minLen=right-left+1;
                }
                sMap.put(c,sMap.get(c)-1);
                if(tMap.containsKey(c))
                {
                    if(tMap.get(c)>sMap.get(c))
                    {
                        matched--;
                    }
                }
                left++;
            }
        }
        if(lIdx==-1) return "";
        return s.substring(lIdx,rIdx+1);
        
    }
}