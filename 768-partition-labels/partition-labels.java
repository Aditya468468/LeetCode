class Solution {
    public List<Integer> partitionLabels(String s) 
    {
        int n=s.length();
        int []firstIdx=new int[26];
        int []lastIdx = new int[26];
        Arrays.fill(firstIdx,-1);
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(firstIdx[ch-'a']==-1)
            {
                firstIdx[ch-'a']=i;
            }  
            lastIdx[ch-'a']=i;     
        }

        List<int[]> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            int idx=ch-'a';
            list.add(new int[]{firstIdx[idx],lastIdx[idx]});
        }
        Collections.sort(list,(a,b)->
        {
            return a[0]-b[0];
        });

        List<int[]> merge=new ArrayList<>();
        merge.add(list.get(0));
        for(int i=1;i<list.size();i++)
        {
            int[]prevInterval=merge.get(merge.size()-1);
            if(prevInterval[1]>=list.get(i)[0])
            {
                prevInterval[1]=Math.max(prevInterval[1],list.get(i)[1]);
            }
            else 
            {
                merge.add(list.get(i));
            }
        }

        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<merge.size();i++)
        {
            int len=merge.get(i)[1]-merge.get(i)[0]+1;
            ans.add(len);
        }

        return ans;
        
    }
}