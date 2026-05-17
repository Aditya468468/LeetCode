class Solution 
{
    private boolean explore(int[]arr,int pos,boolean[] visited)
    {
        if(pos>=arr.length || pos<0)
        {
            return false;
        }
        if(visited[pos]==true)
        {
            return false;
        }

        if(arr[pos]==0)
        {
            return true;
        }
        visited[pos]=true;
        if(explore(arr,pos+(arr[pos]),visited)) return true;
        if(explore(arr,pos-(arr[pos]),visited)) return true;

        return false;

    }
    public boolean canReach(int[] arr, int start) 
    {
        return explore(arr,start,new boolean[arr.length]);
        
    }
}