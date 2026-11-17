class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if(map.containsKey(sorted)){
                map.get(sorted).add(s);
            } else {
                map.put(sorted, new ArrayList<>());
                map.get(sorted).add(s);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> cur : map.values()) ans.add(cur);

        return ans;
    }
}
