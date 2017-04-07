import java.util.function.BiConsumer;

public class ExceptionHandlingInJava8 {

	static int key = 0;
	static int num[] = {2,1,3,4};
	public static void main(String[] args) {
		
		process(num, wrapperClass((i, k) -> System.out.println(i/k)));
	}
	
	public static void process(int[] num, BiConsumer<Integer, Integer> consumer){
		for (int i : num) {
		   consumer.accept(i, key);
		}
	}
	
	public static BiConsumer<Integer, Integer> wrapperClass(BiConsumer<Integer, Integer> consumer){
           return (i ,k) -> {
        	 try {
				consumer.accept(i, k);
			} catch (Exception e) {
				System.out.println("Cannot divide by zero");
			}  
           };
	}
	
	
	
	
	
}
