
class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);

        int j=0;
        int m=passengers.length;
        int n=buses.length;
        int lastPassenger=-1;

        for(int i=0;i<n;i++)
        {
            int cnt=0;
            while(j<m && passengers[j]<=buses[i] && cnt<capacity)
            {
                cnt++;
                lastPassenger=passengers[j];
                j++;
            }

            //We wait till everybus is processed.
            if(i==n-1)
            {
                int ans=-1;
                int idx=-1;
                if(cnt<capacity)
                {
                    ans=buses[i];
                    idx=j-1;
                }
                else
                {
                    ans=lastPassenger-1;
                    idx=j-2;
                }

                while(idx>=0 && passengers[idx]==ans)
                {
                    ans--;
                    idx--;
                }

                return ans;
            }
        }


            return -1;
       
    }
}