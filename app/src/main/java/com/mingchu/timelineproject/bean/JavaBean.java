package com.mingchu.timelineproject.bean;

import java.util.List;

/**
 * Created by wuyinlei on 2017/5/10.
 */

public class JavaBean extends BaseEntity {




    /**
     * datas : [{"time":"2017.05.05-16:20","type":"0","address":""},{"time":"2017.05.05-19:51","type":"1","address":"浙江省杭州市萧山中部公司 已收件"},{"time":"2017.05.05-20:55","type":"1","address":"浙江省杭州市萧山中部公司 已打包"},{"time":"2017.05.05-22:59","type":"1","address":"浙江省杭州市萧山中部公司 已发出,下一站 杭州转运中心"},{"time":"2017.05.05-20:55","type":"1","address":"杭州转运中心公司 已收入"},{"time":"2017.05.05-22:09","type":"1","address":"杭州转运中心公司 已发出,下一站 北京转运公司"},{"time":"2017.05.06-20:55","type":"1","address":"北京转运公司中心 已收入"},{"time":"2017.05.06-21:55","type":"1","address":"北京转运公司中心 已发出,下一站 北京市朝阳区大中华区"},{"time":"2017.05.07-05:55","type":"2","address":"北京市朝阳区酒仙桥 已收入"},{"time":"2017.05.07-06:55","type":"2","address":"北京市朝阳区酒仙桥公司 派件中 电话:112234124"},{"time":"2017.05.07-13:55","type":"3","address":"北京市朝阳区酒仙桥公司 已经签收 签收人:邮件收发章"}]
     * message : 请求成功
     * errorCode : 0
     */

    private String message;
    private String errorCode;
    private List<DatasBean> datas;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * time : 2017.05.05-16:20
         * type : 0
         * address :
         */

        private String time;
        private String type;  //0-发出  1-转运  2-派件  3-签收
        private String address;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        /**
         * 获取日期和时间    这里我只是简单的分隔  真实数据就是一个时间戳   然后自己去进行设置
         *
         * @return 日期和时间
         */
        public String[] getDataAndTime() {

            String[] split = getTime().split("-");

            return split;
        }

    }

}
