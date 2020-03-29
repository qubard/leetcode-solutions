class Solution {
public:
    // Evaluates any expression
    int i = 0;
    
    void consume_whitespace(string& expression) {
        while (i < expression.size() && expression[i] == ' ') {
            i++;
        }
    }
    
    vector<string> ops = {"let", "mult", "add"};
    
    string op(string& expression) {
        for (string& op: ops) {
            if (expression.substr(i, op.size()) == op) {
                i += op.size();
                return op;
            }
        }
        // should never happen
        return "";
    }
    
    bool on_variable(string& expression) {
        return expression[i] >= 'a' && expression[i] <= 'z';
    }
    
    bool on_digit(string& expression) {
        return expression[i] == '-' || (expression[i] >= '0' && expression[i] <= '9');
    }
    
    string variable(string& expression) {
        stringstream ss;
        while (on_variable(expression) || on_digit(expression)) {
            ss << expression[i];
            i++;
        }
        return ss.str();
    }
    
    
    int expr(string& expression, unordered_map<string, int> ctx) {
        consume_whitespace(expression);
        if (on_variable(expression)) { // atomic variable
            int val = ctx[variable(expression)];
            return val;
        }
        
        if (on_digit(expression)) { // atomic digit
            stringstream ss;
            while (on_digit(expression)) {
                ss << expression[i];
                i++;
            }
            consume_whitespace(expression);
            return stoi(ss.str());
        }
        
        if (expression[i] == '(') {
            i++;
            string op_ = op(expression);
            if (op_ == "let") {
                for (;;) {
                    consume_whitespace(expression);
                    string var = variable(expression);
                    if (expression[i] == ' ') {
                        int val = expr(expression, ctx);
                        //cout << "mapped " << var << "->" << val << "\n";
                        ctx[var] = val;
                    } else {
                        i -= var.size();
                        int eval = expr(expression, ctx); // evaluate the expression at the end of the let statement
                        i++; // consume )
                        return eval;
                    }
                }
            } else if (op_ == "mult" || op_ == "add") {
                int e1 = expr(expression, ctx);
                int e2 = expr(expression, ctx);
                i++; // consume )
                consume_whitespace(expression);
                return op_ == "mult" ? e1 * e2 : e1 + e2;
            }
        }
        
        return 0;
    }
    
    int evaluate(string expression) {
        return expr(expression, unordered_map<string, int>());
    }
};