class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s = "";
        int min = Integer.MAX_VALUE;

        for(String str : strs){
            if(min > str.length()){
                min = str.length();
                s = str;
            }
        }
        int max = min;

        for(String str : strs){
            for(int i = 0; i < min; i++){
                if(str.charAt(i) != s.charAt(i)){
                    max = Math.min(max, i);
                    break;
                }
            }
        }

        return s.substring(0, max);
    }
}