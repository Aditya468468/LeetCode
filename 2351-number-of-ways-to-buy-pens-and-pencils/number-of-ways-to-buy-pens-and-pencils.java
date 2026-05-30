class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) 
    {
        int totalPens=total/cost1;
        if(totalPens==0)
        {
            return (total/cost2)+1; 
        }
        int cntPen=0;
        long totalCnt=0;
        //How many pens i can buy,
        while(cntPen<=totalPens)
        {
            int balance=total-(cntPen*cost1);
            totalCnt+=(balance/cost2)+1;
            cntPen++;
        }
        

        return totalCnt;
    }
}