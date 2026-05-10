class Solution 
{
   
    public int[] countWordOccurrences(String[] chunks, String[] queries) 
    {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<chunks.length;i++)
            {
                str.append(chunks[i]);
            }
        //We Have it now.
        String s=str.toString();
        
        HashMap<String,Integer> map=new HashMap<>();
        int i=0;
        StringBuilder word=new StringBuilder();
        while(i<str.length())
            {
        
                char x=str.charAt(i);
                
                if(Character.isLetter(x) && Character.isLowerCase(x))
                {
                    word.append(x);
                }
                else if(x=='-')
                {
                    boolean leftC=false;
                    boolean rightC=false;
                    if(i!=0)
                    {
                        char left=str.charAt(i-1);
                        if(Character.isLetter(left) && Character.isLowerCase(left))
                        {
                            leftC=true;
                        }
                    }
                    if(i<str.length()-1)
                    {
                        char right=str.charAt(i+1);
                        if(Character.isLetter(right) && Character.isLowerCase(right))
                        {
                            rightC=true;
                        }
                        
                    }
                    if(leftC&&rightC)
                    {
                        word.append("-");
                    }
                    else
                    {
                        if(word.length()>0)
                        {
                           
                            
                                String temp=word.toString();
                                map.put(temp,map.getOrDefault(temp,0)+1);
                               
                            
                            word.setLength(0);
                        }
                        
                    }
                }
                else
                {
                    if(word.length()>0)
                    {
                       
                        
                             String temp=word.toString();
                                map.put(temp,map.getOrDefault(temp,0)+1);
                            
                        
                        word.setLength(0);
                    }
                    
                }
                i++; 
                
            }
        
                    if(word.length()>0)
                    {
                       
                        
                             String temp=word.toString();
                             map.put(temp,map.getOrDefault(temp,0)+1);
                            
                        
        
                    }
        
        
        int []ans=new int[queries.length];
        for(int j=0;j<queries.length;j++)
            {
                if(!map.containsKey(queries[j]))
                {
                    ans[j]=0;
                }
                else 
                {
                    ans[j]=map.get(queries[j]);
                }
            }
    
        
        return ans;
        
        
        
    }
}