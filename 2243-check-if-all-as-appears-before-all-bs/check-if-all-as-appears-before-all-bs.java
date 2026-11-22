class Solution {
    public boolean checkString(String s) 
    {
        //We need to see the last occur of a and first occur of b

        int lastA=-1;
        int firstB=-1;

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);

            if(ch=='a')
            {
                lastA=i;
            }
            else 
            {
                if(firstB==-1)
                {
                    firstB=i;
                }
            }
        }

        if(firstB==-1) return true; // Never seen b
        if(lastA==-1) return true; //Never seen a

        if(lastA<firstB) return true;

        return false;        
    }
}