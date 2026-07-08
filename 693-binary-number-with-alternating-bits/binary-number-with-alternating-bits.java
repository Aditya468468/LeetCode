class Solution {
    public boolean hasAlternatingBits(int n)
     {
        

        int mask=0;
        int temp=n;
        while(temp!=0)
        {
            mask=(mask<<1)|1;
            temp=temp>>1;
        }
        int x=n>>1;
        if((x^n)==mask) return true;

        return false;
         
        
    }
}