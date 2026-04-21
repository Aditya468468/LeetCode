class Solution 
{
    int max=0; //global 

    private boolean isValid(String s,HashSet<String> set)
    {
        if(set.contains(s)) return false;
        return true;
    }
    private void generate(int idx,String s,int count,HashSet<String> set)
    {
        if(idx==s.length())
        {
            if(count>max)
            {
                max=count;
            }
            return;
        }
        for(int i=idx;i<s.length();i++)
        {
            String sub=s.substring(idx,i+1);
            if(isValid(sub,set))
            {
                set.add(sub);
                generate(i+1,s,count+1,set);
                set.remove(sub); //back-track.
            }
        }
    }
    public int maxUniqueSplit(String s) 
    {
        generate(0,s,0,new HashSet<>());

        return max;

        
    }
}