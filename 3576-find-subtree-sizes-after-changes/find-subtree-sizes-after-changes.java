class Solution 
{
    public void dfs(int node,String s,List<List<Integer>> adjList,Map<Character,Integer> lastSeen,int []parent,int []newParent)
    {
        
        char ch=s.charAt(node);
        int prevState=lastSeen.getOrDefault(ch,-1);

        if(prevState!=-1)
        {
            //New Parent
            newParent[node]=prevState;
        }
        else
        {
            newParent[node]=parent[node]; // replicate the same relationship
        }
        //We update it for future
        lastSeen.put(ch,node);
        //start discovering childrens
        for(int i=0;i<adjList.get(node).size();i++)
        {
            int x=adjList.get(node).get(i);
            dfs(x,s,adjList,lastSeen,parent,newParent);
        } 
        //after we process this node we backtrack
        if(prevState==-1)
        {
            lastSeen.remove(ch);
        }
        else
        {
            lastSeen.put(ch,prevState);
        }

        return;
    }

    public int calculateSize(int node,List<List<Integer>> modifiedList,int[] ans)
    {
        int size=1;

        for(int i=0;i<modifiedList.get(node).size();i++)
        {
            int child=modifiedList.get(node).get(i);
            size+=calculateSize(child,modifiedList,ans);
        }
        ans[node]=size;

        return size;

    }
    public int[] findSubtreeSizes(int[] parent, String s) 
    {
        int n=parent.length;

        List<List<Integer>> adjList=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        //Converting parent rel to child one
        for(int i=1;i<n;i++)
        {
            int p=parent[i];
            adjList.get(p).add(i);  
        }

        //It to be passed to the dfs soo it can keep the new strcuture
        Map<Character,Integer> lastSeen=new HashMap<>();

        int []newParent=new int[parent.length];
        //Uff, lets revoke it

        dfs(0,s,adjList,lastSeen,parent,newParent);


        List<List<Integer>> modifiedList=new ArrayList<>();
        //Intialsing it
        for(int i=0;i<n;i++)
        {
            modifiedList.add(new ArrayList<>());
        }

        for(int i=1;i<n;i++)
        {
            int p=newParent[i];
            modifiedList.get(p).add(i);  
        }



        //Now we need to calculate the no of nodes
        //Top down approach will be O(N2) need to
        //think of bottom up--> O(N)

        int []ans =new int[parent.length];

        calculateSize(0,modifiedList,ans);

        return ans;

        
    }
}