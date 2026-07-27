class Solution {
    public boolean lemonadeChange(int[] bills) 
    {
        int billOf5=0;
        int billOf10=0;
        int n=bills.length;

        for(int i=0;i<n;i++)
        {
            if(bills[i]==5)
            {
                billOf5++;
            }
            else if(bills[i]==10)
            {
                if(billOf5<=0) return false;
                billOf10++;
                billOf5--;
            }
            else
            {
                if(billOf10>0 && billOf5>0)
                {
                    billOf10--;
                    billOf5--;
                }
                else if(billOf5>=3)
                {
                    billOf5-=3;
                }
                else return false;
            }
        }

        return true;

        
    }
}