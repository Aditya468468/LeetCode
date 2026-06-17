class Solution {
    public char processStr(String s, long k) 
    {
        int n=s.length();
        long []nums=new long[n];
        /*Pre-Process the len after each ops.
            char-> +1 to len;
            * -> -1 to len;
            # -> *2-> Doubles the len;
            % -> Doesnt Changes L.
        */
        long len=0;
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            if(x=='*' && len!=0) //There Should be some len,to Dec
            {
                len--;
            }
            else if(x=='#')
            {
                len*=2;
            }
            else if(x>='a' && x<='z')
            {
                len++;
            }
            nums[i]=len;
        }
        if(k<0 ||k>=nums[n-1]) return '.'; //out of bound.
        /*
            Now we Process from the back as we need kth elem after performing all the ops, But we cant actually make the String, Sooo we will have Len's of String, At each Step and we try to figure out and undo ops, and track the kth,
            When Reverse,-> '*'->Adds the +1-> As we traversing from back-> len inc when we move from i to i-1.
            'alpha'-> -1 When we move i to i-1 we remove,not add.
            '%'-> No change to l,
            '#'-> l->l/2.
            Now. How we track the Kth.
            -----------------------------------------------------------------
            '%'-> k=1 -> abcd,Current ans='b', Now ->'%'-> dcba, ans='c'-> k <->len-k-1. (As we reverse) ith changes to n-1-i element.
            ----------------------------------------------------------------
            'Alpha'-> we Remove the last ele,but we need to see,is the removed element our ans-> if k==len,--> aab-> k=2, (len-1)==2. in next step,
            len=2, aa, but ans is 'b' so we return here only if k==len-1,else fine we just -1 len and move.
            ------------------------------------------------------------------
            '*'-> It actually just adds an element in reversal proccess,Not No Impact.
            ------------------------------------------------------------------
            '#'-> In normal ops,its work is to Duplicate the String with itself only,
            ,Soo the char will exits in l/2 part also, abcdabcd, k=7, len=8
            --> ans='d'.--> newLen=len/2==4,now track from where k is from back in the oldLen (==8)--> oldLen%k== 8%7=1->(lets say x=1), now new_K=newLen-x
            --> 4-1= 3.. 3rd idx--> abcd, 3th idx-> ans='d'.
            ---------------------------------------------------------------------
            */
            len=nums[n-1];
            for(int i=n-1;i>=0;i--)
            {
                char ch=s.charAt(i);
                if(ch=='%')
                {
                    k=len-1-k;
                }
                else if(ch=='#')
                {
                    long half=len/2;
                    k%=half;
                    len=half;
                }
                else if(ch=='*')
                {
                    if(i==0) len=0;
                    else
                    {
                        len=nums[i-1]; // just len changes.
                    }
                }
                else
                {
                    if(k==len-1)
                    {
                        return ch; // The baa-> ba case.
                    }
                    len--;
                }
    
            }
        
        return '.';
        
    }
}