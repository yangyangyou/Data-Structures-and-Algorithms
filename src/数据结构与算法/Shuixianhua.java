package 数据结构与算法;
//水仙花:水仙花数是指一个 3 位数，它的每个位上的数字的 3次幂之和等于它本身（例如：1^3 + 5^3+ 3^3 = 153）。

public class Shuixianhua {
	
	
	
//	类方法
	private boolean shuixianhua(int m){
    	int a,b,c;
    	 c=m/100;
    	 a=m%10;
    	 b=m/10-c*10;
    	/* System.out.println(a);
    	 System.out.println(b);
    	 System.out.println(c);*/
    	 if(m==c*c*c+a*a*a+b*b*b){
    		 return true;
    	 }else{
    		 return false;
		}
	 }
	
	public static void main(String [] args){
		//实例方法-新建对象，对象名。方法名
		Shuixianhua a=new Shuixianhua();//新建对象a
		Boolean string=a.shuixianhua(100);
		System.out.println(string);
		//静态方法-不用新建对象。类名。方法名
		Boolean str=Shuixianhua.shuixianhua1(100);
		System.out.println(str);
	}
	
//	静态方法
	private static boolean shuixianhua1(int m){
    	int a,b,c;
    	  
    	 c=m/100;
    	 a=m%10;
    	 b=m/10-c*10;
    	 if(m==c*c*c+a*a*a+b*b*b){
    		 return true;
    	 }else{
    		 return false;
		}
	 }
	
	
		
	
}
