class Solution {
public:
    vector<string> findRepeatedDnaSequences(string s) 
    {
        unordered_set<string> set;
        unordered_set<string> seen;
        int n=s.size();
        int left=0;
        for(int right=0;right<s.length();right++)
        {
    
            while(right-left+1>10)
            {
                left++;
            }
            if(right-left+1==10)
            {
                string str=s.substr(left,right-left+1);
                if(seen.contains(str))
                {
                    set.insert(str);
                }
                else 
                {
                    seen.insert(str);
                }
            }

        }

        return vector <string>(set.begin(),set.end());
        
    }
};
