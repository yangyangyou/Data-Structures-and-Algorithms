package Day01;

import java.util.concurrent.atomic.AtomicReference;

/**
 *单例模式的定义:单例模式确保某个类只有一个实例，而且自行实例化并向整个系统提供这个实例。
 *单例模式的特点
               单例类只能有一个实例。
               单例类必须自己创建自己的唯一实例。
               单例类必须给所有其他对象提供这一实例。
 *单例模式的应用
     在计算机系统中，线程池、缓存、日志对象、对话框、打印机、显卡的驱动程序对象常被设计成单例。
     这些应用都或多或少具有资源管理器的功能。每台计算机可以有若干个打印机，但只能有一个Printer Spooler，
     以避免两个打印作业同时输出到打印机中。每台计算机可以有若干通信端口，系统应当集中管理这些通信端口，
     以避免一个通信端口同时被两个请求同时调用。总之，选择单例模式就是为了避免不一致状态。
*单例模式的Java代码分为
*      1.懒汉式（需要才去创建对象）;2.饿汉式（创建类的实例时就去创建对象）。
 */

//2.饿汉模式：线程安全，耗费资源。(只要调用了该类，就会实例化一个对象，但有时我们并只需要调用该类中的一个方法，而不需要实例化一个对象，)
public class 实现单例2 {
	//2.1属性实例化对象
	   //该对象的引用不可修改
		/*private static final 实现单例2 ourInstance = new 实现单例2();

	    public static 实现单例2 getInstance() {
	        return ourInstance;
	    }
	    private 实现单例2() {}*/
	//2.2在静态代码块实例对象
/*	private static final 实现单例2 ourInstance;

	static{
		ourInstance = new 实现单例2();
	}
    public static 实现单例2 getInstance() {
        return ourInstance;
    }
    private 实现单例2() {}*/
	    
//1.懒汉模式：	 
    //1.1非线程安全：两个线程同时调用getInstance()方法，则会创建两个实例化对象。所以是非线程安全的。
	/*private static 实现单例2 ourInstance;
	public static 实现单例2 getInstance() {
		if (null == ourInstance) {
            ourInstance = new 实现单例2();
        }
        return ourInstance;
    }
	 private 实现单例2() {}*/
	
	//1.2线程安全： 给方法加锁 ：如果有多个线程调用getInstance()方法，当一个线程获取该方法，而其它线程必须等待，消耗资源。
	/*private static 实现单例2 ourInstance;
	public synchronized static 实现单例2 getInstance() {
		if (null == ourInstance) {
            ourInstance = new 实现单例2();
        }
        return ourInstance;
    }
	 private 实现单例2() {}*/
	 
	//1.3线程安全：双重检查锁（同步代码块）
	//为什么需要双重检查锁呢？因为第一次检查是确保之前是一个空对象，而非空对象就不需要同步了，
	//空对象的线程然后进入同步代码块，如果不加第二次空对象检查，两个线程同时获取同步代码块，
	//一个线程进入同步代码块，另一个线程就会等待，而这两个线程就会创建两个实例化对象，
	//所以需要在线程进入同步代码块后再次进行空对象检查，才能确保只创建一个实例化对象。
	
/*	private static 实现单例2 ourInstance;
	   public static 实现单例2 getInstance() {
		if (null == ourInstance) {
			synchronized (实现单例2.class) {
				if (null == ourInstance) {
					ourInstance = new 实现单例2();
				}
			}
		}
        return ourInstance;
	}
	 private 实现单例2() {}*/
		
	//1.4线程安全：静态内部类:利用静态内部类，某个线程在调用该方法时会创建一个实例化对象。
		/*private static class 静态内部类{
			private static final 实现单例2 ourInstance = new 实现单例2();
		}
		public static 实现单例2 getInstance() {
	        return 静态内部类.ourInstance;
		}
		private 实现单例2() {}
	*/
   
	//1.5线程安全：枚举. 枚举的方式是《Effective Java》书中提倡的方式，它不仅能避免多线程同步问题，
    //而且还能防止反序列化重新创建新的对象，但是在枚举中的其他任何方法的线程安全由程序员自己负责。
    //还有防止上面的通过反射机制调用私用构造器。
	enum SingletonTest {  
	    INSTANCE;  
	    public void whateverMethod() { 
	    }
	}
	
	//1.6线程安全：使用ThreadLocal.  ThreadLocal会为每一个线程提供一个独立的变量副本，从而隔离了多个线程对数据的访问冲突。
	//对于多线程资源共享的问题，同步机制采用了“以时间换空间”的方式，而ThreadLocal采用了“以空间换时间”的方式。
	//前者仅提供一份变量，让不同的线程排队访问，而后者为每一个线程都提供了一份变量，因此可以同时访问而互不影响。
	/*private static final ThreadLocal<实现单例2> tlSingleton =new ThreadLocal<实现单例2>() {
                @Override
                protected 实现单例2 initialValue() {
                    return new 实现单例2();
                }
            };

    public static 实现单例2 getInstance() {
        return tlSingleton.get();
    }
    private 实现单例2() {}*/
    
	//1.7线程安全：CAS锁：compareAndSet
	 /* private static final AtomicReference<实现单例2> INSTANCE = new AtomicReference<>();
   public static 实现单例2 getInstance() {
        while (true) {
        	实现单例2 current = INSTANCE.get();
            if (current != null) {
                return current;
            }
            current = new 实现单例2();
            if (INSTANCE.compareAndSet(null, current)) {
                return current;
            }
        }
    }

    private 实现单例2() {}*/
  //1.8线程安全：用volatile禁止指令重排改进 1.3双重检查锁
    
    //volatile的作用是：保证可见性、禁止指令重排序，但不能保证原子性
    private volatile  static 实现单例2 ourInstance;
	   public static 实现单例2 getInstance() {
		if (null == ourInstance) {
			synchronized (实现单例2.class) {
				if (null == ourInstance) {
					ourInstance = new 实现单例2();
				}
			}
		}
     return ourInstance;
	

	 }
	 
	 /*// 单例模式在JDK8源码中的使用
	 // 饿汉式单例设计模式
	 public class Runtime {
	     private static Runtime currentRuntime = new Runtime();

	     public static Runtime getRuntime() {
	         return currentRuntime;
	     }

	     private Runtime() {
	     }

	 }*/
	 
	}

