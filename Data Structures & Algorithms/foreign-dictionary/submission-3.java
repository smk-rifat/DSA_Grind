class Solution {
    public String foreignDictionary(String[] words) {
      Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indg = new HashMap<>();

        for(String word : words){
            for(char ch : word.toCharArray()){
                if(!adj.containsKey(ch)){
                    adj.put(ch, new ArrayList<>());
                }
                if(!indg.containsKey(ch)){
                    indg.put(ch, 0);
                }
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if(w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) return "";

            for(int j = 0; j < minLen; j++){
                char a = w1.charAt(j), b = w2.charAt(j);
                if(a != b){
                    adj.get(a).add(b);
                    indg.put(b, indg.getOrDefault(b, 0) + 1);
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();

        for(char key : indg.keySet()){
            if(indg.get(key) == 0) queue.add(key);
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()){
            char cur = queue.poll();
            sb.append(cur);

            for(char nei : adj.get(cur)){
                indg.put(nei, indg.getOrDefault(nei, 0) - 1);
                if(indg.get(nei) == 0) queue.add(nei);
            }
        }
        if(sb.length() != indg.size()) return "";

        return sb.toString();
    }
}
