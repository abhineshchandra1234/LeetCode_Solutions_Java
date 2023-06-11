/**
 * 1146. Snapshot Array
 * 
 * Intuition
 * credits lee215
 * It is clear that we need to use hashmap to store snap_id, val pair.
 * But we need to use HashMap for each of the index. Each index will have
 * several version of the values.
 * 
 * Approach
 * TreeMap<Integer, Integer>[] A=new TreeMap[length];
 * It will create an empty tree map at each index with index just as ref. There
 * will be no value in it.
 * 0 -> TreeMap()
 * 1 -> TreeMap()
 * Here 0 & 1 doesnt exist.
 * floorEntry will return value less than or equal to snap_id or null if there
 * are no values. so we added (0,0) at each index.
 * 
 * Complexity
 * Time complexity: O(logS)
 * Space complexity: O(S)
 * Where S is the no of times set called.
 * SnapshotArray(int length): O(n)
 * set(int index, int val): O(logS)
 * snap(): O(1)
 * get(int index, int snap_id): O(logS)
 */
class SnapshotArray {

    TreeMap<Integer, Integer>[] A;
    int snap_id = 0;

    public SnapshotArray(int length) {
        A = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            A[i] = new TreeMap();
            A[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        A[index].put(snap_id, val);
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        return A[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */