class Solution {
    public void comb(int idx,List<List<Integer>> ans,List<Integer> list,int n,int k)
    {
        if(list.size()==k)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(idx>n) return;
        //Take it.
        list.add(idx);
        comb(idx+1,ans,list,n,k);
        list.remove(list.size()-1); //Backtrack/Undo
        //Not Take.
        comb(idx+1,ans,list,n,k);
    }
    public List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        comb(1,ans,new ArrayList<>(),n,k);

        return ans;

        
    }
}