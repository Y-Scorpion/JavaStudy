# JavaStudy
第一课
### AbstractTest.java
    抽象类继承测试：
        java面向对象三大特性：
            封装、继承、多态
### CalculateTest.java
    java基本运算符号测试：
        *=、%=、|=、<<=、&=、^=

    *=：两数相乘后结果赋值给前一个数

    %=：前数取余后数后赋值给前数

    <<=：左移赋值 二进制运算

    |=：两个二进制对应位都为0时，结果等于0，否则结果等于1；二进制运算

    &=：两个二进制的对应位都为1时，结果为1，否则结果等于0；二进制运算
    
    ^=：两个二进制的对应位相同，结果为0，否则结果为1。二进制运算
### CloneTest.java
    克隆测试类 clone();
        浅克隆的时候如果被克隆对象的变量是值类型那么就将值复制一份给新的对象，
        如果变量是引用对象那就将引用的地址给一份给信的对象。
        这就造成被克隆对象与新的对象的引用型变量指向的是内存中的通一块地址，
        引用型成员变量的值实际上并没有被克隆。
        如果我们想要实现引用类型的成员变量也被成功的克隆，
        那么我们可以通过重写被克隆对象的clone方法，
        同时给引用对象类型实现Cloneable接口

### DataType.java:
    Java语言提供了八种基本类型。
    byte、short、int、long、float、double、boolean、char
    六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型。
    八种包装类Byte、Short、Integer、Long、Float、Double、Boolean、Character
    一种特殊包装类 String 字符串类型
        （1）如果要操作少量的数据用 String
        （2）多线程操作字符串缓冲区下操作大量数据 StringBuffer 线程安全
        （3）单线程操作字符串缓冲区下操作大量数据 StringBuilder

    byte：
        byte 数据类型是8位、有符号的，以二进制补码表示的整数；
        最小值是 -128（-2^7）；
        最大值是 127（2^7-1）；
        默认值是 0；
        byte 类型用在大型数组中节约空间，主要代替整数，因为 byte 变量占用的空间只有 int 类型的四分之一；
        例子：byte a = 100，byte b = -50。
    short：
        short 数据类型是 16 位、有符号的以二进制补码表示的整数
        最小值是 -32768（-2^15）；
        最大值是 32767（2^15 - 1）；
        Short 数据类型也可以像 byte 那样节省空间。一个short变量是int型变量所占空间的二分之一；
        默认值是 0；
        例子：short s = 1000，short r = -20000。
    int：
        int 数据类型是32位、有符号的以二进制补码表示的整数；
        最小值是 -2,147,483,648（-2^31）；
        最大值是 2,147,483,647（2^31 - 1）；
        一般地整型变量默认为 int 类型；
        默认值是 0 ；
        例子：int a = 100000, int b = -200000。
    long：
        long 数据类型是 64 位、有符号的以二进制补码表示的整数；
        最小值是 -9,223,372,036,854,775,808（-2^63）；
        最大值是 9,223,372,036,854,775,807（2^63 -1）；
        这种类型主要使用在需要比较大整数的系统上；
        默认值是 0L；
        例子： long a = 100000L，Long b = -200000L。
        "L"理论上不分大小写，但是若写成"l"容易与数字"1"混淆，不容易分辩。所以最好大写。
    float：
        float 数据类型是单精度、32位、符合IEEE 754标准的浮点数；
        float 在储存大型浮点数组的时候可节省内存空间；
        默认值是 0.0f；
        浮点数不能用来表示精确的值，如货币；
        例子：float f1 = 234.5f。
    double：
        double 数据类型是双精度、64 位、符合 IEEE 754 标准的浮点数；
        浮点数的默认类型为 double 类型；
        double类型同样不能表示精确的值，如货币；
        默认值是 0.0d；

### ExtendsTest.java ExtendsTest2.java
    继承类测试,目的是测试多态以及继承内重载和重写选择优先级
        重载方法的优先级：
            a.先匹配参数个数
            b.参数类型的最佳匹配：直接所属类
            c.如果没有找到直接所属类，会发生向上转型，直至找父类参数，直观上查找顺序为：包装类-》父类-》接口（不一定准确，《深入理解Java虚拟机》有更详细的描述）
            d.如果向上转型仍无法匹配，则查找可变参数列表
            e.以上无法匹配返回找不到方法错误。
        重写方法：
            super():子类重写调用父类函数
            this关键字:谁调用指向谁
            
### FinalTest.java
    final关键字测试
        final修饰类：该类无法被继承 ，编译报错
        final修饰方法：该方法无法被重写，编译报错
        final修饰变量：该变量引用指向无法修改，编译报错

### ForTest.java
        ConcurrentModificationException  并发修改异常测试
        jdk1.2就出现的问题,当方法检测到对象的并发修改，但不允许这种修改时，抛出此异常。
        这个异常在单线程和多线程运行环境都可以产生。
    单线程解决方式
        1、将ArrayList集合改为CopyOnWriteArrayList（HashMap替换为ConcurrentHashMap）
        2、加 break; 感觉不靠谱
        3、应用迭代器进行删除操作 （多线程不安全，已就报错）

### InetAddressTest.java InetSocketAddressTest.java
    InetAddressTest
        封装IP及DNS
    InetSocketAddressTest
        封装端口,用于Scoket绑定用
### IoTest.java
    IO流简单测试
        字符流
        字节流
        File对象操作
### KeyWord.java:
    java关键字：
        class               extends             implements              interface
        import              package             break                   case
        continue            default             do                      if
        else                for                 return                  switch
        while               false               true                    null
        boolean             byte                char                    short
        int                 long                float                   double
        try                 catch               throw                   throws
        finally             abstract            fianl                   native
        private             protected           public                  static
        synchronized        transient           volatile                instanceof
        new                 super               void                    assert
        enum                goto                const                   this

        class：
            java类定义关键字

        extends：
            继承类或者继承接口的关键字。

        implements：
            实现接口的关键字。

        interface：
            定义接口的关键字。

        import：
            java导入库关键字

        package：
            java包路径关键字

        break,continue：
            break跳出结束循环,continue结束当前循环进入下一次循环

        switch,case,if,else:
            java条件判断关键字

        for,while,do:
            java循环关键字

        return：
            java返回关键字,可用于返回返回值,或结束方法
        
        false,true:
            布尔类型关键字

        default：
            jdk8中新加关键字,用于在接口中默认实现

        null：
            空值（保留字）

        boolean,byte,char,short,int,long,float,double：
            java八大基本类型关键字

        try,catch,finally,throws:
            java处理异常关键字 try检测异常 catch捕获，finally不管是否发生异常，都会执行的语句块,throws是将异常抛出
        
        throw：
            声明一个异常

        abstract：
            定义抽象类或者抽象方法的关键字。

        fianl：
            最终修饰符,修饰基本数据类型为常量,修饰对方,则无法修改引用对象地址,修饰方法无法重写,修饰类无法继承；

        native：
            调用C或者C++的代码；

        private,protected,public：
            java访问权限修饰符关键字

        static：
            java静态修饰关键字

        synchronized：
            同步线程锁

        volatile：
            volatile关键字修饰的变量在多线程中保持同步

        transient：
            瞬时的   IO流的对象流 变量修饰表示不被序列化

        instanceof：
            用来确定对象所属的类
        
        new：
            实例化对象的关键字。
        
        super:
            用来表示父类对象

        void：
            空返回数据类型的关键字。

        enum：
            定义枚举的关键字。

        assert：
            断言,测试用类似于if不可用于生产环境

        this:
            用来表示对象本身

        goto,const:
            保留关键字

### ListTest.java
    list 集合操作测试
        list集合遍历方法
        list集合修改遍历异常 在ForTest.java有介绍
        list集合常用方法
        JDK1.8新特性 List  Stream()操作       
### MapTest.java
    map集合操作测试
        map常见放入遍历方式
### PackagingTest.java
    java对象封装测试
### PolymorphicTest.java
    java对象多态测试
### ReflectTest.java ReflectTest2.java
    java反射测试 --相当有用
        对象.class  Class.forNmae("对象") 两种创建方式
        getClasses()->返回类定义的公共的内部类,以及从父类、父接口那里继承来的内部类
        getDeclaredClasses()->返回类中定义的公共、私有、保护的内部类
        Class.getModifiers()->获取Class对应类(或者接口)的修饰符,返回修饰符的二进制值 Modifier将获取到的二进制值转换为字符串。
        Class.getDeclaringClass() -》返回一个成员内部类所在的类的Class
        Class.getConstructors()-》返回所有**共有**的构造方法的Constructor对象的数组
        Class.getDeclaredConstructors() -》返回**所有**的构造方法的Constructor对象的数组的Constructor对象的数组
        Class.getFields()-》返回此 Class 对象所表示的类或接口的所有公有字段数组(Field 对象数组)
        Class.getDeclaredFields()-》 返回此 Class 对象所表示的类或接口中所有声明的字段数组(Field对象数组)。
        Class.newInstance()-》创建此 Class 对象所表示的类的一个新实例。
        Class.getMethods()-》返回一个包含某些 Method 对象的数组，这些对象反映此 Class 对象所表示的类或接口的公共 member 方法
        Class.getDeclaredMethods()-》返回 Method 对象的一个数组，这些对象反映此 Class 对象表示的类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
        Constructor.invoke ->应用对象内的方法（需创建实例对象newInstance()）
        method.setAccessible(true) ->设置或取消访问检查，以达到访问私有对象的目的;
        Constructor.getDeclaringClass() -》返回一个构造器所在的类的Class
        Field()->表示该 Class 的成员变量
        Method()->表示该 Class 的成员方法
            java.lang.reflect.Field.getDeclaringClass() -》返回一个字段所在的类的Class
            java.lang.reflect.Method.getDeclaringClass() -》返回一个方法所在的类的Class
            java.lang.reflect.
### SetTest.java
    set集合去重方法： 
        set()-》利用set集合不允许元素重复去重
        hashSetTest() -》利用hashSet去重
    对象排序两种形式:   
        定义一个类实现Comparator 接口，覆盖compare方法
        对象实现Comparable接口，重写覆盖compareTo方法

### StaticTest.java
    构造块静态方法测试
        创建对象时构造器的调用顺序是：先初始化静态成员，然后调用父类构造器，再初始化非静态成员，最后调用自身构造器。

### StringTest.java
    String字符串对象测试
        test1()-》测试String，StringBuffer，StringBuilder累加性能
        test3()-》测试String对比
### SuperTest.java
    测试继承父类创建对象运行流程
        创建对象时构造器的调用顺序是：先初始化静态成员，然后调用父类构造器，再初始化非静态成员，最后调用自身构造器。
### TestLog.java：
    log4j2.xml 整合配置 日志输出相对println()更加详细
    java程序入口Main方法
    1.需要理解java的加载和执行  javac xx.java  java xxx
    2.java开发环境配置  jdk（jre）安装和配置
    3.编写程序 输出hellworld
    4.java注释的使用和作用
    5.public class 和class的区别

