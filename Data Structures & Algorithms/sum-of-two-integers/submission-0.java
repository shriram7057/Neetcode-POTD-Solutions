class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1; // carry
            a = a ^ b;                // sum without carry
            b = carry;               // add carry next
        }
        return a;
    }
}