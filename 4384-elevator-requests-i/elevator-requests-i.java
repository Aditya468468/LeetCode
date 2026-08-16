class Solution {
    public int elevatorRequests(int n, int[] requests) 
    {
        int currFloor=0;
        int totalTime=0;
        for(int i=0;i<requests.length;i++)
        {
            totalTime+=Math.abs(currFloor-requests[i]);
            currFloor=requests[i];
        }
        
        return totalTime;
    }
}