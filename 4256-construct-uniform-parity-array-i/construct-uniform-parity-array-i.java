class Solution {
    public boolean uniformArray(int[] nums1) 
    {
        // Odd-even/Even-Odd-> 3-2=1 -> Odd 
        // Even-Even=Even-> 8-4=4
        // Odd-Odd=7-3=3--> Even

        //All Odds

        int oddCount=0;
        int evenCount=0;

        for(int i=0;i<nums1.length;i++)
        {
            if(nums1[i]%2==0)
            {
                evenCount++;
            }
            else
            {
                oddCount++;
            }
        }

        if(evenCount==0 || oddCount==0 || evenCount>0 || oddCount>0)
        {
            return true;
        }


        return false;





        
    }
}