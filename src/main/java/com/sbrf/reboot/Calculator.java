package com.sbrf.reboot;

import java.math.BigInteger;

/**
 * Класс калькулятор. Выполняет следующие функции: сложение, вычитание, умножение, деление, деление с остатком, возведение числа в степень, вычисление процента от числа
 * @autor Юрий Парамонов
 * @version 1.1
 */

public class Calculator {


    /**
     * Метод "Сложение"
     * @param var1 - переменная 1
     * @param var2 - переменная 2
     * @return результат сложения
     */

    public static int addition (int var1, int var2) {
        int result = Math.addExact(var1, var2);
        return result;
    }

    /**
     * Метод "Вычитание"
     * @param var1 - переменная 1
     * @param var2 - переменная 2
     * @return результат вычитания
     */
    public static int subtraction (int var1, int var2 ){
        return var1 - var2;
    }

    /**
     * Метод "Умножение"
     * @param var1 - переменная 1
     * @param var2 - переменная 2
     * @return результат умножения
     */
    public static int multiplication (int var1, int var2 ){
        return var1 * var2;
    }

    /**
     * Метод "Деление"
     * @param var1 - числитель
     * @param var2 - знаменатель
     * @return результат деления
     */
        public static double division (double var1, double var2 ){

            if (var2 == 0) {
                throw new ArithmeticException("Incorrect operation");
            }
            else
                return var1 / var2;
    }

    /**
     * Метод "Деление с остатком"
     * @param var1 - числитель
     * @param var2 - знаменатель
     * @return результат деления с остатком
     */
    public static double divisionWithRemainder(int var1, int var2 ){
        return var1 % var2;
    }

    /**
     * Метод "Возведение числа в степень"
     * @param var - целочисленная переменная для возведения в степень
     * @param degree - степень числа
     * @return результат возведения числа в степень
     */
    public static double degree (int var, int degree ){
        return Math.pow(var, degree);
    }

    /**
     * Метод "Вычисление процента от числа"
     * @param var - целочисленная переменная для вычисления процента
     * @param percent - количество процентов
     * @return результат вычисления процента от числа
     */
    public static double percent (double var, double percent){
            double result;
            result = (percent / 100) * var;
            return  result;
        }

}
