class Solution {
    public boolean repeatedSubstringPattern(String s) 
    {
        int n=s.length();
        for(int i=1;i<=n/2;i++)
        {
            if(n%i!=0) continue;
            String str=s.substring(0,i);
            boolean match = true;
            
            for(int k=0;k<n;k+=i) // Try all possible statring
            {
                for(int p=0;p<i;p++)
                {
                    if(str.charAt(p)!=s.charAt(k+p))
                    {
                        match=false;
                        break;
                    }
                }
                    if(!match) break;
            }
                if(match) return true;
            
        }

        return false;
        
    }
}