class Solution 
{
    class Pair
    {
        int row;
        int col;
        //Cons
        public Pair(int row,int col)
        {
            this.row=row;
            this.col=col;
        }
    }
    public int firstCompleteIndex(int[] arr, int[][] mat) 
    {
        Map<Integer,Pair> map=new HashMap<>();
        //Lets make it
        int n=mat.length;
        int m=mat[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                Pair p=new Pair(i,j);
                map.put(mat[i][j],p);
            }
        }
        // we are able to Map values->Cell because Values Are Unique.
        // After Pre-processing Querying is Easy.
        Map<Integer,Integer> paintedRow=new HashMap<>(); //Row is painted when RowNum->Count==n
        Map<Integer,Integer> paintedCol=new HashMap<>();
        //Col is Painted when ColNum->Count==m
        // Start Painting
        for(int i=0;i<arr.length;i++)
        {
            int key=arr[i];
            Pair p=map.get(key);
            int r=p.row;
            int c=p.col;
            paintedRow.put(r,paintedRow.getOrDefault(r,0)+1);
            paintedCol.put(c,paintedCol.getOrDefault(c,0)+1);

            if(paintedRow.get(r)==m || paintedCol.get(c)==n)
            {
                return i;
            }


        }

        return -1;
        
        
    }
}