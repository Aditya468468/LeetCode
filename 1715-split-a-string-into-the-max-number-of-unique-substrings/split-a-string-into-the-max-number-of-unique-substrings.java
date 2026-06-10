class Solution 
{
    int max=0;
    public boolean isValid(String str,HashSet<String> set)
    {
        if(set.contains(str)) return false;
        return true;
    }
    public void split(int idx,String s,HashSet<String> set,int cnt)
    {
        if(idx==s.length())
        {
            if(max<cnt)
            {
                max=cnt;
            }
            return;
        }
        for(int i=idx;i<s.length();i++)
        {
            String str=s.substring(idx,i+1);
            if(isValid(str,set))
            {
                set.add(str);
                split(i+1,s,set,cnt+1);
                set.remove(str);//Back-track.
            }
        }
    }
    public int maxUniqueSplit(String s) 
    {
      
        split(0,s,new HashSet<>(),0);

        return max;
        
    }
}