class Solution {
    public int closestTarget(String[] words, String target, int startIndex) 
    {
        int clock=-1;
        int anti=-1;
        int n=words.length;

        //Move clock wise
        int ind=startIndex;
        for(int i=0;i<n;i++) // n-steps
        {
            if(words[ind].equals(target))
            {
                clock=i;
                break;
            }
            ind=(ind+1)%n;
        }
        //Move Anti clock.
        int steps=0;
        int idx=startIndex;
        while(steps<n)
        {
            String str=words[idx];
            if(str.equals(target))
            {
               anti=steps;
               break;
            }
            idx=(idx-1+n)%n;
            steps++;
        }


        if(anti==-1 && clock==-1) return -1;
        return (int)Math.min(clock,anti);
        
    }
}