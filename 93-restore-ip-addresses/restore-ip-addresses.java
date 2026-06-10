class Solution 
{
    private int toNumber(String s)
    {
        int num=0;
        for(int i=0;i<s.length();i++)
        {
            num=(num*10)+(s.charAt(i)-'0');
        }

        return num;
    }
    private boolean isValid(String s)
    {
        if(s.length()>1 && s.charAt(0)=='0')// Leading Zero Check
        {
            return false;
        }
        int value=toNumber(s);
        if(value<0 || value>255) return false; //Range Check

        return true;
    }
    public void generate(int idx,String s,StringBuilder str,List<String> ans,int part)
    {
        if(idx==s.length())
        {
            if(part==4)
            {
                ans.add(new StringBuilder(str).toString());
            }
            return;
        }
        if(part>=4) return; // No further Splits are needed.
        int needed=4-part;
        int canBe=s.substring(idx).length();
        if(canBe<needed) return; //Pruning
        for(int i=idx;i<Math.min(idx+3,s.length());i++)
        {
            String temp=s.substring(idx,i+1);
            if(isValid(temp))
            {
                int len=str.length();
                str.append(temp);
                if(part!=3) str.append('.');
                generate(i+1,s,str,ans,part+1);
                //str.delete(idx,i+1);
                str.setLength(len);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) 
    {
        List<String> ans=new ArrayList<>();
        generate(0,s,new StringBuilder(),ans,0);
        return ans;


    }
}