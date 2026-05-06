class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) 
    {
        int n=boxGrid.length;
        int m=boxGrid[0].length;
        char[][]ans=new char[m][n];
        // 
        for(int i=0;i<n;i++)
        {
            for(int j=m-1;j>=0;j--)
            {
                char ch=boxGrid[i][j];
                if(ch=='#')
                {
                    int k=j;
                    while(k<m-1 && boxGrid[i][k+1]=='.')
                    {
                        char temp=boxGrid[i][k];
                        boxGrid[i][k]=boxGrid[i][k+1];
                        boxGrid[i][k+1]=temp;
                        k++;
                    }
                }
            }
        }
        //Build Ans.

        for(int i=n-1;i>=0;i--)
        {
            for(int j=0;j<m;j++)
            {
                ans[j][n-1-i]=boxGrid[i][j]; //Ahh spent more time thinking Maths.

            }
        }



        return ans;
        
    }
}