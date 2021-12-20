package epi;

public class PG44_count_1_bit {

    public static short countBits (int x) {
        short numBits = 0;
        while (x != 0) {
            numBits += (x & 1);
            x >>>= 1;
        }
        return numBits;
    }
}
