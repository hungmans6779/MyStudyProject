package com.thread;

import java.util.concurrent.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/*
 * 參考文件
 * 
 * http://zhidao.baidu.com/question/576333266.html
 * 
 * 如何在一个循环体中 测试当前的程序用了多少秒 或者系统累加一个变量 到一定数值 跳出改程序 
 * 必须是当前循环体有固定的内容 测试的时间为附加的
 * 难点是在 这两个线程（固定内容和测试时间）如何同时进行 并且同时处理
 * 
 * 假设固定内容卡死在这里 我得需要一个条件来跳出本次循环 不能让程序一直处于等待状态
 *
 */
public class ThreadInterruptTest01 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    final ExecutorService exec = Executors.newFixedThreadPool(1);
    Callable call = new Callable(){

      @Override
      public Object call() throws Exception {
        System.out.println("kkk");
        
        Thread.sleep(1000 * 50);
        
        return "線程執行完成 ...";
      }
    };  // end call
    
    

    
    try {
      Future<String> future = exec.submit(call);
      String obj = future.get(1000 * 2 , TimeUnit.MILLISECONDS);  // 任務處理超過時間
      System.out.println("任務成功返回 obj = " + obj);
      
    } catch (InterruptedException e) {
      System.out.println("InterruptedException ！！！");
      e.printStackTrace();
    } catch (ExecutionException e) {
    
      System.out.println("ExecutionException ！！！");
      
      e.printStackTrace();
    } catch (TimeoutException e) {

      System.out.println("TimeoutException ！！！");
      
      e.printStackTrace();
    }

    exec.shutdown();
    
  } // end main
  
  

}
