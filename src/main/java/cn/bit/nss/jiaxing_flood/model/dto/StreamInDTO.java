package cn.bit.nss.jiaxing_flood.model.dto;


// 客户端请求的对象体
public class StreamInDTO {

    private String channelId;
    private String deviceId;

    public StreamInDTO(String channelId, String deviceId) {
        this.channelId = channelId;
        this.deviceId = deviceId;
    }

    public StreamInDTO() {
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
}
