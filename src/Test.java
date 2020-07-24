
public class Test {

	
	
			//2.1属性实例化对象
			   //该对象的引用不可修改
				private static final Test ourInstance = new Test();

			    public static Test getInstance() {
			        return ourInstance;
			    }
			    private Test() {}
				
			    public static void main(String []args){
			    	String string=" aB Cd ";
			    	System.out.println(string.toLowerCase());
			    	System.out.println(string.toString());
			    	
			    	System.out.println(string.charAt(3));
			    	System.out.println(string.trim());
			    	System.out.println(Test.ourInstance);
			    	
			    }

	}


