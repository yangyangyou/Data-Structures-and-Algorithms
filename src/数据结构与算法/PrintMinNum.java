package 数据结构与算法;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为 321323。
 *
 * */
public class PrintMinNum {

	public static void main(String[] args){
		int [] array={1,2,34,52};
		System.out.println(PrintMinNum.PrintMinNumber2(array));
	}
	
	public static String PrintMinNumber2(int [] array) {
	    int n;
	    String s="";
	    ArrayList<Integer> list= new ArrayList<Integer>();
	    n=array.length;
	    for(int i=0;i<n;i++){
	        list.add(array[i]);
	    }
	    Collections.sort(list, new Comparator<Integer>(){

	        public int compare(Integer str1,Integer str2){
	            String s1=str1+""+str2;
	            String s2=str2+""+str1;
	            return s1.compareTo(s2);
	        }
	    });
	    for(int j:list){
	        s+=j;
	    }
	    return s;
	}
	//思路2：相当于自定义冒泡排序
	    public static  String PrintMinNumber3(int [] array) {
	        String str = "";
	        for (int i=0; i<array.length; i++){
	            for (int j=0; j<array.length-i-1; j++){
	                int a = Integer.valueOf(array[j]+""+array[j+1]);
	                int b = Integer.valueOf(array[j+1]+""+array[j]);
	                if (a > b){
	                    int t = array[j];
	                    array[j] = array[j+1];
	                    array[j+1] = t;
	                }
	            }
	        }
	        for (int i = 0; i < array.length; i++) {
	            str += String.valueOf(array[i]);
	        }
	        return str;
	    }
	}
	
	
	
	
