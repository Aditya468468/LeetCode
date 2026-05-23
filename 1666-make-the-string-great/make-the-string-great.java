class Solution 
{
    private boolean isOpposite(char x,char y)
    {
        // if((Character.isUpperCase(x) && Character.isLowerCase(y)) || Character.isUpperCase(y) && Character.isLowerCase(x))
        // {
        //     return true;
        // }

        // return false;
        return Math.abs(x-y) == 32;
       
    }
    public String makeGood(String s) 
    {
        StringBuilder str=new StringBuilder();
        str.append(s.charAt(0));
        for(int i=1;i<s.length();i++)
        {
            
            char x=s.charAt(i);
            if(!str.isEmpty() && isOpposite(str.charAt(str.length()-1),x))
            {
            
                str.deleteCharAt(str.length()-1);
    
            }
            else
            {
                str.append(x);
            }
        }
        
        return str.toString();
        
    }
}