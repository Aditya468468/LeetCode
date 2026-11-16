class Solution 
{
    public int sumOfDigits(String str)
    {
        int sum=0;
        for(int i=0;i<str.length();i++)
        {
            int x=(str.charAt(i)-'0');
            sum+=x;
        }

        return sum;

    }
    public String digitSum(String s, int k) 
    {
        StringBuilder str=new StringBuilder(s);
        while(str.length()>k)
        {
            int len=str.length();
            int i=0;
            StringBuilder st=new StringBuilder();
            while(i<len-k)
            {
                StringBuilder temp=new StringBuilder();
                for(int j=0;j<k;j++)
                {
                    temp.append(str.charAt(i));
                    i++;

                }
                int sum=sumOfDigits(temp.toString());
                st.append(sum);
            }
            int sum=0;
            while(i<len)
            {
                sum+=str.charAt(i)-'0';
                i++;
            }

            st.append(sum);
            str=st;
        }

        return str.toString();


        
    }
}