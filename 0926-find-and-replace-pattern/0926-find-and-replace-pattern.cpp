class Solution {
public:
    // vector<string> findAndReplacePattern(vector<string>& words, string pattern) {
        
    // }
    void creatmapping(string &str){
        // find mapping
        char start = 'a';
        char mapping[300] = {0};
        for(auto ch:str){
            if(mapping[ch] == 0){
                mapping[ch] = start;
                start++;
            }
        }

        //  update the string
        for(int i = 0;i<str.length();i++){
            char ch = str[i];
            str[i] = mapping[ch];
        }
    }
    vector<string>findAndReplacePattern(vector<string>& words,string pattern){
        vector<string> ans;
        // firstly normalize the pattern
        creatmapping(pattern);

        for(string s:words){
            string tempstring = s;
            creatmapping(tempstring);
            if(tempstring == pattern){
                ans.push_back(s);
            }
        }
    return ans;
    }

};