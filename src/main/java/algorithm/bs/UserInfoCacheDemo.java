//package algorithm.bs;
//
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * @author haishen
// * @date 2019/8/22
// */
//public class UserInfoCacheDemo {
//    //评测题目:
//// 构建一个本地缓存，缓存UserInfo用户的信息，如果在从缓存中获取数据时，发现缓存上次更新时间超过30分钟， 则需要自动更新一次缓存，考虑并发场景
//// 补充：
//// 1 UserInfo结构
//// 	public class UserInfo { private String userId; private String userName; private String cardNo; //省略其它信息和getter 和setter }
//// 2 已有方法
//// 	public List<UserInfo> getUserInfoFromDb(Pagin pagin)；//从数据库获取User信息
//// 完成下面的代码 //: TODO 可自行定义需要的变量
//
//    /**
//     初始化用户信息缓存 */
//    public void initUserInfoCache(){
//        //: TODO 完成此处的代码
//    }
//    /**
//     根据用户id获取用户信息 */
//    public UserInfo getUserInfoFromCacheById(String userId){
//        //: TODO 完成此处的代码
//    }
//    /**
//     更新用户的缓存*/
//    public void updateUserInfoCache(){
//        //: TODO 完成此处的代码
//    }
//
//    public class UserInfo {
//        private String userId;
//        private String userName;
//        private String cardNo;
//
//        public String getUserId() {
//            return userId;
//        }
//
//        public void setUserId(String userId) {
//            this.userId = userId;
//        }
//
//        public String getUserName() {
//            return userName;
//        }
//
//        public void setUserName(String userName) {
//            this.userName = userName;
//        }
//
//        public String getCardNo() {
//            return cardNo;
//        }
//
//        public void setCardNo(String cardNo) {
//            this.cardNo = cardNo;
//        }
//    }
//
//}
