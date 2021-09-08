package spring;

import cn.jiayuli.spring.config.CDPlayerConfig;
import cn.jiayuli.spring.interfaces.CompactDisc;
import cn.jiayuli.spring.interfaces.MediaPlayer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeanNull() {
        Assert.notNull(cd,"Java 实现 Spring 自动创建，扫描 bean 失败!");
        cd.play();
    }
    @Test
    public void play() {
        Assert.notNull(player,"Java 实现 Spring 自动创建，扫描 bean 失败!");
        player.play();
    }
}
