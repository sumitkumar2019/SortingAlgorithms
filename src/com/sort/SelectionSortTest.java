package com.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SelectionSortTest {

	@Test
	void test() {
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				selectionSort(new int[] { 8, 9, 5, 7, 4, 6, 3, 2, 1 }));
	}

	public int[] selectionSort(int A[]) {

		// 1. check all the elements
		for (int i = 0; i < A.length; i++) {

			// let initially min is 0 index which will then swap with the smallest value in
			// the array
			int minIndex = i;

			// check all the elements for minimum value but once element will found at an
			// index we will check next value with new min index value

			for (int j = i + 1; j < A.length; j++) {
				if (A[minIndex] > A[j]) {
					minIndex = j;
				}
			}
			// Swap new min value from the array to the min index
			int temp = A[i];
			A[i] = A[minIndex];
			A[minIndex] = temp;

		}

		return A;
	}

}
