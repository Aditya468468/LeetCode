class Solution {
    public int numRescueBoats(int[] people, int limit) 
    {
        Arrays.sort(people); // In order to organise weights to choose effi
        int cnt=0;
        int n=people.length;
        int i=0;
        int j=n-1;
        while(i<=j)
        {
            if(people[i]+people[j]<=limit) // The best Pair is Heavy(As we need to fit he first+ Light (as A filler for space))
            {
                i++;
                j--; //Paired
            }
            else
            {
                //if(people[j]<=limit) Not needed due to Constraints;
                j--; // If we cant make pair with ith , We cant make pair with (i+1)th as they are more heavier.. (Sorted) ,So He needs to Go Alone.
            }
             cnt++;
        }

        return cnt;
        
    }
}