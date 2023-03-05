//1345. Jump Game IV
/*
 * approach - 
 * we will use bfs to solve this problem
 * first we will create a map of no and list of its indices as value
 * we will use a boolean array to mark visited indexes
 * bfs level will denote steps
 * we will add index to queue add perform following checks
 * if the index is last index then we will return the steps.
 * a index is valid if it is in bounds and not visited
 * skip index if invalid
 * check validity of before and after index and add to queue if valid
 * check validity of curr no idices from map and add to queue if valid
 * 
 * Time - O(n*n)
 * Space - O(n)
 */
class Solution {
    public int minJumps(int[] arr) {
        
        Map<Integer,List<Integer>> map = new HashMap();
        for(int i=0; i<arr.length; i++) {
            List<Integer> l = map.getOrDefault(arr[i],new ArrayList());
            l.add(i);
            map.put(arr[i],l);
        }

        boolean[] visited = new boolean[arr.length];
        int level = 0;
        Queue<Integer> q = new LinkedList();
        q.add(0);

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                int head = q.poll();

                if(head==arr.length-1)
                    return level;
                
                if(head<0 || head>=arr.length || visited[head])
                    continue;
                
                if(head-1>=0 && !visited[head])
                    q.add(head-1);
                
                if(head+1<arr.length && !visited[head])
                    q.add(head+1);
                
                if(map.containsKey(arr[head])) {
                    for(int index: map.get(arr[head])) {
                        if(index>=0 && index<arr.length && !visited[head])
                            q.add(index);
                    }
                    map.remove(arr[head]);
                }
                visited[head] = true;
            }
            level++;
        }

        return -1;
    }
}