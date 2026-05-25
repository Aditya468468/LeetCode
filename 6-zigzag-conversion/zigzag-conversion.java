class Solution {
    public String convert(String s, int numRows) 
    {
        /*
                |    /|    /|    /|
                |  /  |  /  |  /  |
                |/    |/    |/    |
        */
        int n=s.length();
        if(numRows<=1 || n<=1) return s; //Asked GPT this Edge Case.
        char[][] grid=new char[numRows][2*(n-1)];
        char []nums=s.toCharArray();
        boolean down=true;
        int col=0;
        int row=0;
        for(int i=0;i<nums.length;i++)
        {
            if(row==numRows)
            {
                row=numRows-2;
                col++;
                down=false;
            }
            if(row<0)
            {
                row=1;
                down=true;

            }
            if(down)
            {
                grid[row][col]=nums[i];
                row++;
            }
            if(!down)
            {
                grid[row][col]=nums[i];
                row--;
                col++;

            }
           
        }
        StringBuilder str=new StringBuilder();
        for(int i=0;i<numRows;i++)
        {
            for(int j=0;j<s.length();j++)
            {
                if(grid[i][j]!='\u0000')
                {
                    str.append(grid[i][j]);
                }
            }
        }

        return str.toString();
    }
}