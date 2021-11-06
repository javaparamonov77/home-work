package com.sbrf.reboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CalculatorTest {

    @Test
    void addition() {
        int result = Calculator.addition(2, 4);
        Assertions.assertEquals(6, result);
    }

    @Test
    void subtraction() {
        //Получение положительного значения
        int result1 = Calculator.subtraction(4, 2);
        Assertions.assertEquals(2, result1);

        //Получение отрицательного значения
        int result2 = Calculator.subtraction(2, 4);
        Assertions.assertEquals(-2, result2);
    }

    @Test
    void multiplication() {
        //Умножение на 0 (1)
        int result1 = Calculator.multiplication(0, 2);
        Assertions.assertEquals(0, result1);
        //Умножение на 0 (2)
        int result2 = Calculator.multiplication(2, 0);
        Assertions.assertEquals(0, result2);

        //Умножение на отрицательное число
        int result3 = Calculator.multiplication(2, -4);
        Assertions.assertEquals(-8, result3);
    }

    @Test
    void division() {
        //Деление на 0
        double result1 = Calculator.division(2, 0);
        Assertions.assertEquals(-1, result1);

        //0 в числителе
        double result2 = Calculator.division(0, 2);
        Assertions.assertEquals(0, result2);

        //Деление на отрицательное число
        double result3 = Calculator.division(2, -4);
        Assertions.assertEquals(-0.5, result3);

    }

    @Test
    void division_w_remainder() {
        double result = Calculator.division_w_remainder(3, 2);
        Assertions.assertEquals(1, result);
    }

    @Test
    void degree() {
        //Степень. Порядок = 1
        double result1 = Calculator.degree(9, 2);
        Assertions.assertEquals(81, result1);
        //Степень. Порядок = 2
        double result2 = Calculator.degree(2, 11);
        Assertions.assertEquals(2048, result2);
        //Отрицательная степень
        double result3 = Calculator.degree(2, -3);
        Assertions.assertEquals(0.125, result3);
        //Нулевая степень
        double result4 = Calculator.degree(2, 0);
        Assertions.assertEquals(1, result4);
    }

    @Test
    void percent() {
        double result = Calculator.percent(100, 10);
        Assertions.assertEquals(10, result);
    }
}