class Solution {
    public String[] createGrid(int m, int n) 
    {
        String []ans=new String[m];
        for(int i=0;i<m;i++)
        {
            StringBuilder str=new StringBuilder();
            for(int j=0;j<n;j++)
            {
                if(i==m-1) str.append('.');
                else if(j==0) str.append('.');
                else str.append('#');
            }
            ans[i]=str.toString();
        }

        return ans;
        
    }
}