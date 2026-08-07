class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) 
    {
        int currI=startPos[0];
        int currJ=startPos[1];
        int finalI=homePos[0];
        int finalJ=homePos[1];

        int cost=0;

        while(currI!=finalI || currJ!=finalJ)
        {
            // We have 4 choices, but make choices which makes us closer to home
            // --> Greedy Intution
            //Rows
            int rCost=Integer.MAX_VALUE;
            int newI=currI;
            if(currI<finalI) // Down
            {
                rCost=rowCosts[currI+1];
                newI=currI+1;
            } 
            else if(currI>finalI) //Up
            {
                rCost=rowCosts[currI-1];
                newI=currI-1;
            }
            //Cols
            int lCost=Integer.MAX_VALUE;
            int newJ=currJ;
            if(currJ<finalJ) // Right 
            {
                lCost=colCosts[currJ+1];
                newJ=currJ+1;
            } 
            else if(currJ>finalJ) //Left
            {
                lCost=colCosts[currJ-1];
                newJ=currJ-1;
            }

            if(rCost>lCost)
            {
                cost+=lCost;
                currJ=newJ;
            }
            else
            {
                cost+=rCost;
                currI=newI;
            }

        }

        return cost;
        
    }
}