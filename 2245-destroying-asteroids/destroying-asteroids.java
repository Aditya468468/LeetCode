class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) 
    {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int x:asteroids)
        {
            if(x<min) min=x;
            if(x>max) max=x;
        }
        int[]freq=new int[max+1];
        for(int i=0;i<asteroids.length;i++)
        {
            freq[asteroids[i]]++;
        }
        long totalMass=mass;
        long sum=0;
        int i=min;
        while(i<=max)
        {
            if(freq[i]!=0) // If that Asteroid exists.
            {
                if(i>totalMass)
                {
                    if(sum==0) return false; //No Prior asteroids to added up.
                    totalMass+=sum;
                    sum=0;
                    continue;
                }
                sum+=(long)i*freq[i];
            }
            i++;
        }

        return true;
        
    }
}