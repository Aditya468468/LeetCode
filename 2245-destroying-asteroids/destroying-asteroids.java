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
        for(int i=min;i<=max;i++)
        {
            if(freq[i]!=0)
            {
                if(i>totalMass)
                {
                    return false;
                }
                totalMass+=(long)i*freq[i];
            }
            
        }


        return true;
        
    }
}