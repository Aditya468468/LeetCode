class Solution 
{
    public int atMost(String s, int x)
    {
        HashMap<Character,Integer> map=new HashMap<>();
        int cnt=0;
        int left=0;
        for(int right=0;right<s.length();right++)
        {
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()>x)
            {
                char c=s.charAt(left);
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)
                {
                    map.remove(c);
                }
                left++;
            }
            cnt+=(right-left+1);

        }

        return cnt;
    }
    public int numberOfSubstrings(String s) 
    {
        return atMost(s,3)-atMost(s,2);
        
    }
}