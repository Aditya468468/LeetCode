class Solution {
    public int maxArea(int[] height) 
    {
        int i=0;
        int j=height.length-1; // Maximise the width;
        int maxArea=0;
        while(i<j)
        {
            int area=Math.min(height[i],height[j])*(j-i);
            maxArea=Math.max(area,maxArea);
            if(height[i]<height[j]) // We move i in order to find bigger building,without changing the exxisting larger building at the right 
            {
                i++;
            }
            else if(height[j]<height[i]) //Same 
            {
                j--;
            }
            else // Heights are same but maybe we can get more better on both sides,
                    // because same heights and widht max has being recorded.as we consider the Min height as our bottleneck.even if we bigger building at one side ans will still be the min, soo we can safely move both
            {
                i++;
                j--;
            }
        }

        return maxArea;
        
    }
}