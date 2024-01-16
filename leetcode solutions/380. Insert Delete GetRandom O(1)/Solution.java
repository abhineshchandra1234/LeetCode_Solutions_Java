/**
 * 380. Insert Delete GetRandom O(1)
 * 
 * Intuition
 * 
 * If it was just insert and delete we would have solved it using hashmap in
 * O(1) time
 * Here we have random method too, we need list to implement it
 * random method will take list size as parameter and return random index in
 * O(1) time arithmatic operation
 * we can insert element in list in O(1) time
 * In order to remove element from the list in O(1) time we need to know index
 * of the element beforehand using hashmap
 * Then we will simply swap it with last element in the list this will remove
 * the given val from the list, update index of last element in map, delete
 * duplicate last element from list and remove the given val from the map.
 * Note - It takes O(1) time to search key in map as it uses hashing
 * 
 * Approach
 * Complexity
 * 
 * Time complexity: O(1), each func should run in O(1) time
 * 
 * Space complexity: O(n), we are using set and list to implement
 * RandomizedSet
 * 
 */
class RandomizedSet {

    private ArrayList<Integer> list;
    private Map<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList();
        map = new HashMap();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;

        // fetch index
        int index = map.get(val);
        // swap with last element
        list.set(index, list.get(list.size() - 1));
        // update new element in map
        map.put(list.get(index), index);
        // remove duplicate last element
        list.remove(list.size() - 1);
        // remove the val
        map.remove(val);

        return true;
    }

    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
