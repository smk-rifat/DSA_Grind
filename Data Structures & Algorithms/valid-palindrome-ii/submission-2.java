class Solution {
    public boolean validPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return (solve(s, -1, left + 1, right) || solve(s, -1, left, right-1));
            }
            left++;
            right--;
        }

        return true;
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