package net.stringAndArray;

public class Sync {
	 public static void main(String[] args) {
	        Counter counter=new Counter();
	        Thread t1=new Thread(new TestThread(counter,1));
	        Thread t2=new Thread(new TestThread(counter,2));
	        t1.start();
	        t2.start();
	         
	    }   
	}
	class TestThread implements Runnable{
	     
	    private Counter counter=null;
	    private int tag=0;
	    public TestThread(Counter counter,int tag) {
	        // TODO Auto-generated constructor stub
	        this.counter=counter;
	        this.tag=tag;
	    }
	    @Override
	    public void run() {
	        // TODO Auto-generated method stub
	        for(int i=0;i<1000;i++){
	            counter.increment();
	            System.out.println(tag+": "+counter.value());
	        }
	    }
	}
	class Counter {
	     
	    private static int c=0;
	     
	    public synchronized void increment(){
	        c++;
	    }
	    public synchronized void decrement(){
	        c--;
	    }
	    public synchronized int value(){
	        return c;
	   }
}