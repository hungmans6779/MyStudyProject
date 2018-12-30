package com.classResolver.client;

import java.io.File;

import com.classResolver.bean.Bar;
import com.classResolver.bean.Foo;
import com.classResolver.container.Container;

/*
 *  範例說明
 *  
 *  ClassResolver
 *  這個小的DI容器，JAXB的例子演示了，如何能夠避免將列表中的類的前期，而不是​​懶洋洋地加載類。
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args)  throws Exception {

      Container c = Container.load(new File("class-resolver.xml"));
      
      System.out.println("************************************************************************");
      System.out.println("取得所要的物件前...\n\n");
     
      Object o = c.get("foo");
      
      System.out.println("\n");
      System.out.println( Main.class.getName()+",main() execute...");
      if(o instanceof Foo){
        Foo foo = (Foo)o;
        System.out.println("foo.a  = "+foo.a);
        System.out.println("foo.b  = "+foo.b);
        System.out.println("foo.c  = "+foo.c);
        System.out.println("foo.c.getX() = "+((Bar)foo.c).getX());
        System.out.println("foo.c.getY() = "+((Bar)foo.c).getY());
      }else if(o instanceof Bar){
        Bar bar = (Bar)o;
        System.out.println("bar.getX() = "+bar.getX());
        System.out.println("bar.getY() = "+bar.getY());
      }else{
        System.out.println("未定義");  
      }
      System.out.println("\n");
      System.out.println("************************************************************************");

    }

}
