package com.sbrf.reboot;

public class Calculator {

    //Сложение
    public static int addition (int var1, int var2){
       return var1 + var2;
    }

    //Вычитание
    public static int subtraction (int var1, int var2 ){
        return var1 - var2;
    }

    //Умножение
    public static int multiplication (int var1, int var2 ){
        return var1 * var2;
    }

    //Деление
    public static double division (double var1, double var2 ){
        double result = -1.0;
        if (var2 != 0) {
            result = var1 / var2;
            return result;

        }
        else
            return result;
    }

    //Деление с остатком
    public static double division_w_remainder (int var1, int var2 ){
        return var1 % var2;
    }

    //Возведение числа в степень
    public static double degree (int var, int degree ){
        return Math.pow(var, degree);
    }

    //Вычисление процента от числа
    public static double percent (double var, double percent){
        double result;
        result = (percent / 100) * var;
        return  result;
    }
}
