package 基础;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
* @Title: ForTest
* @Description: ConcurrentModificationException  并发修改异常测试
 */
public class ForTest {
	 public static void main(String[] args) {
		  /*
		   * 阿里巴巴开发手册中的遍历移除测试
		   */
//		 iteratorTest();
//		 forEachTest();
		 concurrentTest();
	 }
	 private static void concurrentTest(){
		 /* 初始化集合类*/
			 CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
			 list.add(9);
			 for (int i = 0; i < 100; i++) {
				 list.add(i);
			 }
		 /* 遍历时删除元素*/
		 System.out.println("原list:"+list);
			 for (Integer obj : list) {
			 	//foreach 读取数据 复制对象如果换成int 下面remove(object obj)会换成remove(int index)
				 // 根据下标删除结果不同-》因为list集合删除元素后整体左移填充,当前坐标进入下一个元素时其实就相当于跳过了一个元素
				 if (obj < 10) {
					 /* 这里不会抛出ConcurrentModificationException*/
					 list.remove(obj);
				 }
			 }
		 System.out.println("删除后list:"+list);
	 }
	 private static void forEachTest(){
		 List<String> list = new ArrayList<String>();
		 list.add("1");
		 list.add("2");
		 System.out.println("list1:"+list);
		 for (String item : list) {
			 //如果是1就不会出现
		   if ("2".equals(item)) {
		    list.remove(item);
		    //加上break就不会抛异常
		    break;
		 }
	   } 
		System.out.println("list2:"+list);
	 } 
	 private static void iteratorTest(){
		 List<String> list = new ArrayList<String>();
		 list.add("1");
		 list.add("2");
		 System.out.println("list3:"+list);
		 Iterator<String> iterator = list.iterator();
		 while (iterator.hasNext()) {
			 String item = iterator.next();
			 if ("2".equals(item)) {
				 iterator.remove();
			 }
		 }
		 System.out.println("list3:"+list);
	   } 
	 
	 
}
