package com.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

class BubbleSortTest {

	@Test
	void test() {
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, bubbleSort(new int[] { 8, 9, 6, 5, 7, 4, 3, 1, 2 }));
	}

	public int[] bubbleSort(int A[]) {

		//Create n pass
		for (int i = 0; i < A.length; i++) {
			// on each pass compare each element with the next element
			for (int j = 0; j < A.length-1; j++) {
				//if next element is smaller swap them with previous element
				if (A[j] > A[j + 1]) {
					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}
			}
		}
		return A;
	}

}
