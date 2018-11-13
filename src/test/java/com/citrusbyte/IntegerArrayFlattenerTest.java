package com.citrusbyte;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.arrayWithSize;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class IntegerArrayFlattenerTest {

    private IntegerArrayFlattener arrayFlattener;
    private Integer[] expectedResult;

    @Before
    public void setUp(){
        arrayFlattener = new ArrayFlattener();
        expectedResult = new Integer[]{1,2,3,4,5,6};
    }

    @Test
    public void nullTest(){
        Integer[] result = arrayFlattener.flattenArrayOfIntegers(null);
        assertNotNull(result);
        assertThat(result,arrayWithSize(0));
    }

    @Test
    public void emptyArrayTest(){
        Integer[] result = arrayFlattener.flattenArrayOfIntegers(new Object[]{});
        assertNotNull(result);
        assertThat(result,arrayWithSize(0));
    }

    @Test
    public void simpleArrayTest(){
        Object[] array = new Object[]{1,2,3,4,5,6};
        Integer[] result = arrayFlattener.flattenArrayOfIntegers(array);

        assertNotNull(result);
        assertArrayEquals(expectedResult,result);
    }

    @Test
    public void nestedArrayTest(){
        Object[] array = new Object[]{1,new Object[]{2,3},4,5,6};
        Integer[] result = arrayFlattener.flattenArrayOfIntegers(array);

        assertNotNull(result);
        assertArrayEquals(expectedResult,result);
    }

    @Test
    public void nestedIntegerArrayTest(){
        Object[] array = new Object[]{1,new Integer[]{2,3},4,5,6};
        Integer[] result = arrayFlattener.flattenArrayOfIntegers(array);

        assertNotNull(result);
        assertArrayEquals(expectedResult,result);
    }

    @Test
    public void multiLevelNestedArrayTest(){
        Object[] array = new Object[]{1,new Object[]{2,new Object[]{3,4,new Object[]{5}}},6};
        Integer[] result = arrayFlattener.flattenArrayOfIntegers(array);

        assertNotNull(result);
        assertArrayEquals(expectedResult,result);
    }

    @Test(expected = ArrayStoreException.class)
    public void containsOtherTypeTest(){
        Object[] array = new Object[]{1,2,new Object(),4,5,6};
        Integer[] result = arrayFlattener.flattenArrayOfIntegers(array);

        assertNotNull(result);
        assertArrayEquals(expectedResult,result);
    }
}
