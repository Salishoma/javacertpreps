package com.oma.functionalinterfaces;

public interface OmaFunction<T, R> {
    R apply(T t);
}
