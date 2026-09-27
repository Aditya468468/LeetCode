class Solution {
public:
    string reverseParentheses(string s) {
        stack<char> st;

        for (int i = 0; i < s.length(); i++) {
            char ch = s[i];

            if (ch == ')') {
                string str = "";
                while (!st.empty() && st.top() != '(') {
                    str += st.top();
                    st.pop();
                }
                // st.top() == '(' so we pop that too
                st.pop();
                for (int j = 0; j < str.length(); j++) {
                    st.push(str[j]);
                }
            } else {
                st.push(ch);
            }
        }

        string ans = "";

        while (!st.empty()) {
            ans += st.top();
            st.pop();
        }

        reverse(ans.begin(), ans.end());
        return ans;
    }
};