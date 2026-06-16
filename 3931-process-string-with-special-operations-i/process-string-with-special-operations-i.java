class Solution 
{
    private void reverse(StringBuilder str)
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

        return ;
    }
    public String processStr(String s) 
    {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='*')
            {
                if(str.length()>0)
                {
                    str.deleteCharAt(str.length()-1);
                }
            }
            else if(c=='#')
            {
                if(str.length()>0)
                {
                    StringBuilder temp=str;
                    str.append(temp);
                }

            }
            else if(c=='%')
            {
                if(str.length()>0)
                {
                    reverse(str);
                }
            }
            else
            {
                str.append(c);
            }
        }

        return str.toString();
        
    }
}