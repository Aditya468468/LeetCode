class Solution {
    public int furthestDistanceFromOrigin(String moves) 
    {
        // Greedy--> Either go All left or All Right because L&R cancel each other
        // And As we Want Max Dis->We choose All Left or All Right.
        int left=0;
        int right=0;
        int choice=0;
        for(int i=0;i<moves.length();i++)
        {
            char ch=moves.charAt(i);
            if(ch=='L') left++;
            else if(ch=='R') right++;
            else choice++;
        }
        if(left>right)
        {
            left+=choice;
        }
        else
        {
            right+=choice;
        }

        return Math.abs(left-right);
        
    }
}