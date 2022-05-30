package features.jvm8;

@FunctionalInterface
public interface MyVoidFunction {

    void test(int i);

    default void checkIGtJ(int i, int j) {
        if (i<j) {
            throw new IllegalArgumentException("Invalid I and J values");
        }
    }

    static void test1(int k) {

    }
}
