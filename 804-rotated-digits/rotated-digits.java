class Solution {

    boolean isValid(int x)
    {
       
       StringBuilder str=new StringBuilder();
       int temp=x;
       while(x!=0)
        {
            int ld=x%10;
            if(ld==1 || ld==8 || ld==0)
            {
                str.append(ld);
            }
            else if(ld==2)
            {
                str.append(5);
            }
            else if(ld==5)
            {
                str.append(2);
            }
            else if(ld==6)
            {
                str.append(9);
            }
            else if(ld==9)
            {
                str.append(6);
            }
            else return false;
            x/=10;
        }
        str.reverse();
        int digit=Integer.parseInt(str.toString());
        if(digit==temp) return false;
        return true;


    }
    public int rotatedDigits(int n) 
    {
        int cnt=0;
        for(int i=1;i<=n;i++)
        {
            if(isValid(i))
            {
                cnt++;
            }
        }

        return cnt;
        
    }
}