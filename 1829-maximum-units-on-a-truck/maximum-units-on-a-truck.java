class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) 
    {
        int n=boxTypes.length;
        Arrays.sort(boxTypes,(a,b)->
        {
            return b[1]-a[1];
        });

        long maxUnits=0;
        for(int i=0;i<n;i++)
        {
            if(truckSize==0) break;
            int take=Math.min(truckSize,boxTypes[i][0]);
            maxUnits+=(1L)*(take*boxTypes[i][1]);
            truckSize=truckSize-take;

        }

        return (int)maxUnits;
        
    }
}