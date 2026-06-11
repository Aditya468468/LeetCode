class Solution 
{
    long MOD=1_000_000_007;
    int maxDepth=0;
    private long pow(long x, long n)
    {
        if(n==0)
        {
            return 1;
        }
        if(n%2==0)
        {
            return pow((x*x)%MOD,n/2);
        }
        else 
        {
            return (x*pow(x,n-1))%MOD;
        }
    }
    private void dfs(int curr,int parent,int depth,Map<Integer,List<Integer>> map)
    {
        if(depth>maxDepth)
            {
                maxDepth=depth;
            }
        if(!map.containsKey(curr))
        {
            return;
        }
        List<Integer> list=map.get(curr);
        for(int i=0;i<list.size();i++)
        {
            int next=list.get(i);
            if(parent==next) continue; //don't go back to parent
            dfs(next,curr,depth+1,map);
        }

        return;
    }
    public int assignEdgeWeights(int[][] edges) 
    {
        //Create a Adj list.
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            if(!map.containsKey(u))
            {
                map.put(u,new ArrayList<>());
            }
            if(!map.containsKey(v))
            {
                map.put(v,new ArrayList<>());
            }
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(v).add(u);
        }
        dfs(1,-1,0,map); // We have Max Depth Now.
        if(maxDepth==0) return 0;
        return (int)((pow(2,maxDepth-1))%MOD);


        
    }
}