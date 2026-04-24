class Solution {

    boolean isValid(int num,int idx)
    {
        if(num%idx==0 || idx%num==0) return true;
        return false;

    }
    public int generate(int idx,int n,List<Integer> list, boolean[]used)
    {
        if(idx>n)
        {
            return 1;
        }
        int cnt=0;
        for(int i=1;i<=n;i++)
        {
            if(used[i]==true) continue;
            used[i]=true;
            if(isValid(i,idx))
            {
                list.add(i);
                cnt+=generate(idx+1,n,list,used);
                list.remove(list.size()-1);
            }
            used[i]=false;
        }

        return cnt;

    }
    public int countArrangement(int n) 
    {
    
        return generate(1,n,new ArrayList<>(),new boolean[n+1]);
        

        
    }
}