class Solution {
    public int leftCandle(char[]nums,List<Integer> list,int i)
    {
        int low=0;
        int high=list.size()-1;
        int ans=list.size();
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(list.get(mid)>=i)
            {
                ans=mid;
                high=mid-1;
            }
            else 
            {
                low=mid+1;
            }

        }
        return ans;

    }
    public int rightCandle(char[]nums,List<Integer> list,int j)
    {
        int low=0;
        int high=list.size()-1;
        int ans=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(list.get(mid)<=j)
            {
                ans=mid;
                low=mid+1;
            }
            else 
            {
                high=mid-1;
            }

        }
        return ans;

    }
    public int[] platesBetweenCandles(String s, int[][] queries) 
    {
        char []nums=s.toCharArray();
        HashMap<Integer,Integer> plates=new HashMap<>();
        int star=0;
        int size=nums.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<size;i++)
        {
            if(nums[i]=='|') list.add(i);
            else
            {
                star++;
            }
              plates.put(i,star);
        }
        int n=queries.length;
        int []result=new int[n];
        for(int i=0;i<n;i++)
        {
            int left=queries[i][0];
            int right=queries[i][1];
            int firstCandle=leftCandle(nums,list,left);
            int lastCandle=rightCandle(nums,list,right);
            if(firstCandle<=lastCandle)
            {
            int leftIndex=list.get(firstCandle);
            int rightIndex=list.get(lastCandle);
            int value=plates.get(rightIndex)-plates.get(leftIndex);
            result[i]=value;
            }
            else 
            {
                result[i]=0;
            }
        }
        

        return result;


        
    }
}