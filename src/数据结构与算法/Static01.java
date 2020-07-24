package 数据结构与算法;
/*
 * 可以使用static关键字定义“静态代码块
 * 1.语法格式：static{
 *                  Java语句}
 *  2.静态代码块再在类加载时执行，并且只执行一次。
 *  3.静态代码块在一个类中可以编写多个，并且遵循自上而下的顺序依次执行。
 *  4.静态代码块的作用？怎么用？用在哪？什么时候用？
 *  和具体的需求有关，例如在项目中要求在类加载时刻完成日志的记录。那么这段记录日志的的代码就可以
 *  编写到静态代码块档中，完成日志记录。
 *  5.通常在静态代码块完成预备工作，先完成数据的准备工作，例如：初始化连接池，解析xml配置文件。。。
 */
public class Static01 {
   static{
	   System.out.println("类加载--》1");
   }
   static{
	   System.out.println("类加载--》2");
   }
	public static void main(String[] args) {
		
     System.out.println("main begin");
	}

}
