
class Solution {
    public int sumSubarrayMins(int[] arr) 
    {

        long mod = 1_000_000_007;
        int n=arr.length;
        int []nseR=new int[n];
        int []nseL=new int[n];
        Stack<Integer> st=new Stack<>();
        //nseR
        for(int i=0;i<n;i++)
        {
            if(!st.isEmpty())
            {
                while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                {
                    nseR[st.pop()]=i;
                }
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            nseR[st.pop()]=n;
        }

        //nseL
        for(int i=n-1;i>=0;i--)
        {
            if(!st.isEmpty())
            {
                while(!st.isEmpty() && arr[st.peek()]>arr[i])
                {
                    nseL[st.pop()]=i;
                }
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            nseL[st.pop()]=-1;
        }
        
        long sum=0;

        for(int i=0;i<n;i++)
        {
            sum+=(1L)*(arr[i])*((i-nseL[i])*(nseR[i]-i));
        }

        return (int)(sum%mod);



          
    }
}
