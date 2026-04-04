class Solution {
    private int reverse(int num)
    {
        long rev=0;
        while(num!=0)
        {
            int ld=num%10;
            rev=(rev*10)+ld;
            num/=10;
        }
        return (int)rev;
    }
    public boolean sumOfNumberAndReverse(int num) 
    {
        if(num==0) return true;
        for(int i=1;i<=num;i++)
        {
            int x=i;
            int y=reverse(x);
            if(x+y==num) return true;
        }

        return false;
    }
}