class Solution 
{
    public StringBuilder reverseFlips(StringBuilder s)
    {
        // reversal 
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            char temp=s.charAt(i);
            s.setCharAt(i,s.charAt(j));
            s.setCharAt(j,temp);
            i++;
            j--;
        }
        // flips 
        for(int k=0;k<s.length();k++)
        {
            if(s.charAt(k)=='0') s.setCharAt(k,'1');
            else s.setCharAt(k,'0');
        }

        return s;
    }
    public StringBuilder makeString(int i,int n, StringBuilder prev)
    {
        if(i>n) // Base case.
        {
            return prev;
        }
        if(i==1)
        {
            return makeString(i+1,n,prev.append('0'));
        }
        StringBuilder newStr=new StringBuilder();
        newStr.append(prev+"1");
        StringBuilder temp=reverseFlips(prev);
        newStr.append(temp);
        return makeString(i+1,n,newStr);
    }
    public char findKthBit(int n, int k) 
    {

        if(k==1) return '0';

        StringBuilder str=makeString(1,n,new StringBuilder());
        int len=str.length();
        if(len<k) return ' ';

        return str.charAt(k-1);

    }
}