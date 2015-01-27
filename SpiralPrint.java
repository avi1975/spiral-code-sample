

import java.util.Arrays;

public class SpiralPrint {

	/*
	 * 1 2 3 4
	 * 
	 * 5 6 7 8
	 * 
	 * 9 10 11 12
	 * 
	 * 1 2 3 4 8 12 11 10 9 5 6 7 
	 * 1 2 3 4 8 12 11 10 9 5 6 7
	 * 1 2 3 4 8 12 11 10 9 5 6 7 
	 * 
	 * A b c d e 1
	 * 
	 * F g h I j 2
	 * 
	 * K l m n o 3
	 * 
	 * P q r s t 4
	 * 
	 * Output: a b c d e 1 2 3 4 t s r q p k f g h l j o n l m A b c d e 1 2 3 4
	 * t s r q P K F g h I j o n m l
	 */

	public static void main(String[] args) {
		String[][] strtArr1 = { { "1", "2", "3", "4" }, 
								{ "5", "6", "7", "8"}, 
								{"9", "10", "11", "12"},
								{"13", "14", "15", "16"} };

		String[][] strtArr2 = new String[][] { { "A", "b", "c", "d", "e", "1" },
								{ "F", "g", "h", "I", "j", "2" },
								{ "K", "l", "m", "n", "o", "3" },
								{ "P", "q", "r", "s", "t", "4" } };
		// printSpiral(strtArr1);
		String file1 = "content1.txt";
		String file2 = "content2.txt";
		ReadFileAsArray readFileAs2DArray = new ReadFileAsArray();
		
		String[][] strtArr = readFileAs2DArray.readFileContentAs2DArray(file1);
		System.out.println("Input:" + Arrays.deepToString(strtArr));
		System.out.print("Output:");
		printSpiral(strtArr);
		System.out.println();
		
		strtArr = readFileAs2DArray.readFileContentAs2DArray(file2);
		System.out.println("Input:" + Arrays.deepToString(strtArr));
		System.out.print("Output:");
		printSpiral(strtArr);
		System.out.println();
		
	}

	public static void printSpiral(String[][] arr) {
		if(arr == null || arr.length ==0) {
			System.out.println("Invalid input");
			return;
		}
		int top = 0;
		int bottom = arr.length - 1; // number of rows - 1
		int left = 0;
		int right = arr[0].length - 1;// number of columns - 1

		int direction = 0;

		while (top <= bottom && left <= right) {
			int i = 0;
			if (direction == 0) { // print top row from left to right
				for (i = left; i <= right; i++) {
					System.out.print(arr[top][i] + " ");
				}
				top++;
				direction = 1;
			} else if (direction == 1) { // print right column from top to
				// bottom
				for (i = top; i <= bottom; i++) {
					System.out.print(arr[i][right] + " ");
				}
				right--;
				direction = 2;
			} else if (direction == 2) {// print bottom row from right to left
				for (i = right; i >= left; i--) {
					System.out.print(arr[bottom][i] + " ");
				}
				bottom--;
				direction = 3;
			} else {// print left column from bottom top
				for (i = bottom; i >= top; i--) {
					System.out.print(arr[i][left] + " ");
				}
				left++;
				direction = 0;
			}
		}
	}
}
