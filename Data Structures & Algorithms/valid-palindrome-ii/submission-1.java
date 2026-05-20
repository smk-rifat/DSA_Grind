class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        if(solve(s, - 1, 0, n - 1)) return true;

        for(int i = 0; i < n; i++){
            if(solve(s, i, 0, n - 1)) return true;
        }

        return false;
    }
    boolean solve(String s, int sk, int left, int right){
        while(left <= right){
            if(sk != -1 && left == sk){
                left++;
            } else if(sk != -1 && right == sk){
                right--;
            } else if(s.charAt(left) != s.charAt(right)){
                return false;
            } else {
                left++;
                right--;
            }
        }

        return true;
    }
}