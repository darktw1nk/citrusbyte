package com.citrusbyte;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class ArrayFlattener implements IntegerArrayFlattener {

    @Override
    public Integer[] flattenArrayOfIntegers(Object[] array) {
        return flattenArray(array).toArray(Integer[]::new);
    }

    private Stream<Object> flattenArray(Object[] array) {
        return Optional.ofNullable(array).map(Arrays::stream).orElseGet(Stream::empty)
                .flatMap(o -> o instanceof Object[] ? flattenArray((Object[]) o) : Stream.of(o));
    }

}
