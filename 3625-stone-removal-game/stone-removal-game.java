class Solution {
    public boolean canAliceWin(int n) 
    {

        if(n<10) return false;

        boolean alice=true; //It handles turn.
        int turn=1;
        int prev=10;

        while(n>=prev)
        {
            if(turn==1) //handle first turn
            {
                n=n-prev;
                alice=false;
                turn++;
            }
            else
            {
                if(alice)
                {
                    n=n-prev;
                    alice=false;
                }
                else
                {
                    n=n-prev;
                    alice=true;
                }

            }

            prev--;
        }

        if(alice==true) return false; //if alice turn--> she loose
        else return true; // Else she wins
        
    }
}