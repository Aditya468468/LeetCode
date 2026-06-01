class Solution 
{
    private void canVisit(int idx,List<List<Integer>> rooms,boolean[]visited)
    {

        if(visited[idx])// Already Visited.
        {
            return;
        }
        visited[idx] = true;
        List<Integer> list=rooms.get(idx);
        for(int i=0;i<list.size();i++)
        {
            if(visited[list.get(i)]==false)
            {
                canVisit(list.get(i),rooms,visited);
            }
        }

        return;
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) 
    {
        boolean visited[]=new boolean[rooms.size()];
        
        canVisit(0,rooms,visited);
        
         for(int i=0;i<visited.length;i++)
         {
            if(!visited[i]) return false;
         }

         return true;
        
    }
}