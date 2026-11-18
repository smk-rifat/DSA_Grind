class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        String s = "";

        for(String str : strs){
            if(min > str.length()){
                min = str.length();
                s = str;
            }
        }

        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }

        for(List<String> cur : map.values()){
            ans.add(cur);
        }

        return ans;
    }
}
