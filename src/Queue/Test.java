package Queue;



public class Test {

	public static void main(String[] args) {
		int array1[]={89,100,63,75,53};
		int array2[]={95,64,43,72};
		System.out.println(PrintMinNumber(array1, array2));
	}
	public static int PrintMinNumber(int array1[],int array2[]){
		int Min=100;
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				 int temp=Math.abs(array1[i]-array2[j]);
				 
				 if (temp<Min) {
					 Min=temp;
					
				}
				 
				}
			}
		return Min;
		}
		
	}
	

