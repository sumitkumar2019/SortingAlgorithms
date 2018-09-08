package com.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

class InsertionSortTest {

	@Test
	void test() {
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				insertionSort(new int[] { 9, 8, 6, 5, 4, 7, 3, 2, 1 }));
	}

	public int[] insertionSort(int A[]) {

		for(int i=0; i<A.length; i++) {
			//Take pivot index and element 
			int pivot = i;
			int pivotElement = A[pivot];
			//loop till pivot index 
			for(int j=0; j<pivot; j++) {
				//compare pivot element with Each element till pivot index if element is greater than pivot
				if(pivotElement < A[j]) {
					//swap them with pivot index element
					int temp = A[j];
					A[j]=A[pivot];
					A[pivot] = temp;
				}	
			}
		}

		return A;
	}

}
