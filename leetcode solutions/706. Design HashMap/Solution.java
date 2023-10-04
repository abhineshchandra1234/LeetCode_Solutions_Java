/**
 * 706. Design HashMap
 * 
 * Intuition
 * 
 * credits sgallivan
 * We will solve this using array
 * Index of the array will represent keys
 * Intially all indices will be assigned -1 means they have no value.
 * During put we will assign value to that particular index
 * In get just fetch the value of the index
 * In remove again assing -1 means no value
 * 
 * Approach
 * Complexity
 * 
 * Time complexity:
 * 
 * O(1), array fetches values in O(1) time through arithmetic operation
 * 
 * Space complexity: O(n)
 * 
 */
class MyHashMap {

    int[] data;

    public MyHashMap() {
        data = new int[1000001];
        Arrays.fill(data, -1);
    }

    public void put(int key, int value) {
        data[key] = value;
    }

    public int get(int key) {
        return data[key];
    }

    public void remove(int key) {
        data[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */