package org.mongine.utils;

import java.util.Objects;

public final class Tuple2<T1, T2> {
    private final T1 _1;
    private final T2 _2;

    public Tuple2(T1 _1, T2 _2) {
        this._1 = _1;
        this._2 = _2;
    }

    public T1 _1() {
        return _1;
    }

    public T2 _2() {
        return _2;
    }

    /**
     * Swaps the elements of this tuple.
     * @return a new Tuple2 where the first element is the second, and the second is the first.
     */
    public Tuple2<T2, T1> swap() {
        return new Tuple2<>(_2, _1);
    }

    @Override
    public String toString() {
        return "(" + _1 + "," + _2 + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple2)) return false;
        Tuple2<?, ?> tuple = (Tuple2<?, ?>) o;
        return Objects.equals(_1, tuple._1) && Objects.equals(_2, tuple._2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_1, _2);
    }
}

