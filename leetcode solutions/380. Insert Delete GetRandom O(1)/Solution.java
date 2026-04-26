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

// Java
class RandomizedSet {
    private List<Integer> a;
    private Map<Integer, Integer> aIdx;

    public RandomizedSet() {
        this.a = new ArrayList();
        this.aIdx = new HashMap();
    }

    public boolean insert(int val) {
        if (aIdx.containsKey(val))
            return false;

        aIdx.put(val, a.size());
        a.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!aIdx.containsKey(val))
            return false;

        // fetch index of curr no
        int idx = aIdx.get(val);

        // swap of last and curr, delete curr
        // map operation
        // assign curr idx to last no
        // remove val
        aIdx.put(a.get(a.size() - 1), idx);
        aIdx.remove(val);

        // list operation
        // assign last no to curr index
        // remove last no
        a.set(idx, a.get(a.size() - 1));
        a.remove(a.size() - 1);

        return true;
    }

    public int getRandom() {
        int idx = (int) (Math.random() * a.size());
        return a.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

// kotlin
class RandomizedSet()
{

    private val list = ArrayList<Int>()
    private val map = HashMap<Int,Int>()

    fun search(`val`: Int): Boolean {
        return map.containsKey(`val`)
    }

    fun insert(`val`: Int): Boolean {
        if(search(`val`)) {
            return false
        }
        list.add(`val`)
        map[`val`] = list.size - 1
        return true
    }

    fun remove(`val`: Int): Boolean {
        val index = map[`val`] ?: return false

        val lastEle = list.last()
        list[index] = lastEle
        map[lastEle] = index

        list.removeAt(list.size-1)
        map.remove(`val`)

        return true
    }

    fun getRandom(): Int {
        return list[Random.nextInt(list.size)]
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */
