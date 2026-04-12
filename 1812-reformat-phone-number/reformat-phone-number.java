class Solution {
    public String reformatNumber(String number) 
    {
        StringBuilder str=new StringBuilder();
        for(char x:number.toCharArray())
        {
            if(Character.isDigit(x))
            {
                str.append(x);
            }
        }
        //Just digits.
        if(str.length()<4) return str.toString();
        if(str.length()==4)
        {
            str.insert(2,'-');
        }
        else
        {
            int i=0;
            int len=0;
            while(i<str.length())
            {
                if(len==3)
                {
                    str.insert(i,'-');
                    len=0;
                }
                else
                {
                    len++;
                }
                i++;

            }
            if(len==1)
            {
                int last=str.length()-1;
                str.deleteCharAt(last-1);
                str.insert(last-2,'-');
            }
        }
        return str.toString();

        
    }
}