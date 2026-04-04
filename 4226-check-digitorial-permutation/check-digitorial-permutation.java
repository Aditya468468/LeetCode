class Solution {
    
    private long factorial(long n)
    {
        long fact=1;
        for(int i=1;i<=n;i++)
        {
            fact*=i;
        }
        
        return fact;
        
    }
    public boolean isDigitorialPermutation(int n) 
    {
        if(n==0) return false;
        int factSum=0;
        int temp=n;
        HashMap<Long,Integer> map=new HashMap<>();
        while(temp!=0)
        {
            long ld=temp%10;
            map.put(ld,map.getOrDefault(ld,0)+1);
            factSum+=factorial(ld);
            temp/=10;
        }

        while(factSum!=0)
        {
            long ld=factSum%10;
            if(!map.containsKey(ld)) return false;
            map.put(ld,map.get(ld)-1);
            if(map.get(ld)==0) map.remove(ld);
            factSum/=10;
        }

        if(map.isEmpty()) return true;
        return false;



        
    }
}