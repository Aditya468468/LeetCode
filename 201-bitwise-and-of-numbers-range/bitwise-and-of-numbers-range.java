class Solution {
    public int rangeBitwiseAnd(int left, int right) 
    {

        if(left==0) return 0; // 0&(any)=0
        int shiftCount = 0;
        while(left!=right)
        {
            left=left>>1;
            right=right>>1;
            shiftCount++;
        }
        left=left<<shiftCount;  
        //Because you shifted the bits to the right to find that common prefix, you effectively "chopped off" the trailing bits. If you don't shift them back, you're left with just the prefix value shifted all the way to the right.
        return left;

        
    }
}