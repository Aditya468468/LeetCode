class Solution {
    public String reformatNumber(String number) 
    {
        StringBuilder str=new StringBuilder();
        int len=0;
        for(int i=0;i<number.length();i++)
        {
            char ch=number.charAt(i);
            if(len==3 && Character.isDigit(ch)) //If len=3 and I found More Digit
                                               //Then Only we append "-".
            {
                str.append('-');
                len=0;
            }
            if(Character.isDigit(ch))
            {
                len++;
                str.append(ch);

            }
        }
        if(len==1) //Handling it Explicitly.
        {
            int lastIdx=str.length()-1;
            str.deleteCharAt(lastIdx-1);
            str.insert(lastIdx-2,'-');
        }

        return str.toString();
        
    }
}