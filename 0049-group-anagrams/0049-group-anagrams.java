class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> myMaps = new HashMap<>();
        for (String item:strs){
            String hash = generateUniqueKey(item);
            if (!myMaps.containsKey(hash)) {
            myMaps.put(hash, new ArrayList<String>());
        }
        myMaps.get(hash).add(item);
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : myMaps.entrySet()) {
            ans.add(entry.getValue());
        }
        //System.out.println(ans);
        return ans;
    }
    static String generateUniqueKey(String input) {
        char[] in = input.toCharArray();
        Arrays.sort(in);
        return new String(in);
    }
}