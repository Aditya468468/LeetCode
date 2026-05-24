class Solution {
    public int passwordStrength(String password) 
    {
        HashSet<Character> set=new HashSet<>();
        for(char x:password.toCharArray())
        {
            set.add(x);
        }
        HashSet<Character> splcheck=new HashSet<>();
        splcheck.add('#');
        splcheck.add('!');
        splcheck.add('@');
        splcheck.add('$');
    //
        long points=0;
        for(char x:set)
            {
                if(splcheck.contains(x))
                {
                    
                    points+=5;
    
                }
                else if(Character.isDigit(x))
                {
                    
                    points+=3;
                         
                }
                else if(Character.isUpperCase(x))
                {
                  
                    points+=2;
     
                }
                else if(Character.isLowerCase(x))
                {
                   points+=1;
                        
                }
                
            }
        
        return (int)points;
    }
}