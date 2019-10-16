package com.nomad.jzoffer;

public class Fibonacci{
    public int fibonacci(int n) {
		if(n == 0) return 0;
		else if(n == 1) return 1;
		else if(n == 2) return 1;
		else return fibonacci(n-2)+fibonacci(n-1);
    }

	public int jumpFloor(int target) {
		if(target == 0) return 1;
		else if(target == 1) return 1;
		else return jumpFloor(target - 2) + jumpFloor(target - 1);
	}

	public int JumpFloorII(int target) {
		if(target == 0) return 1;
		int sum = 0;
		for(int i = 0; i < target; i++){
			sum += JumpFloorII(i);
		}	
		return sum;
    }

	public int RectCover(int target) {
        if(target == 1) return 1;
		else if(target == 2) return 2;
		else return RectCover(target - 1) + RectCover(target - 2);
    }
}
