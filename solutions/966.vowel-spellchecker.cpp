class Solution {
public:
    string lowercase(string str) {
        for (int i = 0; i < str.length(); i++) {
            str[i] = tolower(str[i]);
        }
        return str;
    }
    
    string devowel(string str) {
        str = lowercase(str);
        for (auto& c: str) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o') {
                c = '*';
            }
        }
        return str;
    }
    
    vector<string> spellchecker(vector<string>& wordlist, vector<string>& queries) {
        unordered_set<string> words = unordered_set(wordlist.begin(), wordlist.end());
        // use a separate set because lowercased keys will think they're in the wordlist when mapped
        // like Yellow -> yellow as a key but on input "yellow" we do not have a guarantee that "yellow"
        // is in the wordlist
        unordered_map<string, string> table;
        
        for (auto& word: wordlist) {
            table.insert({lowercase(word), word});
            table.insert({devowel(word), word});
        }
        
        for (auto& query: queries) {
            if (words.count(query)) continue;
            string v = devowel(query);
            string l = lowercase(query);
            if (table.count(l)) {
                query = table[l];
            } else if(table.count(v)) {
                query = table[v];
            } else {
                query = "";
            }
        }
        
        return queries;
    }
};