class Solution {
    public int candy(int[] ratings) 
    {
        int n=ratings.length;
        int[] candies=new int[n];
        
        //Left Cost, ith idx is just concerned about its Left Neighbour
        candies[0]=1; // No left Neighbour, Acc to left cons it should get 1 candy
        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1])
            {
                candies[i]=candies[i-1]+1; // Slightly More (Just 1);
            }
            else
            {
                candies[i]=1; //Complusory case
            }

        }
        //Right Cons
        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1])
            {
                candies[i]=Math.max(candies[i],candies[i+1]+1);
                // Well It should be more than right, but it already having 
                // a satisfying cand towards its left,so decide an ans
                //without destroying both
            }
           
        }

        int sum=0;
        for(int x:candies)
        {
            sum+=x;
        }

        return sum;
        
    }
}