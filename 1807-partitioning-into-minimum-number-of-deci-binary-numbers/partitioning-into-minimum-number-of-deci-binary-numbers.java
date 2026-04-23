class Solution {
    public int minPartitions(String n) 
    {
        int max=Integer.MIN_VALUE;

        for(int i=0;i<n.length();i++)
        {
            int digit=n.charAt(i)-'0';
            if(digit>max) max=digit;
        }

        return max;

        
    }
}