class Solution 
{
    public void comb(int idx,int k,int target,List<Integer> list,List<List<Integer>> ans)
    {
        if(list.size()==k && target==0)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0 || idx>9) return;
        for(int i=idx;i<10;i++)
        {
            list.add(i);
            comb(i+1,k,target-i,list,ans);
            list.remove(list.size()-1);
        }

    }
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        comb(1,k,n,new ArrayList<>(),ans);

        return ans;


        
    }
}