class Solution {
public:
    int i = 0;
    
    /*
    root -> tern | digit | T[end] | F[end] | T: | F:
    tern -> cond root ':' root
    cond -> tern | T? | F?

    condition will never be a digit
    
    A really good way of solving this is to split the string
    using a "stack" approach where we know the first part of the ternary expression
    based on incrementing a counter when we see ? and decrementing when we see ':'
    
    It turns out that the split ends with p1/p2 being separated
    */
    string tern(string& expression) {
        string cond_ = cond(expression);
        string r1 = root(expression);
        consumeColon(expression);
        string r2 = root(expression);
        
        if (cond_ == "T") {
            return r1;
        }
        
        return r2;
    }
    
    string cond(string& expression) {
        if (i + 1 < expression.size() && (expression[i] == 'T' || expression[i] == 'F') && expression[i + 1] == '?') {
            string token = expression.substr(i, 1);
            i++; // consume T/F
            i++; // consume ?
            return token;
        }
        
        return tern(expression);
    }
    
    void consumeColon(string& expression) {
        if (i < expression.size() && expression[i] == ':') {
            i++;
        }
    }
    
    string root(string& expression) {
        if ((expression[i] == 'T' || expression[i] == 'F') && (i == expression.size() - 1 || expression[i+1] == ':')) {
            string token = expression.substr(i, 1);
            i++; // consume T/F
            consumeColon(expression);
            return token;
        }
        
        if (expression[i] >= '0' && expression[i] <= '9') {
            stringstream ss;
            while (expression[i] >= '0' && expression[i] <= '9') {
                ss << expression[i];
                i++;
            }
            // consume ':'
            consumeColon(expression);
            return ss.str();
        }
        
        return tern(expression);
    }
    
    string parseTernary(string expression) {
        return root(expression);
    }
};