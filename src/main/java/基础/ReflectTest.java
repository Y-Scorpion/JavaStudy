package 基础;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;


/**
 * 
* Title: ReflectTest
* Description:
* 反射测试 
* 
* 反射技术可以对一个类进行解剖。
　 优点:大大的增强了程序的扩展性。
 */
public class ReflectTest {  
  
    public static void main(String[] args) throws Exception {  
//        Class<User> claUser = User.class;//获得User的类名，返回reflect.User  //反射两种创建方式
        Class<?> claUser = Class.forName("基础.User");
        Class<User.A> aClass = User.A.class;
        Class<User.B> bClass = User.B.class;
        Class<User.C> cClass = User.C.class;
        Class<?> dClass = Class.forName("基础.User$D");

//      getInnerClass(claUser);
//      getInnerDeclaredClass(claUser);

//      getDeclaredClassTest(aClass);

//        getModifiersTest(bClass);

//        getConstructorsTest(claUser);
//        getDeclaredConstructorsTest(claUser);

//        getFieldsTest(claUser);
//        getDeclaredFieldsTest(claUser);

//        newInstanceTest(claUser);

//        getStringTest(claUser);

//        getMethodsTest(claUser);
//        getDeclaredMethodsTest(claUser);

        invokeTest(claUser);
//      Object obj = create(claUser);//创建User的一个对象
//      System.out.println(claUser);//输出对象，会调用对象的toString方法
//      System.out.println("---------");
//      invoke1(claUser, "getMessage");//调用User对象的getMessage方法
    }

    /**
     * 返回类定义的公共的内部类,以及从父类、父接口那里继承来的内部类
     *  public Class<?>[] getClasses()
     * @param cla
     */
    public static void getInnerClass(Class<?> cla){
        System.out.println(cla.getName()+"内公有内部类和接口(包括继承)");
        Class<?>[] classes = cla.getClasses();
        for (Class<?> c:classes) {
            System.out.println(c.getName());
        }
    }

    /**
     *   返回类中定义的公共、私有、保护的内部类
     *   public Class<?>[] getDeclaredClasses()
     * @param cla
     */
    public static void getInnerDeclaredClass(Class<?> cla){
        System.out.println(cla.getName()+"内所以得内部类和接口(不包括继承)");
        Class<?>[] declaredClasses = cla.getDeclaredClasses();
        for (Class<?> c:declaredClasses) {
            System.out.println(c.getName());
        }
    }

    /**
     * 获取Class对应类(或者接口)的修饰符,返回修饰符的二进制值
     * Modifier将获取到的二进制值转换为字符串。
     * @param cla
     */
    public static void getModifiersTest(Class<?> cla){
        int modifiers = cla.getModifiers();
        String mstr = Modifier.toString(modifiers);
        System.out.println("当前传入class修饰符："+mstr);
    }

    /**
     *     Constructor<?>[] getConstructors();
     *     返回所有共有的构造方法的Constructor对象的数组
     */
    public static void  getConstructorsTest(Class<?> cla) throws NoSuchMethodException {
        System.out.println("获取class对象的公开的构造函数：");
        Constructor<?>[] constructors = cla.getConstructors();
        for (Constructor<?> con:constructors) {
            System.out.println(con);
        }
    }

    /**
     *  Constructor<?>[] getDeclaredConstructors();
     *  返回所有的构造方法的Constructor对象的数组的Constructor对象的数组
     */
    public static void  getDeclaredConstructorsTest(Class<?> cla){
        System.out.println("获取class对象的全部的构造函数：");
        Constructor<?>[] declaredConstructors = cla.getDeclaredConstructors();
        for (Constructor con:declaredConstructors) {
            System.out.println(con);
        }
    }


    /**
     * Field[] getFields()
     *           返回此 Class 对象所表示的类或接口的所有公有字段数组(Field 对象数组)
     */
    public static void getFieldsTest(Class<?> cla) throws NoSuchFieldException {
        System.out.println("获取Class对象的公有权限的字段");
        Field[] fields = cla.getFields();
        for (Field fie:fields) {
            System.out.println(fie);
        }
    }

    /**
     *Field getDeclaredField(String name)
         *      返回一个此 Class 对象所表示的类或接口的指定已声明字段(Field 对象)
     */
    public static void getDeclaredFieldsTest(Class<?> cla){
        System.out.println("获取Class对象的全部权限的字段");
        Field[] fields = cla.getDeclaredFields();
        for (Field fie:fields) {
            System.out.println(fie.getName());
        }
    }
    /**
     *  Method[] getMethods()
     *           返回一个包含某些 Method 对象的数组，这些对象反映此 Class 对象所表示的类或接口
     *          （包括那些由该类或接口声明的以及从超类和超接口继承的那些的类或接口）的公共 member 方法

     */
    public static void getMethodsTest(Class<?> cla){
        System.out.println("获取 Class对象公开 member 方法");
        Method[] methods = cla.getMethods();
        for (Method met:methods) {
            System.out.println(met);
        }
    }
    /**
     *Method[] getDeclaredMethods()
     *          返回 Method 对象的一个数组，这些对象反映此 Class 对象表示的类或接口声明的所有方法，
     *           包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
     */
    public static void getDeclaredMethodsTest(Class<?> cla){
        System.out.println("获取 Class对象所有方法 member 方法");
        Method[] methods = cla.getDeclaredMethods();
        for (Method met:methods) {
            System.out.println(met);
        }
    }


    /**
     *  T newInstance()
     *           创建此 Class 对象所表示的类的一个新实例。
     */
    public static void newInstanceTest(Class<?> cla) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Constructor<?> constructor = cla.getDeclaredConstructor(int.class,String.class,String.class);
        System.out.println(constructor);
        User o = (User) constructor.newInstance(18,"张三","管理员");
        System.out.println(o);
    }

    /**
     *  String getCanonicalName()
     *           返回 Java Language Specification 中所定义的底层类的规范化名称。
     *  String getName()
     *           以 String 的形式返回此 Class 对象所表示的实体（类、接口、数组类、基本类型或 void）名称（全限定名：包名.类名）。
     *  String getSimpleName()
     *           返回源代码中给出的底层类的简称。
     *  String toString()
     *           将对象转换为字符串。
     */
    public static void getStringTest(Class<?> cla){
        String canonicalName = cla.getCanonicalName();
        System.out.println("规范化名字canonicalName: "+canonicalName);
        String name = cla.getName();
        System.out.println("完整名字name: "+name);
        String simpleName = cla.getSimpleName();
        System.out.println("简称simpleName: "+simpleName);
        String s = cla.toString();
        System.out.println("toSting: "+s);
    }


    /**
     * 返回一个成员内部类所在的声明类的Class
     * @param cla
     */
    public static void getDeclaredClassTest(Class<?> cla){
        System.out.println("传入的class:"+cla.getName());
        Class<?> declaringClass = cla.getDeclaringClass();
        System.out.println("获取到的class:"+declaringClass.getName());
    }

    static void invokeTest(Class<?> cla) throws Exception {
        Method method = cla.getDeclaredMethod("getMessage3");
        method.setAccessible(true);//访问私有方法方式
        System.out.println(method.toGenericString());
        method.invoke(cla.newInstance()); //需创建对象实例
//        System.out.println(mtest.toString());
    }

    /* 
    **根据类名，new一个对象，并返回*/  
    static Object create(Class<?> clazz) throws Exception {
        //如果clazz含有无参数的构造方法，可以如下方式实例化  
        //clazz.newInstance();  
        //根据类名和参数（类型、个数），找到相应的构造方法-下面创建构造方法参数为String的构造方法  
        Constructor<?> con=clazz.getConstructor(String.class);
        //实例化对象  
        Object obj=con.newInstance("哈哈");
        //返回对象
        return obj;
    }  
    /* 
    **根据对象，方法名（字符串），来调用方法*/  
    static void invoke1(Object obj, String methodName)throws Exception{  
        //getDeclaredMethods可以获取类本身（不包括父类）所有方法的名字（包括私有方法）**一般不用这种方法，私有的属性一般不能修改  
        Method[] ms = obj.getClass().getDeclaredMethods();  
        //getMethods可以获取类本身，以及父类的方法的名字，但不包括私有的方法  
        ms = obj.getClass().getMethods();  
        for (Method m : ms) {  
            //如果方法名字匹配，则反射调用方法  
            if (methodName.equals(m.getName()))  
                m.invoke(obj, null);  
        }  
        /* 
        **防止方法重载，可用下面的方式（可以指明参数）--与上面的for循环（无法防止方法重载）一个效果 
        **Method m = obj.getClass().getMethod(methodName, null); 
        **m.invoke(obj, null); 
        */  
    }  
      
    /* 
    **根据类名获取类的属性（一般不直接操作属性）*/  
    static void field(Class clazz) throws Exception {  
        Field[] fs = clazz.getDeclaredFields();  
        //fs = clazz.getFields();  
        for (Field f : fs)  
            System.out.println(f.getName());  
    }  
    /* 
    **根据类名获取类的注解*/  
    static void annon(Class clazz) throws Exception {  
        Annotation[] as = clazz.getAnnotations();  
        for (Annotation a : as)  
            System.out.println(((Member) a).getName());  
    }  
  
}  
