这个工程总共有四个类：Book,Borrowbook,Returnbook和TestThread类，其中TestThread是程序的主类。
1、Book类：包含一个amount成员变量，记录书本的库存量；初始化构造方法；getAmount()获取当前库存量；Borrow()判断当前如果库存量为0，则借书线程被阻塞；Return()唤醒当前被阻塞的借书线程；operation(int x)用于执行具体的借还书操作；
2、Borrowbook类：继承自Thread类，包含一个Book对象，对该对象进行借书操作；初始化构造方法；run()方法：执行借书任务；
3、Returnbook类：继承自Thread类，包含一个Book对象，对该对象进行还书操作；初始化构造方法；run()方法：执行还书任务；
4、TestThread类：程序的主类，生成了一个初始化库存量为1的Book对象，生成了5个借书和5个还书线程，并启动这10个线程。