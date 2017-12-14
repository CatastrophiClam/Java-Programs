package oct4HmwkCh25;

public class GenericBubbleSort {

	public static <E extends Comparable<E>> void bubbleSort(E[] list){
		for(int i = 0; i < list.length; i++){
			for (int j = 0; j < list.length-1; j++){
				if (list[j].compareTo(list[j+1]) < 0){
					swap(list, list[j], list[j+1]);
				}
			}
		}
	}
	
	public static <E extends Comparable<E>> void swap(E[] list, E obj1, E obj2){
		
	}
}
