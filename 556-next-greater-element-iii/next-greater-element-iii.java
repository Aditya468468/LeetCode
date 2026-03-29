class Solution {
    public int nextGreaterElement(int n) 
    {
        ArrayList<Integer> list=new ArrayList<>();
        while(n!=0)
        {
            int digi=n%10;
            list.add(digi);
            n/=10;
        }
        Collections.reverse(list);
        int pivot=-1;
        for(int i=list.size()-2;i>=0;i--)
        {
            if(list.get(i)<list.get(i+1))
            {
                pivot=i;
                break;
            }
        }
        if(pivot==-1) return -1;
        int idx=-1;
        for(int i=list.size()-1;i>pivot;i--)
        {
            if(list.get(i)>list.get(pivot))
            {
                idx=i;
                break;
            }
        }
        int temp=list.get(pivot);
        list.set(pivot,list.get(idx));
        list.set(idx,temp);
        Collections.reverse(list.subList(pivot+1,list.size()));
        
        long ans=0;
        for(int i=0;i<list.size();i++)
        {
            int digit=list.get(i);
            ans=(ans*10)+digit;
        }
        if(ans>Integer.MAX_VALUE) return -1;
        return (int)ans;
       
        
        
    }
}