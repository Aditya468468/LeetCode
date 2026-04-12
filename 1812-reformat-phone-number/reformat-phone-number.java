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
            StringBuilder temp=new StringBuilder();
            int i=0;
            int len=0;
            while(i<str.length())
            {
                if(len==3)
                {
                    temp.append('-');
                    len=0;
                }
                else
                {
                    temp.append(str.charAt(i));
                    len++;
                    i++;
                }

            }
            if(len==1)
            {
                int last=temp.length()-1;
                temp.deleteCharAt(last-1);
                temp.insert(last-2,'-');
            }
            str=temp;
        }
        return str.toString();

        
    }
}