class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if (digits.empty()) return {};

        vector<string> mapping = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        vector<string> result;
        backtrack(0, digits, "", mapping, result);
        return result;
    }

    void backtrack(int index, string& digits, string curr,
                   vector<string>& mapping, vector<string>& result) {
        if (index == digits.size()) {
            result.push_back(curr);
            return;
        }

        string letters = mapping[digits[index] - '0'];
        for (char c : letters) {
            backtrack(index + 1, digits, curr + c, mapping, result);
        }
    }
};