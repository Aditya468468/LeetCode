class Solution 
{
    private void generate(int idx,int n,int k,List<List<Integer>> ans,List<Integer> list)
    {
        if(list.size()==k)
        {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(idx>n) return;
        //Pick That idx
        list.add(idx);
        generate(idx+1,n,k,ans,list);
        list.remove(list.size()-1); //Backtrack/Undoæ
        //Dont Take.
        generate(idx+1,n,k,ans,list);
    }
    public List<List<Integer>> combine(int n, int k) 
    {

        List<List<Integer>> ans = new ArrayList<>();
        generate(1,n,k,ans,new ArrayList<>());

        return ans;

        
    }
}