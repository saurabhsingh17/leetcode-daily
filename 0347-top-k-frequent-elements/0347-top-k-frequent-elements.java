class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hMap = new HashMap<>();
        for (int i :nums){
            hMap.put(i,hMap.getOrDefault(i,0)+1);
        }
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> hMap.get(b) - hMap.get(a));
        for(int key : hMap.keySet()){ heap.add(key); }
        
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = (heap.poll());
        }
        return ans;
    }
}