/**
 * 705. Design HashSet
 * 
 * Intuition
 * credits NISHITA97
 * It is a good problem to understand hash function and collision avoiding using
 * bit masking.
 * we will use 32 bits to represent nos.
 * we will divide nos into 1e6/32 + 1 groups each of size 32. + 1 is for 0.
 * we will find index by key/32 and then use bit masking to enable the no in the
 * group.
 * like 32
 * index - 32/32 -> 1
 * mask - 32%32 -> 0 -> 1<<0
 * res at index 1 -> 00..000
 * like 33
 * index - 33/32 -> 1
 * mask - 33%32 -> 1 -> 1<<1
 * res at index 1 -> 00..31 times..1
 * we are using hash function to find index
 * then to avoid collision we are using bit masking
 * like - 32, 33 belongs to same group.
 * 
 * Complexity
 * Time complexity: O(1)
 * Space complexity: O(n)
 */
class MyHashSet {
    int num[];

    public MyHashSet() {
        num = new int[(int) (1e6 / 32) + 1];
    }

    // add masking of key at the index
    public void add(int key) {
        num[getIdx(key)] |= getMask(key);
    }

    // unset the bit if a key is not present.
    public void remove(int key) {
        num[getIdx(key)] &= (~getMask(key));
    }

    // check if bit corresponding to the key is set or not
    public boolean contains(int key) {
        return (num[getIdx(key)] & getMask(key)) != 0;
    }

    // idx of num[] to which this key belongs
    // for key = 37, it will give 1
    private int getIdx(int key) {
        return key / 32;
    }

    // get mask representing the bit inside num[idx] that corresponds to given key.
    // for key = 37, it will give 0000000000000000000000000010000
    private int getMask(int key) {
        key %= 32;
        return (1 << key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */