class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int m = word1.length(), n = word2.length(), i = 0, j = 0;
        boolean isOne = true;
        while(i < m && j < n){
            if(isOne){
                sb.append(word1.charAt(i));
                i++;
                isOne = false;
            } else {
                sb.append(word2.charAt(j));
                j++;
                isOne = true;
            }

        }

        while(i < m){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j < n){
            sb.append(word2.charAt(j));
            j++;
        }

        return sb.toString();
    }
}