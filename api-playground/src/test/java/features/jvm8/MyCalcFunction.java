package features.jvm8;

@FunctionalInterface
public interface MyCalcFunction<V,O> {
    O calculate(V v);
}
