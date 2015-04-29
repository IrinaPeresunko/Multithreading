package multithreading;

import java.util.Arrays;

//search max element using multithreading

public class SearchMaxElement implements Runnable {
	private static int size=5;
	private static int max;
	private static int[] array;
	public static void createArray(){
		array = new int[size];
		
		for(int i=0;i<size;i++){
			array[i] = (int) (Math.random()*10);
		}
		System.out.println(Arrays.toString(array));
	}
	public SearchMaxElement(){
		createArray();
	}
	public int[] getArray(){
		return array;
	}
	public static int getSize(){
		return size;
	}
	public static int searchMax(int firstIndex,int size){
		int resultMax = max;
		for(int i=firstIndex;i<size;i++){
			if(resultMax<array[i]){
				resultMax = array[i];
			}
		}
		return resultMax;
	}
	public static int searchMaxFirstPart(int firstIndex,int size){
		max = array[firstIndex];
		for(int i=firstIndex+1;i<size;i++){
			if(max<array[i]){
				max = array[i];
			}
		}
		return max;
	}
	public static void main(String[] args) {
		Runnable searchMaxFirstPart = new SearchMaxElement();
		Thread thread = new Thread(searchMaxFirstPart);
		thread.start();
//		try {
//			thread.join();
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		int maxSecondPart = searchMax((getSize()/2),getSize());
		System.out.println("maxSecondPart = "+maxSecondPart);
	}

	public void run() {
		try{
			Thread.sleep(200);
		}
		catch(InterruptedException e){
			throw new RuntimeException(e);
		}
		max = searchMaxFirstPart(0,(size/2));	
		System.out.println("maxFirstPart = "+max);
	}
}

