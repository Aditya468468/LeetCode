class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) 
    {
        //rectangle 1
        List<Integer> x1=new ArrayList<>(List.of(rec1[0],rec1[2]));
        List<Integer> y1=new ArrayList<>(List.of(rec1[1],rec1[3]));

        //rectangle 2
        List<Integer> x2=new ArrayList<>(List.of(rec2[0],rec2[2]));
        List<Integer> y2=new ArrayList<>(List.of(rec2[1],rec2[3]));

        boolean overlap=false;

        if((x1.get(1)>x2.get(0) && x2.get(1)>x1.get(0)) && (y1.get(1)>y2.get(0) && y2.get(1)>y1.get(0)))
        {
            return true;
        }

       
        return false;

        
    }
}