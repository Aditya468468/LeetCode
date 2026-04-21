class Solution 
{
    private boolean isValid(String s)
    {
        if (s.length()>3) return false;
        int val=Integer.parseInt(s);
        if (val>255) return false;
        // if len is 2 or 3..it should not have leading zero.
        if(s.length()>1 && s.charAt(0)=='0') return false;
        return true;
    }
    private void restore(int idx,String s,int parts,List<String> ans,StringBuilder str)
    {
        if(idx==s.length() && parts==4)
        {
            ans.add(new String(str.toString()));
            return;
        }
        if(parts>=4 || idx==s.length()) return;
        // For-Loop
        for(int i=idx;i<s.length();i++)
        {
            String sub=s.substring(idx,i+1);
            if(isValid(sub))
            {
                int len=str.length();
                if(parts>0) str.append('.');
                str.append(sub);
                restore(i+1,s,parts+1,ans,str);
                str.delete(len, str.length()); //took help
            }
        }
    }
    public List<String> restoreIpAddresses(String s) 
    {
        List<String> ans=new ArrayList<>();
        restore(0,s,0,ans,new StringBuilder());
        return ans;
        
    }
}
