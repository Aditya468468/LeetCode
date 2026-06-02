class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) 
    {
        int n=experience.length;
        //It will lose Energy,After Each battle,No GAIN Throughout.
        //Soo It should have More Energy then All Opponentes,So It can tackle all
        int sum=0;
        for(int x:energy)
        {
            sum+=x;
        }
        int hrs=0;
        if(sum>=initialEnergy) hrs=(sum-initialEnergy)+1;
        //It will gain experince, Lil tricky
        // Lets just keep fighting and gaining till where i Can.
        int idx=-1;
        for(int i=0;i<n;i++)
        {
            if(experience[i]<initialExperience)
            {
                initialExperience+=experience[i];
            }
            else
            {
                int need=experience[i]-initialExperience+1;
                hrs+=need;
                initialExperience+=need; // Trained it
                initialExperience+=experience[i]; //Won it
            }
        }
        
        return hrs;
        
    }
}