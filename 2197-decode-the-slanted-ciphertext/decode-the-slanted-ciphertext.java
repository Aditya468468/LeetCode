class Solution {
    public String decodeCiphertext(String encodedText, int rows) 
    {
        int cols=encodedText.length()/rows;
        char [][]matrix=new char[rows][cols];
        int k=0;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                char x=encodedText.charAt(k++);
                matrix[i][j]=x;
            }
        }
        StringBuilder str=new StringBuilder();
        //Like stairCase.
        for(int j=0;j<cols;j++)
        {
            int x=j;
            for(int i=0;i<rows && x<cols;i++)
            {
                char c=matrix[i][x];
                x++;
                str.append(c);
            }
        }
        
        // Just Remove Trailing (last) Spaces
        int end=str.length()-1;
        while(end>=0 && str.charAt(end)==' ')
        {
            end--;
        }
        return str.substring(0,end+1).toString();

        
    }
}