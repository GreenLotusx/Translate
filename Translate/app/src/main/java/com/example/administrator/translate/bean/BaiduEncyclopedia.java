package com.example.administrator.translate.bean;


/**
 * Created by Administrator on 2018/5/27.
 */

public class BaiduEncyclopedia {

    /**
     * code : 1
     * msg : success
     * data : {"content":"河源，别称槎城，为广东省地级市。位于广东省东北部、东江中上游，东接梅州市、汕尾市，南邻惠州市，西连韶关市、惠州市，北与江西省赣州市交界。全市面积1.58万平方公里。河源是京九铁路进入广东省的第一个城市，又是广东省拥有铁路最长的城市；京九铁路、广梅汕铁路、105国道、205国道、粤赣高速构筑了河源四通八达的交通网络，是粤东北重要的交通枢纽。1988年1月7日撤县设市，1992年8月河源市经国务院批准列入沿海经济开放区，成为既可享受山区优惠政策，又可享受沿海开放区优惠政策的地区。2015年9月拥有地方立法权。河源是客家人聚居地，是客家文化的重要起源地之一，也是岭南文化的重要发祥地之一，有\u201c..."}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * content : 河源，别称槎城，为广东省地级市。位于广东省东北部、东江中上游，东接梅州市、汕尾市，南邻惠州市，西连韶关市、惠州市，北与江西省赣州市交界。全市面积1.58万平方公里。河源是京九铁路进入广东省的第一个城市，又是广东省拥有铁路最长的城市；京九铁路、广梅汕铁路、105国道、205国道、粤赣高速构筑了河源四通八达的交通网络，是粤东北重要的交通枢纽。1988年1月7日撤县设市，1992年8月河源市经国务院批准列入沿海经济开放区，成为既可享受山区优惠政策，又可享受沿海开放区优惠政策的地区。2015年9月拥有地方立法权。河源是客家人聚居地，是客家文化的重要起源地之一，也是岭南文化的重要发祥地之一，有“...
         */

        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
