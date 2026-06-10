class Solution 
{
    public long toNumber(String str)
    {
        int i=0;
        long num=0;
        while(i<str.length() && str.charAt(i)=='0')
        {
            i++;
        }
        while(i<str.length()) // if(i==str.length())-> 00000--> 0
        {
            //eg:-985
            num=(num*10)+(str.charAt(i)-'0');
            //0*10+9=9, 9*10+8=98, 98*100+5=985
            i++;
        }

        return num;

    }
    public boolean check(int idx,String s, long prevd,int cnt)
    {
        if(idx==s.length())
        {
            return cnt>=2;
        }
        for(int i=idx;i<s.length();i++)
        {
            String str=s.substring(idx,i+1);
            long num=toNumber(str);
            if(prevd-num==1 || prevd==-1)
            {
                if(check(i+1,s,num,cnt+1))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    public boolean splitString(String s) 
    {
        return check(0,s,-1,0);

    }
}