package src.com.oma.functionalinterfaces;

@FunctionalInterface
public interface OmaConsumer<T> {
    void accept(T t);
}
