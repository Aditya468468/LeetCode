class Solution {
    public boolean uniformArray(int[] nums1) 
    {
        int countOdd=0;
        int countEven=0;
        for(int i=0;i<nums1.length;i++)
            {
                if(nums1[i]%2==0)
                {
                    countEven++;
                }
                else
                {
                    countOdd++;
                }
            }
        // All odd.
        boolean isOdd=true;
        for(int i=0;i<nums1.length;i++)
            {
              if(nums1[i]%2==0)
              {
                  if(countOdd==0)
                  {
                     isOdd=false;
                      break;
                  }
              }
            }
        //Even 
        boolean isEven=true;
        for(int i=0;i<nums1.length;i++)
            {
              if(nums1[i]%2!=0)
              {
                  if(countEven==0)
                  {
                      isEven=false;
                      break;
                  }
              }
            }

        return (isOdd || isEven);
        
        
        
        
    }
}