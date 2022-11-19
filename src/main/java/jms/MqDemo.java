//package jms;
//
//import javax.jms.Queue;
//import javax.jms.QueueConnectionFactory;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//
///**
// * @author haishen
// * @date 2019/8/30
// */
//public class MqDemo {
//
//    public static void main(String[] args) throws NamingException {
//
//        InitialContext initialCtx = new InitialContext();
//        QueueConnectionFactory queueConnFactory = (QueueConnectionFactory) initialCtx.lookup("primaryQCF");
//        Queue purchaseQueue = (Queue) initialCtx.lookup("Purchase_Queue");
//        Queue returnQueue = (Queue) initialCtx.lookup("Return_Queue");
//
//    }
//
//}
