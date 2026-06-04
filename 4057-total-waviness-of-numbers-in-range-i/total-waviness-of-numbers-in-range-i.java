class Solution 
{
    private int totalWaves(List<Integer>list)
    {
        if(list.size()<3) return 0;
        //Give 1st and Last cant be peak/Valley so we can skip EDGE cases.
        int cnt=0;
        for(int i=1;i<list.size()-1;i++)
        {
            if(list.get(i-1)<list.get(i) && list.get(i)>list.get(i+1))
            {
                cnt++;
            }
            else if(list.get(i-1)>list.get(i) && list.get(i)<list.get(i+1))
            {
                cnt++;
            }
        }
        return cnt;
    }
    private List<Integer> extract(int x)
    {
        List<Integer> list=new ArrayList<>();
        while(x!=0)
        {
            list.add(x%10);
            x/=10;
        }

        Collections.reverse(list);
        return list;

    }
    public int totalWaviness(int num1, int num2) 
    {
        int cnt=0;
        for(int i=num1;i<=num2;i++)
        {
            cnt+=totalWaves(extract(i));
        }

        return cnt;

        
    }
}