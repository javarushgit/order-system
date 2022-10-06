package com.taslitsky.threads;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args ) throws InterruptedException {

        Object o = new Object();
        String ping = "ping";
        String pong = "pong";
        //String pung = "pung";
        Thread pingThread = new Thread(new PingPong(ping, o));
        Thread pongThread = new Thread(new PingPong(pong, o));

        pingThread.start();
        pongThread.start();

        Thread.sleep(1000);
        pongThread.interrupt();
        pingThread.interrupt();
       // Thread pungThread = new Thread(new PingPong(pung, o));

//        ExecutorService service = Executors.newFixedThreadPool(3);
//        service.submit(pingThread);
//        service.submit(pongThread);
//       // service.submit(pungThread);
//
//        Thread.sleep(2000);
//
//        service.shutdownNow();

//        BlockingList blockingList = new BlockingList();
//
//        Printer printer = new Printer(blockingList);
//        Writer writer = new Writer(blockingList);
//
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(printer);
//        executorService.submit(writer);
//
//
//        Thread.sleep(5000);
//
//        executorService.shutdownNow();




    }
}





class PingPong implements Runnable {
    private String word;
    private Object lockObject;


    public PingPong(String word, Object lockObject) {
        this.word = word;
        this.lockObject = lockObject;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lockObject) {
                System.out.println(word);
                lockObject.notifyAll();
                try {
                    Thread.sleep(500);
                    lockObject.wait();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}


class BlockingList {
    private List<Integer> list  = new ArrayList<>();

    public synchronized void add(Integer i) {
        list.add(i);
        notifyAll();
    }

    public synchronized Integer get() {
        while (list.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return list.remove(0);
    }
}


class Printer implements Runnable {
    private BlockingList blockingList;

    public Printer(BlockingList blockingList) {
        this.blockingList = blockingList;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(blockingList.get());
        }
    }
}

class Writer implements Runnable {

    private BlockingList blockingList;

    public Writer(BlockingList blockingList) {
        this.blockingList = blockingList;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 20; i++) {
                blockingList.add(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}


