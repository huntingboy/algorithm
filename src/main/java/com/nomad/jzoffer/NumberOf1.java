package com.nomad.jzoffer;
public class NumberOf1{
    public int numberOf1(int n) {
		int result = 0;
		if(n == 0) return 0;
		else if(n == -2147483648) return 1;
		else if(n > 0){
			while (n > 0) {
				int m = n % 2;
				n = n >> 1;
				if (m == 1) {
					result++;
				}
			}
			return result;
		}
		else{
			n = -n;
			while (n > 0) {
				int m = n % 2;
				n = n >> 1;
				if (m == 0) {
					result++;
				}
			}
			return 32 - result;
		}
	}

	//秒解
	public int numberOf2(int n) {
		int count = 0;
		while(n!= 0){
			count++;
			n = n & (n - 1);
		}
		return count;
	}
}
