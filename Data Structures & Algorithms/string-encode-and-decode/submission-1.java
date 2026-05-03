class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }
    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int idx = 0;

        while(idx < str.length()){
            int next = idx;

            while(str.charAt(next) != '#'){
                next++;
            }
            int len = Integer.parseInt(str.substring(idx, next));
            idx = next + 1;
            next = idx + len;

            String curWord = str.substring(idx, next);
            ans.add(curWord);
            idx = next;
        }

        return ans;
    }
}
