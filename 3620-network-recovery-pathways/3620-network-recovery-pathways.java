class Solution {
    HashMap<Long,HashMap<Long,ArrayList<Long>>> graph;
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int ans = -1,l = 0,h = 1000_000_000;
        int n = online.length;
        graph = new HashMap<>();
        for(int edge[] : edges){
            HashMap<Long,ArrayList<Long>> nodes = graph.getOrDefault((long)edge[0],new HashMap<>());
            ArrayList<Long> duplicates = nodes.getOrDefault((long)edge[1],new ArrayList<>());
            duplicates.add((long)edge[2]);
            nodes.put((long)edge[1],duplicates);
            graph.put((long)edge[0],nodes);
        }
        while(l <= h){
            int mid = (h - l) / 2 + l;
            if(check(mid,k,n,online)){
                ans = mid;
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        return ans;
    }
    private boolean check(int mid,long k,int n,boolean[] online){
        boolean[] visited = new boolean[n];
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.offer(new long[]{0,0});
        while(!pq.isEmpty()){ 
            long[]node = pq.poll();
            if(visited[(int)node[0]]) continue;
            visited[(int)node[0]] = true;
            if(node[0] == n - 1) return true;
            HashMap<Long,ArrayList<Long>> edgesList = graph.get(node[0]); 
            if(edgesList == null) continue;
            for(long key : edgesList.keySet()){
                for(long wt : edgesList.get(key))
                if(wt >= mid && online[(int)key] && !visited[(int)key]){
                    if(wt + node[1] <= k)
                        pq.offer(new long[]{key,wt + node[1]});
                }
            }
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna