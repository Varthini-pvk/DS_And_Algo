package sorting;

import java.util.Arrays;

public class S004_InsertionSort 

{
	
	//@Test
    public void test1(){
        int[] input = {11,4,17,18,2,22,1,8};
        System.out.println(Arrays.toString(insertionSort(input)));
    }
    
    //@Test
    public void test2(){
        int[] input = {2,3,4,4,5,6,7,8,5};
        System.out.println(Arrays.toString(insertionSort(input)));
    }
    
    //@Test
    public void test3(){
        int[] input = {11,4,17,-18,2,22,1,8};
        System.out.println(Arrays.toString(insertionSort(input)));
    }
    
    //@Test
    public void test4(){
        int[] input = {1,5,8,12,22,35,67,89};
        System.out.println(Arrays.toString(insertionSort(input)));
    }
	
	
public int[] insertionSort(int[] input){
        
        for (int i = 0; i < input.length-1; i++) {
            if(input[i]>input[i+1]){
                int temp=input[i];
                input[i]=input[i+1];
                input[i+1]=temp;
            }
            for (int j =i ; j >=1 && input[j]<input[j-1] ; j--) {
                    int temp=input[j];
                    input[j]=input[j-1];
                    input[j-1]=temp;
            }
            
            
        }
        return input;
        
    }

}
