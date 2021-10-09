package cn.jiayuli.allsome.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserListVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户list
     */
    @JacksonXmlElementWrapper(localName = "userItems")
    @JacksonXmlProperty(localName = "userItem")
    @JsonProperty("userItems")
    private List<UserVO> userVOList;

}
