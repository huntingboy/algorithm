package com.nomad.jzoffer;

public class PrintMinNumber {
    public String printMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (Integer.valueOf(numbers[i] + "" + numbers[j]) > Integer.valueOf(numbers[j] + "" + numbers[i])) {
                    int tmp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = tmp;
                }
            }
        }

        String res = "";
        for (int number : numbers) {
            res += number;
        }

        return res;
    }
}
