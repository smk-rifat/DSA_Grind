class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;

        while(left <= right && right < n){
            char ch = s.charAt(right);
            if(map.containsKey(ch) && map.get(ch) >= left ) left = 1 + map.get(ch);
            ans = Math.max(ans, right - left + 1);
            map.put(ch, right);
            right++;

        }

        return ans;
    }
}
