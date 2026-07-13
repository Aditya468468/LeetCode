class Solution {
    public int numRescueBoats(int[] people, int limit) 
    {
        Arrays.sort(people);
        int cnt=0;
        int n=people.length;
        int i=0;
        int j=n-1;
        while(i<=j)
        {
            if(people[i]+people[j]<=limit)
            {
                i++;
                j--;
            }
            else
            {
                //if(people[j]<=limit) Not needed due to Constraints;
                j--;
            }
             cnt++;
        }

        return cnt;
        
    }
}