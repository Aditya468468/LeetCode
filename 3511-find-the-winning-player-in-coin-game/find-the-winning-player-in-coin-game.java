class Solution {
    public String winningPlayer(int x, int y) 
    {
        boolean turn=true;
        // true->Alice, false->Bob.
        //We need to make total 115..(in lesser use of coins?? ig)
        //But i need to exhaust more coins,so other can loose.
        //Soo-> Lets start by picking less amt coins???->But see we need 115.
        //Soo We cant make 115->With only x or only y's soo we Need both.

        //Lets pick x,then we see-> How many y's.
        // To make 115-> We always Need-> 1 x and 4 y's
    
        while(x>=1 && y>=4)
        {
            x-=1;
            y-=4;
            if(turn)
            {
                turn=false;
            }
            else
            {
                turn=true;
            }
            
        }

        if(turn) return "Bob";
        return "Alice";

        
    }
}