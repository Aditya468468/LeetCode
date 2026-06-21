class Solution 
{
    private void countSort(int[]costs)
    {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int x:costs)
        {
            min=Math.min(x,min);
            max=Math.max(max,x);
        }
        int []freq=new int[max+1];
        for(int x:costs)
        {
            freq[x]++;
        }
        int idx=0;
        for(int i=min;i<freq.length;i++)
        {
            if(freq[i]!=0)
            {
                while(freq[i]!=0)
                {
                    costs[idx++]=i;
                    freq[i]--;
                }
            }

        }
        return;

    }
    public int maxIceCream(int[] costs, int coins) 
    {
        countSort(costs);
        int i=0;
        int n=costs.length;
        int cnt=0;
        while(i<n && coins!=0)
        {
            if(costs[i]>coins) break;
            coins-=costs[i];
            i++;
            cnt++;
        }
        return cnt;


    }
}