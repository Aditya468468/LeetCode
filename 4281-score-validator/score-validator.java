class Solution {
    public int[] scoreValidator(String[] events) 
    {
        int score=0;
        int cnt=0;
        for(int i=0;i<events.length;i++)
        {
            String s=events[i];
            if(s.equals("W"))
            {
                cnt++;
                if(cnt==10) break;
            }
            else if(s.equals("WD"))
            {
                score++;
            }
            else if(s.equals("NB"))
            {
                score++;
            }
            else
            {
                score+=(Integer.parseInt(s));
            }
        }
        return new int[]{score,cnt};

        
    }
}