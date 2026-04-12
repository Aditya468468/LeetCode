class Solution 
{
    public void generate(int idx,List<List<Integer>> ans,List<Integer> list,int k,int n)
    {
        if(n==0 && list.size()==k)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(n<=0 || list.size()>k || idx>9) return; //prune.
        //Take it.
        list.add(idx);
        generate(idx+1,ans,list,k,n-idx);
        list.remove(list.size()-1);
        //Not take.
        generate(idx+1,ans,list,k,n);

    }
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        // 1,2,3,4,5...9 is already sorted with no duplicates.
        //-> soo same comb will not form.
        List<List<Integer>> ans=new ArrayList<>();
        generate(1,ans,new ArrayList<>(),k,n);

        return ans;

       
    }
}