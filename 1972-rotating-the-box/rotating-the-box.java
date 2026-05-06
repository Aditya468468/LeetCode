class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) 
    {
        int n=boxGrid.length;
        int m=boxGrid[0].length;
        char[][]ans=new char[m][n];
        // 
        for(int i=0;i<n;i++)
        {
            int gapIdx=-1; //Keeps track of first Gap.
            for(int j=m-1;j>=0;j--)
            {
                char ch=boxGrid[i][j];
                if(gapIdx==-1 && boxGrid[i][j]=='.')
                {
                    gapIdx=j; //store first Gap.
                }
                else if(ch=='*')
                {
                    gapIdx=-1; //As Obs comes, Now prev Gaps are irrelevant.
    
                }
                else if(ch=='#' && gapIdx!=-1)
                {
                    
                    char temp=boxGrid[i][gapIdx];
                    boxGrid[i][gapIdx]=boxGrid[i][j];
                    boxGrid[i][j]=temp;
                    gapIdx--; // As Gaps are Consecutive.
        
                }
            }
        }
        //Build Ans.

        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<m;j++)
            {
                ans[j][n-1-i]=boxGrid[i][j]; 

            }
        }



        return ans;
        
    }
}