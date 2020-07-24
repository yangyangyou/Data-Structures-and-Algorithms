package Day01;

import java.util.Scanner;

/*题目：请实现一个函数，把字符串中的每个空格替换成“%20”。

** 例如，输入“We are happy.”，则输出“We%20are%20happy.”*/
public class 替换空格5 {

	public String replaceBlank1(StringBuffer s){
		if(s==null){
			return null;
		}
		int blankNum=0;
		for(int i=0;i<s.length();i++){
			if (s.charAt(i)==' ') {
				blankNum++;
			}
		}
		
		int front =s.length()-1;
		int tail=s.length()-1+2*blankNum;
		s.setLength(tail+1);// +1是指    加上String后边的/0
		while(front !=tail){
			if(s.charAt(front)==' '){
				s.setCharAt(tail--,'0');
				s.setCharAt(tail--, '2');
				s.setCharAt(tail--, '%');
				}
				else {
					s.setCharAt(tail--, s.charAt(front));
				}
				front--;
			}
	
		return String.valueOf(s);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		替换空格5 rb = new 替换空格5();
		
		Scanner in = new Scanner(System.in);
		System.out.println("输入一个字符串：");
		StringBuffer s = new StringBuffer(in.nextLine());   //输入一行字符串
		
		System.out.println("将空格转换为20%的结果(StringBuilder,时间复杂度O(n)+空间复杂度O(n))：");
		System.out.println(rb.replaceBlank1(s));
		System.out.println("将空格转换为20%的结果(从后往前进行赋值，时间复杂度O(n))：");
		System.out.println(rb.replaceBlank1(s));
	}

	
}

