class Solution 
{
    public void comb(int idx, int n, int k, List<List<Integer>> ans, List<Integer> list)
    {
        if(list.size()==k)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(list.size()>k || idx>n) return;
        //Take it
        list.add(idx);
        comb(idx+1,n,k,ans,list);
        list.remove(list.size()-1);
        //Not take
        comb(idx+1,n,k,ans,list);
    }
    public List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        comb(1,n,k,ans,new ArrayList<>());
        return ans;

        
    }
}