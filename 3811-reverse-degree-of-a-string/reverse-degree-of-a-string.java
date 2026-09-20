class Solution {
    public int reverseDegree(String s) 
    {
        int n=s.length();
        int sum=0;
        for(int i=0;i<n;i++)
        {
            int val=26-(s.charAt(i)-'a');
            int product=val*(i+1);
            sum+=product;

        }        

        return sum;
    }
}