class Solution {
    public boolean checkValid(int[][] matrix) 
    {
        // set.size()->n for every row and coln.
        // for a n len-> we need n diff elements then only all n will be presnt.
        //Lets check the rows first.
        int n=matrix.length;
        int m=matrix[0].length;
        
        for(int i=0;i<n;i++)
        {
            Set<Integer> set=new HashSet<>(); // for Unique.
            for(int j=0;j<m;j++)
            {
                set.add(matrix[i][j]);
            }
            if(set.size()!=n) return false;
        }

        for(int i=0;i<n;i++)
        {
            Set<Integer> set=new HashSet<>(); // for Unique.
            for(int j=0;j<m;j++)
            {
                set.add(matrix[j][i]);
            }
            if(set.size()!=n) return false;
        }

        return true;



        
    }
}