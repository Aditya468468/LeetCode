class Solution {
public:
    int furthestDistanceFromOrigin(string moves) 
    {
        // Greedy--> Either go All left or All Right because L&R cancel each other
        // And As we Want Max Dis->We choose All Left or All Right.
        int left=0;
        int right=0;
        int choice=0;
        for(int i=0;i<moves.size();i++)
        {
            char ch=moves[i];
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

        return abs(left-right);
        
    }
};