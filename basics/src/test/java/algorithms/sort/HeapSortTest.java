package algorithms.sort;

import algorithms.util.ValueGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeapSortTest {

    @Test
    void whenValueGenerater_ThenReturnValues() {
        int size = 10, bound = 100;
        int [] arr = ValueGenerator.generateRandomIntValues(10, 100);
        Assertions.assertTrue(arr != null && arr.length>0);
        ValueGenerator.displayItems(arr);
    }

    @Test
    void whenRandomIntegersLessThan100_SortAscending () {
        int [] arr = ValueGenerator.generateRandomIntValues(10, 100);
        ValueGenerator.displayItems(arr);
    }
}
