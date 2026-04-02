class Solution {
public:
    string triangleType(vector<int>& nums) 
    {
        int A=nums[0];
        int B=nums[1];
        int C=nums[2];
        if(A+B<=C || A+C<=B || B+C<=A) return "none";
        if(A==B && B==C) return "equilateral";
        else if((A==B && B!=C) || (A==C && B!=C) || (B==C && A!=B)) 
            return "isosceles";
        else return "scalene";

        
    }
};