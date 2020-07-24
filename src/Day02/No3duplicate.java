package Day02;


public class No3duplicate {

/*
 * 面试题3：查找数组中重复的数字
 * 在一个长度为n的数组中的所有数字都在0~n-1的范围内。
 * 数组中某一个数字是重复的，但不知道有几个数字重复了，也不知道一个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 例如输入长度为7的数组{2，3，1，0，2，5，3}，那么对应的输出是重复数字2或者3。
 * 实例：对应的输出的第一个重复的数字是2。
 * */
	
	public static void main(String[] args) {
		No3duplicate n =new No3duplicate();
		int arr[]={4,5,1,0,2,5,3};
		
		int duplication[]={-1};
		boolean b =n.duplicate(arr, arr.length, duplication);
		System.out.println(duplication[0]);

	
		
	}
	public boolean duplicate(int numbers[],int length,int duplication[]){
		if (numbers==null) {
			return false;
		}
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<length;i++){
			//判断：若是数值小于0或者数值大于length-1，则直接返回false.这是题目要求
			if (numbers[i]<0||numbers[i]>length-1) {
				return false;
			}
			sb.append(numbers[i]+"");
		}
		for(int i=0;i<length;i++){
			for(int j=i+1;j<length;j++){
				if (numbers[i]==numbers[j]) {
					duplication[0]=numbers[i];
					return true;
				}
			}
		}
		return false;
		
		
	}

}
