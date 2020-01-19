package com.fang.thread.xianChengChi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 *
 * 并发concurrency
 *      值的是程序的结构，壁橱里并行的能力。如果一个系统称之为并发系统，择表示该系统采用了至此那个并发升职记模式，
 *      所以并发并不是指多个线程同时执行，他指定是一种人为设计的程序结构，可以处理多线程的能力。
 *
 * 并行parallelism
 *      只多个操作同事执行，判断程序是否处于并行状态，就看同样一个时刻是否有一个已送的工作单元在运行
 *      单线程是永远无法达到并行状态的。
 *
 *  高并发是指我们设计的程序，可以支持海量的任务在同一时间段内同事执行。
 *
 *  高并发标准：
 *      1、QPS 每秒响应的http请求数量，QPS不等于并发量，并发数是指某时刻同事到达服务器的请求数量。
 *      2、吞吐量 单位时间内可以处理的请求数。
 *      3、平均响应时间，系统对应请求作出响应的平均时间。
 *      4、并发用户数量，系统在正常运行情况下，可以承载的用户数量。
 *
 *      QPS = 并发数 / 平均响应时间    （每秒钟可以处理的请求数量）
 *
 *  提高系统并发能力的两种方式：
 *      1、垂直扩展，提升单机处理能力。
 *          1、增强单机硬件性能。
 *          2、提升单机架构性能。   如：缓存、异步方式、非关系型数据库，提高程序的加载性能
 *
 *          缺点：机器性能是有限的。
 *
 *      2、水平扩展
 *          系统集群【分层架构、Nginx反向代理分担web应用服务器的压力，数据层主从复制，读写分离，分库分表，减轻数据服务器的压力】
 *
 *      3、线程池
 *          优点：
 *              1、线程的创建和销毁是需要耗费资源的，使用线程池可以有效的减少创建和销毁线程的次数，每个工作线程都可以重复使用。
 *              2、可以根据系统的承受能力，调整线程池中工作线程的数量，防止因为小号过道内存导致服务器崩溃。
 *
 *          工作流程：
 *              当提交一个任务时，线程池会创建一个新的线程执行任务，直到当前线程池中的线程数等于corePoolSize线程池的大小。
 *              如果当前线程数量已经到达了corePoolSize，线程提交的任务被保存到阻塞队列中，等待获取执行完成的任务释放线程，从而执行等待任务。
 *              如果阻塞队列也满了，那就再创建新的线程去执行任务，知道线程池中的线程数达到maxPoolSize，这时候如果再有任务来，只能执行拒绝方案。
 *
 *          ThreadPoolExecutor类
 *          java.util.concurrent.ThreadPoolExecutor类是java描述线程池的核心类。
 *          核心参数：
 *              corePoolSize 核心池大小
 *              maxmumPoolSize 线程池最大线程数，线程池中线程数量的上限。
 *
 *          ThreadPoolExecutor 提供了动态修改线程第容量的方法
 *              setCorePoolSize() 修改corePoolSize
 *              setMaxmumPoolSize() 修改maxmumPoolSize
 *
 *              keepAliveTime
 *                  corePoolSize 5，线程池中有6个线程，如果某个线程的闲置时间达到了10s,则释放该线程。
 *                  直到线程池中的线程数量小于等于corePoolSize，keepAliveTime失效。
 *
 *              unit 参数keepAliveTime的时间单位，TimeUnit中有7个常量来表示7中不同的时间单位。
 *                  TimeUnit.DAYS 天
 *                  TimeUnit.HOURS 小时
 *                  TimeUnit.MINUTES 分钟
 *                  TimeUnit.SECOUNDS 秒
 *                  TimeUnit.MILLSECOUNDS 毫秒
 *                  TimeUnit.MICROSECONDS 微秒
 *                  TimeUnit.NANOSECONDS  纳秒
 *
 *              workQueue 一个阻塞队列，用来存储等待执行的任务。一般阻塞队列有以下集中选择：
 *                  ArrayBlockingQueue 基于数组的先进先出队列，创建时必须指定大小。
 *                  LinkedBlockQueue 基于链表的先进先出队列，如果和创建时没有指定大小，默认
 *                      Integer.MAX_VALUE
 *                  SynchronousQueue 不会保存提交的任务，而是直接创建一个新的线程来执行新的任务。
 *                  PriorityBlockingQueue 具有优先级的阻塞队列。
 *
 *              threadFactory 线程工厂，用来创建线程。
 *              handler 表示拒绝处理任务所采取的策略，有以下四种取值。
 *                  ThreadPoolExecutor.AbortPolicy 丢弃任务并且抛出异常。
 *                  ThreadPoolExecutor.DiscardPolicy 丢弃任务但是不抛出异常。
 *                  ThreadPoolExecutor.DiscardOldestPolicy 丢弃队列最前面的任务，然后重新执行当前任务。
 *                  ThreadPoolExecutor.CallerRunsPolicy 由调用线程处理该任务。
 *
 *          线程池的状态
 *              RUNNING 该状态下的线程池可以接受新的任务，并且处理阻塞队列中的任务。
 *              SHUTDOWN 该状态下的线程出不接受新的任务，但是会处理阻塞队列中的任务。
 *              STOP 该状态下的线程池不接收新的任务，也不会处理阻塞队列中的任务，并且会中断正在运行的任务。
 *              TIDYING 该状态表示线程池对线程进行整理优化。
 *              TERMINATED 该状态表示线程池停止工作。
 *
 *
 *         ThreadPoolExecutor 类中常用的方法
 *              execute() 是一个核心方法，通过该方法可以向线程池提交一个任务，由线程池去安排执行。
 *              submit() ExecutorService接口中声明的方法，也是用来向线程池提交任务的，和execute()方法不同，可以返回执行任务的结果。
 *              shutdown() 关闭线程池，不会立即终止线程池，而是等待阻塞队列中的任务全部执行完毕之后在终止，同事也不胡再接收新的任务。
 *              shutdownNow() 立即终止线程池，并中断正在执行的任务，并且清空阻塞队列，返回尚未执行的任务。
 *
 *         erxecute内部实现
 *              1、通过workCountof()方法获取当前线程池中的线程数；
 *              如果小于setPoolSize,就通过addWorker()创建线程并执行该任务，否则，将该任务放入阻塞队列。
 *              2、如果能够成功放入道阻塞队列中，若当前线程池是非RUNNING状态，择将该任务从阻塞队列中移除，然后执行reject()拒绝处理改任务。
 *              如果当前线程池处于RUNNING状态，则需要再次检查线程池，如果有空闲的线程则执行该任务。
 *              3、如果不能将任务放入阻塞队列汇总，说明阻塞队列已满，就通过addWorker()方法创世创建新的线程来执行该任务，如果addWorker()方法失败，
 *              则表示当前线程池中的线程数已经达到了maxmumPoolSize，执行reject()拒绝处理该任务。
 *
 *      总结：
 *          当提交一个任务时，线程池会创建一个新的线程去执行该任务，知道当前线程数等于corePoolSize，如果当前线程数为corePoolSize，继续提交的任务会被存入阻塞队列，等待被执行；
 *          如果阻塞队列满了，那就创建一个新的线程来执行当前任务，直到线程池中线程数等于maxmumPoolSize，这时如果再有任务提交过了，只能执行reject()方法来拒绝。
 *
 *          实际开发中不提倡直接实例化ThreadPoolExecutor, 而是通过Executors类提供的静态方法来创建线程池
 *
 *
 */
public class GaoBingFaTest {
    public static void main(String[] args) {
        /**
         * 线程池大小
         * 上限
         * 空闲线程存活时间
         * 单位
         * 阻塞队列（基于数组的先进先出队列，容量为5，只能装Runnable类型的线程）
         */
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 300,TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        // 创建任务交给线程池去运行
        for (int i = 0; i < 10; i++) {
            MyTask task = new MyTask(i);
            executor.execute(task);
            System.out.println("线程池中的线程数："+executor.getCorePoolSize()+"，队列中等待执行的任务数："+executor.getQueue().size()+"，已执行完成的任务数："+executor.getCompletedTaskCount());
        }
        executor.shutdown();

    }
}
class MyTask implements Runnable{
    private int id;
    public MyTask(int id){
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("正在执行task："+id);
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task" + id + "执行完毕");
    }
}