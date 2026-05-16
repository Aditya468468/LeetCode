class Solution {
    public boolean isLongPressedName(String name, String typed) 
    {
        int idx=0;
        int i=0;
        while(i<typed.length())
        {
            if(idx<name.length() && name.charAt(idx)==typed.charAt(i))
            {
                idx++;
                i++; //We Move Both
            }
            else if(i>0 && typed.charAt(i-1)==typed.charAt(i))
            {
                // can we still move-> Checking adj duplicates->Long Pressed.
                i++;
            }
            else
            {
                return false; //if both isnt well->FALSE
            }


        }

        return idx==name.length(); //Did we consume whole name
        
    }
}