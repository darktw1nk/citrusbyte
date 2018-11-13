package com.citrusbyte;

public interface IntegerArrayFlattener {

    /**
     * Flatten given array of integers
     * Null items also allowed
     * For null returns empty array
     * This method expect argument to be previously filtered
     * and all items to be integers or integer/object arrays
     * If @param contains other types it will take at least O(n) to throw exception.
     * @param array array to flatten
     * @return flattened integer array
     * @throws ArrayStoreException if @param contains other types than
     * integer or integer/object arrays
     */
    Integer[] flattenArrayOfIntegers(Object[] array);

}
