package cn.jiayuli.spring.implement;

import cn.jiayuli.spring.interfaces.CompactDisc;
import org.springframework.stereotype.Component;

// @Component 告诉spring创建该bean
@Component
public class SgtPeppers implements CompactDisc {

    private String title = "七里香";
    private String artist = "周杰伦";

    @Override
    public void play(){
        System.out.println("Playing " + title + " by " + artist);
    }
}
