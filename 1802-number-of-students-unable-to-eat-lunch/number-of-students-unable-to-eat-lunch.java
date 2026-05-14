class Solution {
    public int countStudents(int[] students, int[] sandwiches) 
    {
        Deque<Integer> stud=new ArrayDeque<>();
        for(int x:students)
        {
            stud.add(x);
        }
        // Stack<Integer> s=new Stack<>();
        ArrayList<Integer> list=new ArrayList<>();
        for(int x:sandwiches)
        {
            list.add(x);
        }
       
        int cnt=0;
        
        while(!list.isEmpty()) //i-> top
        {
            int len=stud.size();
            int idx=0;
            boolean eat=false;
            while(!stud.isEmpty() && len != idx)
            {
                int elm=stud.peek();
                if(elm==list.get(0))
                {
                    list.remove(0);
                    stud.poll();
                    eat=true;
                    break;
                }
                else
                {
                    int elem=stud.peek();
                    stud.pollFirst();
                    stud.offerLast(elem);
                    
                }
                idx++;
                
            }
             if(!eat) break;
        }

        return list.size();
        

       
        
    }
}