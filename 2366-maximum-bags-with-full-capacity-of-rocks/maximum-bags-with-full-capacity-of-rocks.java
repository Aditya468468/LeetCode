class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) 
    {
        // The idea is to Maximize the Bags,
        // We need more numbers of bags not quantity in boxs.
        // So we fill whose needs less rocks.. So we can inc the count of Boxes.
        // And also Safe resources for future..
        // Eg need[]={4,1,1,1,1} , add=4, if i allot all to 0th-> 1 bag,
        // but 1,2,3,4 idx=4 bags
        // SO WE FILL ON BY NEEDS

        int n=capacity.length;
        int[]need=new int[n];
        for(int i=0;i<n;i++)
        {
            need[i]=capacity[i]-rocks[i];
        }
        
        Arrays.sort(need); // Lower need will be processed first.
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(need[i]==0) count++;
            else
            {
                if(need[i]>additionalRocks) break; // if we cant fulfil its need further we cant as Sorted need
                count++;
                additionalRocks-=need[i];
            }
        }

        return count;
        
    }
}