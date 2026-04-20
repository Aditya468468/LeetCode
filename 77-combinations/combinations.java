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
        //for-loop
        for(int i=idx;i<=n;i++)
        {

            list.add(i);
            comb(i+1,n,k,ans,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        comb(1,n,k,ans,new ArrayList<>());
        return ans;

        
    }
}