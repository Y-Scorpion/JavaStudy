package 基础;

import java.util.Date;


/**
 * 
* Title: FinalTest
* Description:
*  final测试
 */
public class FinalTest{
	public static void main(String[] args) {
		//这句会报错  因为该变量已经被final修饰了
//		name="张三";
//		names.append("aaa");

//		System.out.println(names);// 可以修改值 不可改变变量引用指向

	}

	//定义一个final修饰的变量
	public  static final String name="xuwujing";
	public  static final StringBuffer names=new StringBuffer("sss");
	//类加上final之后，该类是无法被继承的
	final class Test2{
	}
	//这句会报错，因为Test2是被final修饰的类
//	class Test3 extends Test2{
//	}
	
	class Test4{
		//定义一个被final修饰的方法
		 final Date getTime(){
			return new Date();
		}
	}
	
	class Test5 extends Test4{
		//这句会报错，因为final方法是不能被子类修改的。
//		Date getTime(){
//			return new Date();
//		}
	}
}
