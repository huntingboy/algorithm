package com.nomad.jzoffer;

public class Power {
    public double power(double base, int exponent) {
        int exp = exponent;
        double result = 1;
        if (base == 0) return 0;
        else if (exponent == 0) {
            return 1;
        } else if (exponent < 0) {
            exp = -exponent;
        }
//            return base * power(base, exponent - 1);  //溢出

            while (exp != 0) {
                if ((exp & 1) == 1) {
                    result *= base;
                }
                base *= base;
                exp = exp >> 1;
            }

        return exponent > 0 ? result : (1/result);
    }
}
