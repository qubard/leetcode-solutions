/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *   public:
 *     // Constructor initializes an empty nested list.
 *     NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     NestedInteger(int value);
 *
 *     // Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     bool isInteger() const;
 *
 *     // Return the single integer that this NestedInteger holds, if it holds a single integer
 *     // The result is undefined if this NestedInteger holds a nested list
 *     int getInteger() const;
 *
 *     // Set this NestedInteger to hold a single integer.
 *     void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     void add(const NestedInteger &ni);
 *
 *     // Return the nested list that this NestedInteger holds, if it holds a nested list
 *     // The result is undefined if this NestedInteger holds a single integer
 *     const vector<NestedInteger> &getList() const;
 * };
 */
class Solution {
public:
    int i = 0;
    string dig = "";
    stack<NestedInteger> stk;
    NestedInteger deserialize(string s) {
        if (s.size() == 0) return NULL;
        if (s[0] != '[') {
            return NestedInteger(stoi(s));
        }
        
        for (char c: s) {
            if (c == '[') {
                stk.push(NestedInteger());
            } else if (c == ',') {
                if (!stk.empty() && dig.size() > 0) {
                    NestedInteger ni(stoi(dig));
                    stk.top().add(ni);
                    dig.clear();
                }
            } else if (c == ']') {
                if (!stk.empty() && dig.size() > 0) {
                    NestedInteger ni(stoi(dig));
                    stk.top().add(ni);
                    dig.clear();
                }
                
                NestedInteger prev = stk.top();
                stk.pop();
                
                if (stk.size() > 0) {
                    stk.top().add(prev);
                } else {
                    return prev;
                }
            } else {
                // digit
                dig += c;
            }
        }
        return NULL;
    }
};