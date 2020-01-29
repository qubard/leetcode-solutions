class Solution {
public:
    string minRemoveToMakeValid(string s) {
        std::stack<int> stk;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s[i];
            if (c == '(') {
                stk.push(i);
            } else if (c == ')') {
                // if the top of the stk is (, pop
                // else push
                if (stk.size() > 0 && s[stk.top()] == '(') {
                    stk.pop();
                } else {
                    stk.push(i);
                }
            }
        }
        
        std::set<int> erase;
        while (stk.size() > 0) {
            erase.insert(stk.top());
            stk.pop();
        }
        
        std::stringstream out;
        for (int i = 0; i < s.length(); i++) {
            if (erase.find(i) == erase.end()) {
                out << s[i];
            }
        }
        
        return out.str();
        
        // at the end the stk contains all elements we need to remove
    }
};

/*
// Better solution which relies on the reverse case being true
// When see ) and the stack is empty we know it does not belong in the string
// So the reverse is true and if we flip the meaning of (, ) and go from right to left 
// If we see ( we remove it until the stack is empty
// The stack represents the balance of the string
// And so any ( contained in it are in excess of )
// Finally we reverse the string since we are using stringstream
// You technically don't need to use a stack or set really
class Solution {
public:
    string minRemoveToMakeValid(string s) {
        std::stack<int> stk;
        
        std::set<int> erase;
        for (int i = 0; i < s.length(); i++) {
            char c = s[i];
            if (c == '(') {
                stk.push(i);
            } else if (c == ')') {
                // if the top of the stk is (, pop
                // else push
                // if the stack is empty these have to be removed
                // and so if we do this the other way around we'll have a balanced string
                
                if (stk.size() == 0) {
                    erase.insert(i);
                } else {
                    stk.pop();
                }
            }
        }
        
        std::stringstream out;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s[i] == '(' && stk.size() > 0) {
                stk.pop();
            } else if (erase.find(i) == erase.end()) {
                out << s[i];
            }
        }
        
        string out_str = out.str();
        std::reverse(out_str.begin(), out_str.end());
        return out_str;
        
        // at the end the stk contains all elements we need to remove
    }
};
*/

/*
// Even better solution
class Solution {
public:
    string minRemoveToMakeValid(string s) {
        int balance = 0;
        int open = 0;
                
        std::stringstream out;
        for (int i = 0; i < s.length(); i++) {
            char c = s[i];
            if (c == '(') {
                balance++;
                open++;
            } else if (c == ')') {
                // if the top of the stk is (, pop
                // else push
                if (balance == 0) continue;
                balance--;
            }
            // we output to the stringstream because we want to take care of
            // case 1: where we have )(, got to remove ) first
            out << s[i];
        }

        int rem = open - balance;
        
        auto out_str = out.str();
        std::stringstream out2; // need a second string and ss because we cant do arbitrary reads
        for (int i = 0; i < out_str.length(); i++) {
            char c = out_str[i];
            // dealing with case 2: removing rightmost (
            if (c == '(') {
                rem--;
                if (rem < 0)
                    continue;
            }

            out2 << c;
        }
        
        return out2.str();
        
    }
};
*/