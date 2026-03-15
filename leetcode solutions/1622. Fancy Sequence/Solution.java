// 1622. Fancy Sequence

/**
 * Intuition
 * If we sequentially do addition and multiplication operations, it will take a
 * lot of time
 * so we will do lazy calculation, ie when index value is fetched, we will just
 * create the final no without any sequential operations
 * we are also creating final no in case of append operation without doing any
 * sequential operations
 * Approach
 * 
 * Complexity
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */

class Fancy {
    long M = (long) 1e9 + 7;

    List<Long> seq = new ArrayList<>();
    long add = 0;
    long mult = 1;

    long power(long a, long b) {
        if (b == 0)
            return 1;

        long half = power(a, b / 2);
        long result = (half * half) % M;

        if (b % 2 == 1) {
            result = (result * a) % M;
        }

        return result;
    }

    public Fancy() {

    }

    public void append(int val) {
        long x = ((val - add) % M + M) * power(mult, M - 2) % M;
        seq.add(x);
    }

    public void addAll(int inc) {
        add = (add + inc) % M;
    }

    public void multAll(int m) {
        mult = (mult * m) % M;
        add = (add * m) % M;
    }

    public int getIndex(int idx) {
        if (idx >= seq.size())
            return -1;

        return (int) ((seq.get(idx) * mult + add) % M);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */