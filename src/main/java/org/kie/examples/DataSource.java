package org.kie.examples;

import java.util.function.Consumer;

public interface DataSource<T> {

    void remove(T s);

    void modify(T u, Consumer<T> c);
}
