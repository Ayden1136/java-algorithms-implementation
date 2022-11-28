package com.jwetherell.algorithms.data_structures.test;

import org.junit.Assert;
import org.junit.Test;

import com.jwetherell.algorithms.data_structures.Matrix;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void testMatrix() {
        Matrix<Integer> matrix1 = new Matrix<Integer>(4, 3);
        matrix1.set(0, 0, 14);
        matrix1.set(0, 1, 9);
        matrix1.set(0, 2, 3);
        matrix1.set(1, 0, 2);
        matrix1.set(1, 1, 11);
        matrix1.set(1, 2, 15);
        matrix1.set(2, 0, 0);
        matrix1.set(2, 1, 12);
        matrix1.set(2, 2, 17);
        matrix1.set(3, 0, 5);
        matrix1.set(3, 1, 2);
        matrix1.set(3, 2, 3);

        Matrix<Integer> matrix2 = new Matrix<Integer>(3, 2);
        matrix2.set(0, 0, 12);
        matrix2.set(0, 1, 25);
        matrix2.set(1, 0, 9);
        matrix2.set(1, 1, 10);
        matrix2.set(2, 0, 8);
        matrix2.set(2, 1, 5);

        // Result of multiplication
        Integer[][] array1 = new Integer[][]{{273,455},
                                             {243,235},
                                             {244,205},
                                             {102,160}};
        Matrix<Integer> result1 = new Matrix<Integer>(4,2,array1);

        Matrix<Integer> matrix3 = matrix1.multiply(matrix2);
        assertEquals("Matrix multiplication error. matrix3=" + matrix3 + " result1" + result1, matrix3, result1);

        int rows = 2;
        int cols = 2;
        int counter = 0;
        Matrix<Integer> matrix4 = new Matrix<Integer>(rows, cols);
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                matrix4.set(r, c, counter++);

        // Result of subtraction
        Integer[][] array2 = new Integer[][]{{0,0},
                                             {0,0}};
        Matrix<Integer> result2 = new Matrix<Integer>(2,2,array2);

        Matrix<Integer> matrix5 = matrix4.subtract(matrix4);
        assertEquals("Matrix subtraction error. matrix5=" + matrix5 + " result2" + result2, matrix5, result2);

        // Result of addition
        Integer[][] array3 = new Integer[][]{{0,2},
                                             {4,6}};
        Matrix<Integer> result3 = new Matrix<Integer>(2,2,array3);

        Matrix<Integer> matrix6 = matrix4.add(matrix4);
        assertEquals("Matrix addition error. matrix6=" + matrix6 + " result3" + result3, matrix6, result3);

        Matrix<Integer> matrix7 = new Matrix<Integer>(2, 2);
        matrix7.set(0, 0, 1);
        matrix7.set(0, 1, 2);
        matrix7.set(1, 0, 3);
        matrix7.set(1, 1, 4);

        Matrix<Integer> matrix8 = new Matrix<Integer>(2, 2);
        matrix8.set(0, 0, 1);
        matrix8.set(0, 1, 2);
        matrix8.set(1, 0, 3);
        matrix8.set(1, 1, 4);

        // Result of multiplication
        Integer[][] array4 = new Integer[][]{{7,10},
                                             {15,22}};
        Matrix<Integer> result4 = new Matrix<Integer>(2,2,array4);

        Matrix<Integer> matrix9 = matrix7.multiply(matrix8);
        assertEquals("Matrix multiplication error. matrix9=" + matrix9 + " result4" + result4, matrix9, result4);
    }
    
    @Test
    public void testIdentityMethod1() {
        Matrix<Integer> matrix = new Matrix<Integer>(2, 2);
        matrix.set(0, 0, 0);
        matrix.set(0, 1, 0);
        matrix.set(1, 0, 0);
        matrix.set(1, 1, 0);
        
        Matrix<Integer> expectedResult = new Matrix<Integer>(2, 2);
        expectedResult.set(0, 0, 1);
        expectedResult.set(0, 1, 0);
        expectedResult.set(1, 0, 0);
        expectedResult.set(1, 1, 1);
        
        try{
        	matrix = matrix.identity();
        } catch(Exception ex){
        	fail();
        }
        
        assertArrayEquals(expectedResult.getRow(0), matrix.getRow(0));
        assertArrayEquals(expectedResult.getRow(1), matrix.getRow(1));
    }
    @Test
    public void testMultiplyInteger() {
        Matrix<Integer> matrix1 = new Matrix<Integer>(4, 3);
        matrix1.set(0, 0, 14);
        matrix1.set(0, 1, 9);
        matrix1.set(0, 2, 3);
        matrix1.set(1, 0, 2);
        matrix1.set(1, 1, 11);
        matrix1.set(1, 2, 15);
        matrix1.set(2, 0, 0);
        matrix1.set(2, 1, 12);
        matrix1.set(2, 2, 17);
        matrix1.set(3, 0, 5);
        matrix1.set(3, 1, 2);
        matrix1.set(3, 2, 3);

        Matrix<Integer> matrix2 = new Matrix<Integer>(3, 3);
        matrix2.set(0, 0, 22);
        matrix2.set(0, 1, 9);
        matrix2.set(0, 2, 3);
        matrix2.set(1, 0, 2);
        matrix2.set(1, 1, 11);
        matrix2.set(1, 2, 15);
        matrix2.set(2, 0, 0);
        matrix2.set(2, 1, 12);
        matrix2.set(2, 2, 17);

        Matrix<Integer> matrixExpect = new Matrix<Integer>(4, 3);
        matrixExpect.set(0, 0, 326);
        matrixExpect.set(0, 1, 261);
        matrixExpect.set(0, 2, 228);
        matrixExpect.set(1, 0, 66);
        matrixExpect.set(1, 1, 319);
        matrixExpect.set(1, 2, 426);
        matrixExpect.set(2, 0, 24);
        matrixExpect.set(2, 1, 336);
        matrixExpect.set(2, 2, 469);
        matrixExpect.set(3, 0, 114);
        matrixExpect.set(3, 1, 103);
        matrixExpect.set(3, 2, 96);

        Assert.assertEquals(matrix1.multiply(matrix2),matrixExpect);
    }
    @Test
    public void testMultiplyBigInteger() {
        Matrix<BigInteger> matrix1 = new Matrix<BigInteger>(4, 3);
        matrix1.set(0, 0, BigInteger.valueOf(
                14));
        matrix1.set(0, 1, BigInteger.valueOf(
                9));
        matrix1.set(0, 2, BigInteger.valueOf(
                3));
        matrix1.set(1, 0, BigInteger.valueOf(
                2));
        matrix1.set(1, 1, BigInteger.valueOf(
                11));
        matrix1.set(1, 2, BigInteger.valueOf(
                15));
        matrix1.set(2, 0, BigInteger.valueOf(
                0));
        matrix1.set(2, 1, BigInteger.valueOf(
                12));
        matrix1.set(2, 2, BigInteger.valueOf(
                17));
        matrix1.set(3, 0, BigInteger.valueOf(
                5));
        matrix1.set(3, 1, BigInteger.valueOf(
                2));
        matrix1.set(3, 2, BigInteger.valueOf(
                3));

        Matrix<BigInteger> matrix2 = new Matrix<BigInteger>(3, 3);
        matrix2.set(0, 0, BigInteger.valueOf(
                22));
        matrix2.set(0, 1, BigInteger.valueOf(
                9));
        matrix2.set(0, 2, BigInteger.valueOf(
                3));
        matrix2.set(1, 0, BigInteger.valueOf(
                2));
        matrix2.set(1, 1, BigInteger.valueOf(
                11));
        matrix2.set(1, 2, BigInteger.valueOf(
                15));
        matrix2.set(2, 0, BigInteger.valueOf(
                0));
        matrix2.set(2, 1, BigInteger.valueOf(
                12));
        matrix2.set(2, 2, BigInteger.valueOf(
                17));

        Matrix<BigInteger> matrixExpect = new Matrix<BigInteger>(4, 3);
        matrixExpect.set(0, 0, BigInteger.valueOf(
                326));
        matrixExpect.set(0, 1, BigInteger.valueOf(
                261));
        matrixExpect.set(0, 2, BigInteger.valueOf(
                228));
        matrixExpect.set(1, 0, BigInteger.valueOf(
                66));
        matrixExpect.set(1, 1, BigInteger.valueOf(
                319));
        matrixExpect.set(1, 2, BigInteger.valueOf(
                426));
        matrixExpect.set(2, 0, BigInteger.valueOf(
                24));
        matrixExpect.set(2, 1, BigInteger.valueOf(
                336));
        matrixExpect.set(2, 2, BigInteger.valueOf(
                469));
        matrixExpect.set(3, 0, BigInteger.valueOf(
                114));
        matrixExpect.set(3, 1, BigInteger.valueOf(
                103));
        matrixExpect.set(3, 2, BigInteger.valueOf(
                96));

        Assert.assertEquals(matrix1.multiply(matrix2),matrixExpect);
    }
    @Test
    public void testMultiplyLong() {
        Matrix<Long> matrix1 = new Matrix<Long>(4, 3);
        matrix1.set(0, 0, 14L);
        matrix1.set(0, 1, 9L);
        matrix1.set(0, 2, 3L);
        matrix1.set(1, 0, 2L);
        matrix1.set(1, 1, 11L);
        matrix1.set(1, 2, 15L);
        matrix1.set(2, 0, 0L);
        matrix1.set(2, 1, 12L);
        matrix1.set(2, 2, 17L);
        matrix1.set(3, 0, 5L);
        matrix1.set(3, 1, 2L);
        matrix1.set(3, 2, 3L);

        Matrix<Long> matrix2 = new Matrix<Long>(3, 3);
        matrix2.set(0, 0, 22L);
        matrix2.set(0, 1, 9L);
        matrix2.set(0, 2, 3L);
        matrix2.set(1, 0, 2L);
        matrix2.set(1, 1, 11L);
        matrix2.set(1, 2, 15L);
        matrix2.set(2, 0, 0L);
        matrix2.set(2, 1, 12L);
        matrix2.set(2, 2, 17L);

        Matrix<Long> matrixExpect = new Matrix<Long>(4, 3);
        matrixExpect.set(0, 0, 326L);
        matrixExpect.set(0, 1, 261L);
        matrixExpect.set(0, 2, 228L);
        matrixExpect.set(1, 0, 66L);
        matrixExpect.set(1, 1, 319L);
        matrixExpect.set(1, 2, 426L);
        matrixExpect.set(2, 0, 24L);
        matrixExpect.set(2, 1, 336L);
        matrixExpect.set(2, 2, 469L);
        matrixExpect.set(3, 0, 114L);
        matrixExpect.set(3, 1, 103L);
        matrixExpect.set(3, 2, 96L);

        Assert.assertEquals(matrix1.multiply(matrix2),matrixExpect);
    }
    @Test
    public void testMultiplyDouble() {
        Matrix<Double> matrix1 = new Matrix<Double>(4, 3);
        matrix1.set(0, 0, 14.0);
        matrix1.set(0, 1, 9.0);
        matrix1.set(0, 2, 3.0);
        matrix1.set(1, 0, 2.0);
        matrix1.set(1, 1, 11.0);
        matrix1.set(1, 2, 15.0);
        matrix1.set(2, 0, 0.0);
        matrix1.set(2, 1, 12.0);
        matrix1.set(2, 2, 17.0);
        matrix1.set(3, 0, 5.0);
        matrix1.set(3, 1, 2.0);
        matrix1.set(3, 2, 3.0);

        Matrix<Double> matrix2 = new Matrix<Double>(3, 3);
        matrix2.set(0, 0, 22.0);
        matrix2.set(0, 1, 9.0);
        matrix2.set(0, 2, 3.0);
        matrix2.set(1, 0, 2.0);
        matrix2.set(1, 1, 11.0);
        matrix2.set(1, 2, 15.0);
        matrix2.set(2, 0, 0.0);
        matrix2.set(2, 1, 12.0);
        matrix2.set(2, 2, 17.0);

        Matrix<Double> matrixExpect = new Matrix<Double>(4, 3);
        matrixExpect.set(0, 0, 326.0);
        matrixExpect.set(0, 1, 261.0);
        matrixExpect.set(0, 2, 228.0);
        matrixExpect.set(1, 0, 66.0);
        matrixExpect.set(1, 1, 319.0);
        matrixExpect.set(1, 2, 426.0);
        matrixExpect.set(2, 0, 24.0);
        matrixExpect.set(2, 1, 336.0);
        matrixExpect.set(2, 2, 469.0);
        matrixExpect.set(3, 0, 114.0);
        matrixExpect.set(3, 1, 103.0);
        matrixExpect.set(3, 2, 96.0);

        Assert.assertEquals(matrix1.multiply(matrix2),matrixExpect);
    }
    @Test
    public void testMultiplyFloat() {
        Matrix<Float> matrix1 = new Matrix<Float>(4, 3);
        matrix1.set(0, 0, 14F);
        matrix1.set(0, 1, 9F);
        matrix1.set(0, 2, 3F);
        matrix1.set(1, 0, 2F);
        matrix1.set(1, 1, 11F);
        matrix1.set(1, 2, 15F);
        matrix1.set(2, 0, 0F);
        matrix1.set(2, 1, 12F);
        matrix1.set(2, 2, 17F);
        matrix1.set(3, 0, 5F);
        matrix1.set(3, 1, 2F);
        matrix1.set(3, 2, 3F);

        Matrix<Float> matrix2 = new Matrix<Float>(3, 3);
        matrix2.set(0, 0, 22F);
        matrix2.set(0, 1, 9F);
        matrix2.set(0, 2, 3F);
        matrix2.set(1, 0, 2F);
        matrix2.set(1, 1, 11F);
        matrix2.set(1, 2, 15F);
        matrix2.set(2, 0, 0F);
        matrix2.set(2, 1, 12F);
        matrix2.set(2, 2, 17F);

        Matrix<Float> matrixExpect = new Matrix<Float>(4, 3);
        matrixExpect.set(0, 0, 326F);
        matrixExpect.set(0, 1, 261F);
        matrixExpect.set(0, 2, 228F);
        matrixExpect.set(1, 0, 66F);
        matrixExpect.set(1, 1, 319F);
        matrixExpect.set(1, 2, 426F);
        matrixExpect.set(2, 0, 24F);
        matrixExpect.set(2, 1, 336F);
        matrixExpect.set(2, 2, 469F);
        matrixExpect.set(3, 0, 114F);
        matrixExpect.set(3, 1, 103F);
        matrixExpect.set(3, 2, 96F);

        Assert.assertEquals(matrix1.multiply(matrix2),matrixExpect);
    }




    @Test
    public void testMultiplyBigDecimal() {
        Matrix<BigDecimal> matrix1 = new Matrix<BigDecimal>(4, 3);
        matrix1.set(0, 0, BigDecimal.valueOf(
                14));
        matrix1.set(0, 1, BigDecimal.valueOf(
                9));
        matrix1.set(0, 2, BigDecimal.valueOf(
                3));
        matrix1.set(1, 0, BigDecimal.valueOf(
                2));
        matrix1.set(1, 1, BigDecimal.valueOf(
                11));
        matrix1.set(1, 2, BigDecimal.valueOf(
                15));
        matrix1.set(2, 0, BigDecimal.valueOf(
                0));
        matrix1.set(2, 1, BigDecimal.valueOf(
                12));
        matrix1.set(2, 2, BigDecimal.valueOf(
                17));
        matrix1.set(3, 0, BigDecimal.valueOf(
                5));
        matrix1.set(3, 1, BigDecimal.valueOf(
                2));
        matrix1.set(3, 2, BigDecimal.valueOf(
                3));

        Matrix<BigDecimal> matrix2 = new Matrix<BigDecimal>(3, 3);
        matrix2.set(0, 0, BigDecimal.valueOf(
                22));
        matrix2.set(0, 1, BigDecimal.valueOf(
                9));
        matrix2.set(0, 2, BigDecimal.valueOf(
                3));
        matrix2.set(1, 0, BigDecimal.valueOf(
                2));
        matrix2.set(1, 1, BigDecimal.valueOf(
                11));
        matrix2.set(1, 2, BigDecimal.valueOf(
                15));
        matrix2.set(2, 0, BigDecimal.valueOf(
                0));
        matrix2.set(2, 1, BigDecimal.valueOf(
                12));
        matrix2.set(2, 2, BigDecimal.valueOf(
                17));

        Matrix<BigDecimal> matrixExpect = new Matrix<BigDecimal>(4, 3);
        matrixExpect.set(0, 0, BigDecimal.valueOf(
                326));
        matrixExpect.set(0, 1, BigDecimal.valueOf(
                261));
        matrixExpect.set(0, 2, BigDecimal.valueOf(
                228));
        matrixExpect.set(1, 0, BigDecimal.valueOf(
                66));
        matrixExpect.set(1, 1, BigDecimal.valueOf(
                319));
        matrixExpect.set(1, 2, BigDecimal.valueOf(
                426));
        matrixExpect.set(2, 0, BigDecimal.valueOf(
                24));
        matrixExpect.set(2, 1, BigDecimal.valueOf(
                336));
        matrixExpect.set(2, 2, BigDecimal.valueOf(
                469));
        matrixExpect.set(3, 0, BigDecimal.valueOf(
                114));
        matrixExpect.set(3, 1, BigDecimal.valueOf(
                103));
        matrixExpect.set(3, 2, BigDecimal.valueOf(
                96));

        Assert.assertEquals(matrix1.multiply(matrix2),matrixExpect);
    }

    @Test
    public void testHashCode() {
        Matrix<Integer> matrix1 = new Matrix<Integer>(4, 3);
        matrix1.set(0, 0, 14);
        matrix1.set(0, 1, 9);
        matrix1.set(0, 2, 3);
        matrix1.set(1, 0, 2);
        matrix1.set(1, 1, 11);
        matrix1.set(1, 2, 15);
        matrix1.set(2, 0, 0);
        matrix1.set(2, 1, 12);
        matrix1.set(2, 2, 17);
        matrix1.set(3, 0, 5);
        matrix1.set(3, 1, 2);
        matrix1.set(3, 2, 3);
        Assert.assertEquals(matrix1.hashCode(),3100);
    }
    @Test
    public void testGetRowsGetCols() {
        Matrix<Integer> matrix1 = new Matrix<Integer>(4, 3);
        matrix1.set(0, 0, 14);
        matrix1.set(0, 1, 9);
        matrix1.set(0, 2, 3);
        matrix1.set(1, 0, 2);
        matrix1.set(1, 1, 11);
        matrix1.set(1, 2, 15);
        matrix1.set(2, 0, 0);
        matrix1.set(2, 1, 12);
        matrix1.set(2, 2, 17);
        matrix1.set(3, 0, 5);
        matrix1.set(3, 1, 2);
        matrix1.set(3, 2, 3);
        Assert.assertEquals(matrix1.getRows(),4);
        Assert.assertEquals(matrix1.getCols(),3);
    }
    @Test
    public void testEqualInteger() {
        Matrix<Integer> matrix1 = new Matrix<Integer>(4, 3);
        matrix1.set(0, 0, 14);
        matrix1.set(0, 1, 9);
        matrix1.set(0, 2, 3);
        matrix1.set(1, 0, 2);
        matrix1.set(1, 1, 11);
        matrix1.set(1, 2, 15);
        matrix1.set(2, 0, 0);
        matrix1.set(2, 1, 12);
        matrix1.set(2, 2, 17);
        matrix1.set(3, 0, 5);
        matrix1.set(3, 1, 2);
        matrix1.set(3, 2, 3);

        Matrix<Integer> matrix2 = new Matrix<Integer>(4, 3);
        matrix2.set(0, 0, 14);
        matrix2.set(0, 1, 9);
        matrix2.set(0, 2, 3);
        matrix2.set(1, 0, 2);
        matrix2.set(1, 1, 11);
        matrix2.set(1, 2, 15);
        matrix2.set(2, 0, 0);
        matrix2.set(2, 1, 12);
        matrix2.set(2, 2, 17);
        matrix2.set(3, 0, 5);
        matrix2.set(3, 1, 2);
        matrix2.set(3, 2, 3);

        Matrix<Integer> matrix3 = new Matrix<Integer>(4, 3);
        matrix3.set(0, 0, 22);
        matrix3.set(0, 1, 9);
        matrix3.set(0, 2, 3);
        matrix3.set(1, 0, 2);
        matrix3.set(1, 1, 11);
        matrix3.set(1, 2, 15);
        matrix3.set(2, 0, 0);
        matrix3.set(2, 1, 12);
        matrix3.set(2, 2, 17);
        matrix3.set(3, 0, 5);
        matrix3.set(3, 1, 2);
        matrix3.set(3, 2, 3);

        Assert.assertTrue(matrix1.equals(matrix2));
        Assert.assertFalse(matrix1.equals(matrix3));
    }
    @Test
    public void testEqualBigInteger() {
        Matrix<BigInteger> matrix1 = new Matrix<>(4, 3);
        matrix1.set(0, 0, BigInteger.valueOf(14));
        matrix1.set(0, 1, BigInteger.valueOf(9));
        matrix1.set(0, 2, BigInteger.valueOf(3));
        matrix1.set(1, 0, BigInteger.valueOf(2));
        matrix1.set(1, 1, BigInteger.valueOf(11));
        matrix1.set(1, 2, BigInteger.valueOf(15));
        matrix1.set(2, 0, BigInteger.valueOf(0));
        matrix1.set(2, 1, BigInteger.valueOf(12));
        matrix1.set(2, 2, BigInteger.valueOf(17));
        matrix1.set(3, 0, BigInteger.valueOf(5));
        matrix1.set(3, 1, BigInteger.valueOf(2));
        matrix1.set(3, 2, BigInteger.valueOf(3));

        Matrix<BigInteger> matrix2 = new Matrix<>(4, 3);
        matrix2.set(0, 0, BigInteger.valueOf(14));
        matrix2.set(0, 1, BigInteger.valueOf(9));
        matrix2.set(0, 2, BigInteger.valueOf(3));
        matrix2.set(1, 0, BigInteger.valueOf(2));
        matrix2.set(1, 1, BigInteger.valueOf(11));
        matrix2.set(1, 2, BigInteger.valueOf(15));
        matrix2.set(2, 0, BigInteger.valueOf(0));
        matrix2.set(2, 1, BigInteger.valueOf(12));
        matrix2.set(2, 2, BigInteger.valueOf(17));
        matrix2.set(3, 0, BigInteger.valueOf(5));
        matrix2.set(3, 1, BigInteger.valueOf(2));
        matrix2.set(3, 2, BigInteger.valueOf(3));

        Matrix<BigInteger> matrix3 = new Matrix<>(4, 3);
        matrix3.set(0, 0, BigInteger.valueOf(1099));
        matrix3.set(0, 1, BigInteger.valueOf(9));
        matrix3.set(0, 2, BigInteger.valueOf(3));
        matrix3.set(1, 0, BigInteger.valueOf(2));
        matrix3.set(1, 1, BigInteger.valueOf(11));
        matrix3.set(1, 2, BigInteger.valueOf(15));
        matrix3.set(2, 0, BigInteger.valueOf(0));
        matrix3.set(2, 1, BigInteger.valueOf(12));
        matrix3.set(2, 2, BigInteger.valueOf(17));
        matrix3.set(3, 0, BigInteger.valueOf(5));
        matrix3.set(3, 1, BigInteger.valueOf(2));
        matrix3.set(3, 2, BigInteger.valueOf(3));

        Assert.assertTrue(matrix1.equals(matrix2));
        Assert.assertFalse(matrix1.equals(matrix3));
    }
    @Test
    public void testCopy() {
        Matrix<Integer> matrix1 = new Matrix<Integer>(4, 3);
        matrix1.set(0, 0, 14);
        matrix1.set(0, 1, 9);
        matrix1.set(0, 2, 3);
        matrix1.set(1, 0, 2);
        matrix1.set(1, 1, 11);
        matrix1.set(1, 2, 15);
        matrix1.set(2, 0, 0);
        matrix1.set(2, 1, 12);
        matrix1.set(2, 2, 17);
        matrix1.set(3, 0, 5);
        matrix1.set(3, 1, 2);
        matrix1.set(3, 2, 3);

        Matrix<Integer> matrix2 = new Matrix<Integer>(4, 3);
        matrix2.copy(matrix1);
        Assert.assertTrue(matrix1.equals(matrix2));
    }
    @Test
    public void testGetRowCol() {
        Matrix<Integer> matrix1 = new Matrix<Integer>(4, 3);
        matrix1.set(0, 0, 14);
        matrix1.set(0, 1, 9);
        matrix1.set(0, 2, 3);
        matrix1.set(1, 0, 2);
        matrix1.set(1, 1, 11);
        matrix1.set(1, 2, 15);
        matrix1.set(2, 0, 0);
        matrix1.set(2, 1, 12);
        matrix1.set(2, 2, 17);
        matrix1.set(3, 0, 5);
        matrix1.set(3, 1, 2);
        matrix1.set(3, 2, 3);

        Object[] rowValue = new Object[3];
        rowValue[0] = 14;
        rowValue[1] = 9;
        rowValue[2] = 3;
        Object[] getRowValue = matrix1.getRow(0);
        for (int i = 0; i < rowValue.length; i++) {
            Assert.assertEquals(getRowValue[i],rowValue[i]);
        }

        Object[] colValue = new Object[4];
        colValue[0] = 14;
        colValue[1] = 2;
        colValue[2] = 0;
        colValue[3] = 5;
        Object[] getColValue = matrix1.getColumn(0);
        for (int i = 0; i < colValue.length; i++) {
            Assert.assertEquals(getColValue[i],colValue[i]);
        }


    }
    @Test
    public void testIdentityMethodBigDecimal() {
        Matrix<BigDecimal> matrix = new Matrix<BigDecimal>(2, 2);
        matrix.set(0, 0, BigDecimal.valueOf(0));
        matrix.set(0, 1, BigDecimal.valueOf(0));
        matrix.set(1, 0, BigDecimal.valueOf(0));
        matrix.set(1, 1, BigDecimal.valueOf(0));

        Matrix<BigDecimal> expectedResult = new Matrix<BigDecimal>(2, 2);
        expectedResult.set(0, 0, BigDecimal.valueOf(1));
        expectedResult.set(0, 1, BigDecimal.valueOf(0));
        expectedResult.set(1, 0, BigDecimal.valueOf(0));
        expectedResult.set(1, 1, BigDecimal.valueOf(1));

        try{
            matrix = matrix.identity();
        } catch(Exception ex){
            fail();
        }

        assertArrayEquals(expectedResult.getRow(0), matrix.getRow(0));
        assertArrayEquals(expectedResult.getRow(1), matrix.getRow(1));
    }
    //Idenntity BigInteger test
    @Test
    public void testIdentityMethodBigInteger() {
        Matrix<BigInteger> matrix = new Matrix<BigInteger>(2, 2);
        matrix.set(0, 0, BigInteger.valueOf(0));
        matrix.set(0, 1, BigInteger.valueOf(0));
        matrix.set(1, 0, BigInteger.valueOf(0));
        matrix.set(1, 1, BigInteger.valueOf(0));

        Matrix<BigInteger> expectedResult = new Matrix<BigInteger>(2, 2);
        expectedResult.set(0, 0, BigInteger.valueOf(1));
        expectedResult.set(0, 1, BigInteger.valueOf(0));
        expectedResult.set(1, 0, BigInteger.valueOf(0));
        expectedResult.set(1, 1, BigInteger.valueOf(1));

        try{
            matrix = matrix.identity();
        } catch(Exception ex){
            fail();
        }

        assertArrayEquals(expectedResult.getRow(0), matrix.getRow(0));
        assertArrayEquals(expectedResult.getRow(1), matrix.getRow(1));
    }
    //Identity Long
    @Test
    public void testIdentityMethodLong() {
        Matrix<Long> matrix = new Matrix<Long>(2, 2);
        matrix.set(0, 0, Long.valueOf(0));
        matrix.set(0, 1, Long.valueOf(0));
        matrix.set(1, 0, Long.valueOf(0));
        matrix.set(1, 1, Long.valueOf(0));

        Matrix<Long> expectedResult = new Matrix<Long>(2, 2);
        expectedResult.set(0, 0, Long.valueOf(1));
        expectedResult.set(0, 1, Long.valueOf(0));
        expectedResult.set(1, 0, Long.valueOf(0));
        expectedResult.set(1, 1, Long.valueOf(1));

        try{
            matrix = matrix.identity();
        } catch(Exception ex){
            fail();
        }

        assertArrayEquals(expectedResult.getRow(0), matrix.getRow(0));
        assertArrayEquals(expectedResult.getRow(1), matrix.getRow(1));
    }
    //Identity Double
    @Test
    public void testIdentityMethodDouble() {
        Matrix<Double> matrix = new Matrix<Double>(2, 2);
        matrix.set(0, 0, Double.valueOf(0));
        matrix.set(0, 1, Double.valueOf(0));
        matrix.set(1, 0, Double.valueOf(0));
        matrix.set(1, 1, Double.valueOf(0));

        Matrix<Double> expectedResult = new Matrix<Double>(2, 2);
        expectedResult.set(0, 0, Double.valueOf(1));
        expectedResult.set(0, 1, Double.valueOf(0));
        expectedResult.set(1, 0, Double.valueOf(0));
        expectedResult.set(1, 1, Double.valueOf(1));

        try{
            matrix = matrix.identity();
        } catch(Exception ex){
            fail();
        }

        assertArrayEquals(expectedResult.getRow(0), matrix.getRow(0));
        assertArrayEquals(expectedResult.getRow(1), matrix.getRow(1));
    }
    //Identity Float test
    @Test
    public void testIdentityMethodFloat() {
        Matrix<Float> matrix = new Matrix<Float>(2, 2);
        matrix.set(0, 0, Float.valueOf(0));
        matrix.set(0, 1, Float.valueOf(0));
        matrix.set(1, 0, Float.valueOf(0));
        matrix.set(1, 1, Float.valueOf(0));

        Matrix<Float> expectedResult = new Matrix<Float>(2, 2);
        expectedResult.set(0, 0, Float.valueOf(1));
        expectedResult.set(0, 1, Float.valueOf(0));
        expectedResult.set(1, 0, Float.valueOf(0));
        expectedResult.set(1, 1, Float.valueOf(1));

        try{
            matrix = matrix.identity();
        } catch(Exception ex){
            fail();
        }

        assertArrayEquals(expectedResult.getRow(0), matrix.getRow(0));
        assertArrayEquals(expectedResult.getRow(1), matrix.getRow(1));
    }
}
