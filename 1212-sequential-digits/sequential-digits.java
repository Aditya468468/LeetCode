class Solution 
{
    public void generate(int curr,List<Integer> list,StringBuilder str,int prev,int low, int high)
    {
       
        if(str.length()>=2)
        {
            int num = Integer.parseInt(str.toString());
             if(num>=low && num<=high)
             {
                list.add(num);
             }
             if(num>high)     
                return;
        }

        if(curr>9 || (curr-prev!=1 && prev!=-1)) return;

        if(prev==-1)
        {
            //Start
            str.append(curr);
            generate(curr+1,list,str,curr,low,high);
            str.deleteCharAt(str.length()-1);

            // Dont start
            generate(curr+1,list,str,-1,low,high);
        }
        else
        {
            //pick
            str.append(curr);
            generate(curr+1,list,str,curr,low,high);
            str.deleteCharAt(str.length()-1);

        }
      
        
    }
    public List<Integer> sequentialDigits(int low, int high) 
    {
        List<Integer> list = new ArrayList<>();
        generate(1,list,new StringBuilder(),-1,low,high);

        Collections.sort(list);
        return list;
    
        
    }
}