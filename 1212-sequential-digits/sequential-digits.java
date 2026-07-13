class Solution {

    public int countDigits(int num)
    {
        int len=0;
        while(num!=0)
        {
            len++;
            num/=10;
        }
        return len;
    }
    public void generateSeq(String ref, int low,int high,int k,List<Integer> list)
    {

        int left=0;
        for(int right=0;right<ref.length();right++)
        {
            while(right-left+1>k)
            {
                left++;
            }
            int len=right-left+1;
            if(len==k)
            {
                int num=Integer.parseInt(ref.substring(left,right+1));
                if(num>=low && num<=high) list.add(num);
        
            }
        }

    }
    public List<Integer> sequentialDigits(int low, int high) 
    {
        String ref="123456789";
        List<Integer> list=new ArrayList<>();
        int min=countDigits(low);
        int max=countDigits(high);
        int left=0;
        for(int i=min;i<=max;i++)
        {
            generateSeq(ref,low,high,i,list);
        }
        Collections.sort(list);
        return list;

        
    }
}