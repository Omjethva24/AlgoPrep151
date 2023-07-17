//Letter Combinations of a Phone Number

class Solution {
    public List<String> letterCombinations(String digits) {
        String[][] letters = {{},
                              {},
                              {"a","b","c"},
                              {"d","e","f"},
                              {"g","h","i"},
                              {"j","k","l"},
                              {"m","n","o"},
                              {"p","q","r","s"},
                              {"t","u","v"},
                              {"w","x","y","z"}};
    List<String> ans = new ArrayList<String>();
    if(digits.length()==0){
        return ans;
    }
    backtrack(0, digits, letters, new StringBuilder(""), ans);
    return ans;
    }

    public void backtrack(int index, String digits, String[][] letters, StringBuilder sb, List<String> ans){
        //base case
        if(index==digits.length()){
            ans.add(sb.toString());
            return;
        }
        int currDigit =digits.charAt(index)-'0';
        for(int i=0; i<letters[currDigit].length; i++){
            sb.append(letters[currDigit][i]);
            backtrack(index+1, digits, letters, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}