class Solution {

    boolean isValid(int num,int idx)
    {
        if(num%idx==0 || idx%num==0) return true;
        return false;

    }
    public int generate(int idx,int n,boolean[]used)
    {
        if(idx>n)
        {
            return 1;
        }
        int cnt=0;
        for(int i=1;i<=n;i++)
        {
            if(used[i]==true) continue;
            if(isValid(i,idx))
            {
                used[i]=true;
                cnt+=generate(idx+1,n,used);
                used[i]=false;
            }
    
        }

        return cnt;

    }
    public int countArrangement(int n) 
    {
    
        return generate(1,n,new boolean[n+1]);
        

        
    }
}