package lock;

/**
 * @author haishen
 * @date 2018/7/15
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private synchronized static void method() {
    }
}

/**
 * 用javap -v SynchronizedDemo.class 查看到的字节码文件：

 ➜  lock git:(master) ✗ javap -v SynchronizedDemo.class


 Classfile /Users/haishen/study/java-demo/target/classes/lock/SynchronizedDemo.class
 Last modified 2018-12-19; size 579 bytes
 MD5 checksum b9c386a4930ed3e9efce82017038dd4f
 Compiled from "SynchronizedDemo.java"
 public class lock.SynchronizedDemo
 minor version: 0
 major version: 52
 flags: ACC_PUBLIC, ACC_SUPER
 Constant pool:
 #1 = Methodref          #4.#23         // java/lang/Object."<init>":()V
 #2 = Class              #24            // lock/SynchronizedDemo
 #3 = Methodref          #2.#25         // lock/SynchronizedDemo.method:()V
 #4 = Class              #26            // java/lang/Object
 #5 = Utf8               <init>
 #6 = Utf8               ()V
 #7 = Utf8               Code
 #8 = Utf8               LineNumberTable
 #9 = Utf8               LocalVariableTable
 #10 = Utf8               this
 #11 = Utf8               Llock/SynchronizedDemo;
 #12 = Utf8               main
 #13 = Utf8               ([Ljava/lang/String;)V
 #14 = Utf8               args
 #15 = Utf8               [Ljava/lang/String;
 #16 = Utf8               StackMapTable
 #17 = Class              #15            // "[Ljava/lang/String;"
 #18 = Class              #26            // java/lang/Object
 #19 = Class              #27            // java/lang/Throwable
 #20 = Utf8               method
 #21 = Utf8               SourceFile
 #22 = Utf8               SynchronizedDemo.java
 #23 = NameAndType        #5:#6          // "<init>":()V
 #24 = Utf8               lock/SynchronizedDemo
 #25 = NameAndType        #20:#6         // method:()V
 #26 = Utf8               java/lang/Object
 #27 = Utf8               java/lang/Throwable
 {
 public lock.SynchronizedDemo();
 descriptor: ()V
 flags: ACC_PUBLIC
 Code:
 stack=1, locals=1, args_size=1
 0: aload_0
 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 4: return
 LineNumberTable:
 line 7: 0
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 0       5     0  this   Llock/SynchronizedDemo;

 public static void main(java.lang.String[]);
 descriptor: ([Ljava/lang/String;)V
 flags: ACC_PUBLIC, ACC_STATIC
 Code:
 stack=2, locals=3, args_size=1
 0: ldc           #2                  // class lock/SynchronizedDemo
 2: dup
 3: astore_1
 4: monitorenter
 5: aload_1
 6: monitorexit
 7: goto          15
 10: astore_2
 11: aload_1
 12: monitorexit
 13: aload_2
 14: athrow
 15: invokestatic  #3                  // Method method:()V
 18: return
 Exception table:
 from    to  target type
 5     7    10   any
 10    13    10   any
 LineNumberTable:
 line 9: 0
 line 10: 5
 line 11: 15
 line 12: 18
 LocalVariableTable:
 Start  Length  Slot  Name   Signature
 0      19     0  args   [Ljava/lang/String;
 StackMapTable: number_of_entries = 2
 frame_type = 255 //full_frame
          offset_delta = 10
                  locals = [ class "[Ljava/lang/String;", class java/lang/Object ]
        stack = [ class java/lang/Throwable ]
        frame_type = 250 //chop
        offset_delta = 4
 }
 SourceFile: "SynchronizedDemo.java"
 */
