class Solution 
{
    public void comb(int idx,List<List<Integer>> ans,List<Integer> list,int k,int sum)
    {
        if(sum==0 && list.size()==k)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum<=0 || list.size()>k || idx>9) return;
        //For-loop recursion 
        for(int i=idx;i<=9;i++)
        {
            if(i>sum) break;
            list.add(i);
            comb(i+1,ans,list,k,sum-i);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) 
    {

        List<List<Integer>> ans=new ArrayList<>();
        comb(1,ans,new ArrayList<>(),k,n);;

        return ans;
    }
}