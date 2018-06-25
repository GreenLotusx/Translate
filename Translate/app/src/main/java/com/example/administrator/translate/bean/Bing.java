package com.example.administrator.translate.bean;

/**
 * Created by Administrator on 2018/5/21.
 */

public class Bing {
    /**
     * code : 1
     * msg : success
     * data : {"timestamp":1526882214,"url":"https://cn.bing.com/az/hprichbg/rb/NamibFace_ZH-CN6782882876_1920x1080.jpg"}
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
         * timestamp : 1526882214
         * url : https://cn.bing.com/az/hprichbg/rb/NamibFace_ZH-CN6782882876_1920x1080.jpg
         */

        private int timestamp;
        private String url;

        public int getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(int timestamp) {
            this.timestamp = timestamp;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
