class Solution {
    public boolean lemonadeChange(int[] bills) 
    {
       
        int change=0; // Given in Ques
        int billOf5=0;
        int billOf10=0;

        for(int i=0;i<bills.length;i++) // Process smaller->larger
        {
            if(bills[i]==5) billOf5++;
            else if(bills[i]==10)
            {
                if(billOf5<1) return false;
                billOf5--;
                billOf10++;   
            }
            else
            {
                //20-> can give 10 one + 5 one
                // Or 5-> three., First we give 10 version as 5 bills we store for 10$ cus as they need the change of 5$
                if(billOf5<1) return false; // Both cases need atleast 1 billOf5.
                else if(billOf10>=1)
                {
                    billOf10--;
                    billOf5--;
                }
                else if(billOf10<1)
                {
                    if(billOf5<3) return false;
                    billOf5-=3; //used 3.
                }
            }
            

        }

        return true;

                        
        
        
    }
}