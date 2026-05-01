class Solution {
    public String foreignDictionary(String[] words) {
      int n = words.length;
      Map<Character, Set<Character>> map = new HashMap<>();
      Map<Character, Integer> indegree = new HashMap<>();

      for(String word : words){
        for(char ch : word.toCharArray()){
            map.putIfAbsent(ch, new HashSet<>());
            indegree.putIfAbsent(ch, 0);
        }
      }

      for(int i = 0; i < n - 1; i++){
        String w1 = words[i], w2 = words[i + 1];
        int minLen = Math.min(w1.length(), w2.length());
        if(w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) return "";

             for(int j = 0; j < minLen; j++){
             char a = w1.charAt(j), b = w2.charAt(j);

            if(a != b){ // a --> b
                if(!map.get(a).contains(b)){
                    map.get(a).add(b);
                    indegree.put(b, indegree.getOrDefault(b, 0) + 1);
                } 
                break;
            }
        }
        }
        Queue<Character> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for(char ch : indegree.keySet()){
            if(indegree.get(ch) == 0) queue.add(ch);
        }
        while(!queue.isEmpty()){
            char cur = queue.poll();
            ans.append(cur);
            for(char nei : map.get(cur)){
                indegree.put(nei, indegree.getOrDefault(nei, 0) - 1);
                if(indegree.get(nei) == 0) queue.add(nei);
            }
        }
        if(ans.length() != indegree.size()) return "";
        return ans.toString();
    }
}
