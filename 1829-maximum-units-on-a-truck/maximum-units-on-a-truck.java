class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize)
    {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int total=0;
        int n=boxTypes.length;
        for(int i=0;i<n;i++)
        {
            int box=boxTypes[i][0];
            int units=boxTypes[i][1];
            int taken=Math.min(box,truckSize);
            long x=(taken*units);
            total+=(int)x;
            truckSize-=taken;
            if(truckSize==0) break;
        }
        return total;

        
    }
}