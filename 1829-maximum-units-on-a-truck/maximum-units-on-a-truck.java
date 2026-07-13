class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) 
    {
        Arrays.sort(boxTypes,(a,b)->
        {
            return b[1]-a[1];
        });

        long total=0;
        for(int i=0;i<boxTypes.length;i++)
        {
            if(truckSize==0) break;
            int take=Math.min(boxTypes[i][0],truckSize);
            total+=(1L)*(take*boxTypes[i][1]);
            truckSize-=take;
        }

        return (int)total;
        
    }
}