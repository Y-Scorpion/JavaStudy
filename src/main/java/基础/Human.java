package 基础;

/**
 *
* @Title: User
* @Description:
* 反射测试实体类
 */
public class Human{
    private int age;
    private String name;

    public class PA{};
    private class PRA{};
    public interface PIB{};
    private interface PRIB{};


    private void HAMethods(){}
    public void HBMethods(){}
    protected void HCMethods(){}
}

class User extends Human{
    private int age;
	private String name;
	private String quanxian;
    
    //构造方法1（默认构造方法）***********************  


    //公共的内部类
    public class A{
        String name;
        class Aa{};
    }
    //保护内部类
    protected class B{}
    //默认内部类
    class C{}
    //私有内部类：
    private class D{}

    //构造方法1
    public User(){

    }
    //构造方法2  
    private User(String name){
        this.name=name;  
    }
    //构造方法3
    protected User(int age, String name) {
        this.age = age;
        this.name = name;
    }
    //构造方法4
    User(int age, String name, String quanxian) {
        this.age = age;
        this.name = name;
        this.quanxian = quanxian;
    }

    //******自定义方法*************
    public void getMessage(){  
        System.out.print("反射测试");  
    }  
    
    //******自定义方法2*************  
    public String getMessage2(int num){  
    	String str=num+"反射测试!";
        System.out.print(str);
		return str;  
    }  
    
    //******自定义方法3*************  
    private String getMessage3(){  
    	String str="这是一个私有的方法!";
        System.out.print(str);
		return str;  
    }  
    
    
    //******自定义方法4*************  
    public static String getMessage4(String s){  
    	String str=s+"这是一个静态的方法!";
        System.out.print(str);
		return str;  
    }  
    
    //******重写toString方法，在测试的时候会用到*****  

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", quanxian='" + quanxian + '\'' +
                '}';
    }

    //*******get set 方法
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQuanxian() {
        return quanxian;
    }

    public void setQuanxian(String quanxian) {
        this.quanxian = quanxian;
    }
}
