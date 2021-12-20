package epi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;










public class Test_PG44_count_1_bit {

    @Test
    public void testFirstMethod () {
        Assertions.assertEquals(4, 8>>1);
        Assertions.assertEquals(2, 4>>1);
        Assertions.assertEquals(1, 2>>1);

        Assertions.assertEquals(-8, -16>>1);
        Assertions.assertEquals(16, 8<<1);
        Assertions.assertEquals(-6, ~5); // the sign of the least significant bit (Left most bit) also changes
        Assertions.assertEquals(7, 5^2);

        Assertions.assertEquals(Character.DIRECTIONALITY_LEFT_TO_RIGHT, Character.getDirectionality('a'));

        Assertions.assertEquals(4, 6&4);
        Assertions.assertEquals(3, 1|2);

        Assertions.assertEquals(2, PG44_count_1_bit.countBits(10));
        Assertions.assertEquals(2, PG44_count_1_bit.countBits(12));
    }

}
