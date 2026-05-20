class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) 
    {
        int n=A.length;
        Set<Integer> setA=new HashSet<>();
        Set<Integer> setB=new HashSet<>();
        int []prefix=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            if(A[i]==B[i])
            {
                cnt++;
            }
            else
            {
                if(setA.contains(B[i]))
                {
                    cnt++;
                }
                if(setB.contains(A[i]))
                {
                    cnt++;
                }
            }
            setA.add(A[i]);
            setB.add(B[i]);
            prefix[i]=cnt;
        }

        return prefix;
        
    }
}