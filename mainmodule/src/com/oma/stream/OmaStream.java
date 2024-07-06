package com.oma.stream;

import com.oma.functionalinterfaces.OmaConsumer;
import com.oma.functionalinterfaces.OmaFunction;

import java.util.function.Function;

public class OmaStream<T> {
    private T t;

    public OmaStream(T t) {
        this.t = t;
    }

    public void forEach(OmaConsumer<T> consumer) {
        consumer.accept(t);
    }

    public <R> OmaStream<R> map(OmaFunction<T, R> function) {
        return this.andThen(function.apply(t));
    }

    private <R> OmaStream<R> andThen(R data) {
        return new OmaStream<>(data);
    }
}
