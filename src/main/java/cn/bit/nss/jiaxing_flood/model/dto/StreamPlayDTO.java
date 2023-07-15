package cn.bit.nss.jiaxing_flood.model.dto;

import cn.bit.nss.jiaxing_flood.model.vo.StreamVO;

// 和流服务器交互的实体
public class StreamPlayDTO {

    private int code;
    private StreamVO data;
    private String msg;

    public class Data{

    }

    public StreamPlayDTO(int code, StreamVO data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public StreamPlayDTO() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public StreamVO getData() {
        return data;
    }

    public void setData(StreamVO data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
