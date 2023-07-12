package cn.bit.nss.jiaxing_flood.model.entity;

public class Result {

    private Integer code;

    private String desc;

    private Object Data;

    public Result() {
    }

    public Result(Integer code, String desc, Object data) {
        this.code = code;
        this.desc = desc;
        Data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }
}
