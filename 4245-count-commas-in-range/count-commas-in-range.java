class Solution {
    public int countCommas(int n) 
    {
        //1000-->100000--> 1 comma-> 100-> 99000
        //100000*10--> 1000000--> 100000000-->99000000

        //constraints--> 100,000
        if(n<1000) return 0;

        return (n-1000+1);


        
        
    }
}