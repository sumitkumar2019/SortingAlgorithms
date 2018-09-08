package com.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MergeSortTest {

	@Test
	void test() {
		assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, mergeSorting(new int[] { 6, 8, 9, 5, 7, 4, 3, 1, 2 }));
	}
	
	public int[] mergeSorting(int mainArray[]){
		mergeSort(mainArray);
		return mainArray;
	}

	public void mergeSort(int mainArray[]){
		
		int lengthOfArray = mainArray.length;
		
		//if array length is less than two then simply return
		if(lengthOfArray<2) {
			return;
		}
		
		//split array in two parts
		int middleIndex = lengthOfArray/2;
		
		//create left array
		int leftArray[] = new int[middleIndex];
		
		//create right array 
		int rightArray[] = new int[lengthOfArray - middleIndex];
		
		//fill left elements from main array to left array
		for(int i=0 ; i<middleIndex; i++) {
			leftArray[i] = mainArray[i];
		}
		//fill remaining elements from main array to right array
		for(int i=middleIndex ; i<lengthOfArray; i++) {
			rightArray[i-middleIndex] = mainArray[i];
		}
		
		//split, arrange and merge left array and right array using recursive calls
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, mainArray);
	}
	
	public void merge(int leftArray[],int rightArray[], int mainArray[]){
		
		//get size of the left, right
		int lengthOfLeftArray = leftArray.length;
		int lengthOfRightArray = rightArray.length;
		
		//get initial index of the left, right and main array 
		int indexOfSmallestPickedInLeftArray = 0;
		int indexOfSmallestPickedInRightArray = 0;
		int indexOfMainArray = 0;
		
		//arrange in ascending order
		while(indexOfSmallestPickedInLeftArray < lengthOfLeftArray 
				&& indexOfSmallestPickedInRightArray < lengthOfRightArray) {
			//if smallest picked left element is less than smallest picked right element then put left element in main array 
			if(leftArray[indexOfSmallestPickedInLeftArray] <= rightArray[indexOfSmallestPickedInRightArray]) {
				mainArray[indexOfMainArray] = leftArray[indexOfSmallestPickedInLeftArray];
				indexOfSmallestPickedInLeftArray++;
			}
			//if smallest picked right element is less than smallest picked left element then put right element in main array
			else{
				mainArray[indexOfMainArray] = rightArray[indexOfSmallestPickedInRightArray];
				indexOfSmallestPickedInRightArray++;
			}
			
			indexOfMainArray++;
		}
		
		//Condition for left over arrays in left array: length of array is still bigger than last smallest picked index in left array
		//then simply put all the remaining elements in Main array
		while(indexOfSmallestPickedInLeftArray < lengthOfLeftArray) {
			mainArray[indexOfMainArray]= leftArray[indexOfSmallestPickedInLeftArray];
			indexOfSmallestPickedInLeftArray++;
			indexOfMainArray++;
		}
		
		//Condition for left over arrays in right array: length of array is still bigger than last smallest picked index in right array 
		//then simply put all the remaining elements in Main array
		while(indexOfSmallestPickedInRightArray < lengthOfRightArray) {
			mainArray[indexOfMainArray]= rightArray[indexOfSmallestPickedInRightArray];
			indexOfSmallestPickedInRightArray++;
			indexOfMainArray++;
		}
	
	}

}
