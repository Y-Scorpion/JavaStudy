package 基础;

/**
 * 
 * @Title: PolymorphicTest
 * @Description: 多态测试
 */
public class PolymorphicTest {

	public static void main(String[] args) {
		Animal2 animal = new Cat2();
		animal.eat();
	}
}

class Animal2 {
	private String name = "Animal";

	public void eat() {
		System.out.println(name + "正在吃东西...");
		sleep();
	}

	public void sleep() {
		System.out.println(name + "正在睡觉...");
	}
}

class Cat2 extends Animal2 {
	private String name = "Cat";

	public void eat(String name) {
		System.out.println(name + "吃完了");
		sleep();
	}

	public void sleep() {
		System.out.println(name + "正在睡觉");
	}
}
