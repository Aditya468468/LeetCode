class Solution {
    public boolean checkValidString(String s) 
    {
        int minOpen=0;
        int maxOpen=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='(')
            {
                minOpen=minOpen+1;
                maxOpen=maxOpen+1;
            }
            else if(c==')')
            {
                minOpen=minOpen-1;
                maxOpen=maxOpen-1;
            }
            else
            {
                minOpen=minOpen-1;
                maxOpen=maxOpen+1;
            }
            if(minOpen<0) minOpen=0;
            if(maxOpen<0) return false;
        }

        return minOpen==0;
        
        
    }
}