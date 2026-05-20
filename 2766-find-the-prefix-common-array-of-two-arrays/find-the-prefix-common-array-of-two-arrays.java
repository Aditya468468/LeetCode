class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) 
    {
        int n=A.length;
        HashMap<Integer,Integer> mapA=new HashMap<>();
        HashMap<Integer,Integer> mapB=new HashMap<>();
        int []prefix=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            mapA.put(A[i],mapA.getOrDefault(A[i],0)+1);
            mapB.put(B[i],mapB.getOrDefault(B[i],0)+1);
            if(A[i]==B[i])
            {
                cnt++;
            }
            else
            {
                if(mapA.containsKey(B[i]))
                {
                    cnt+=mapA.get(B[i]);
                }
                if(mapB.containsKey(A[i]))
                {
                    cnt+=mapB.get(A[i]);
                }
            }
            prefix[i]=cnt;
        }

        return prefix;
        
    }
}