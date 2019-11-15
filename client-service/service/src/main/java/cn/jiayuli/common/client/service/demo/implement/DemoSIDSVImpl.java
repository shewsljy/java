package cn.jiayuli.common.client.service.demo.implement;

import cn.jiayuli.common.client.service.demo.DemoSIDSV;
import cn.jiayuli.common.client.vo.demo.DemoVO;

/**
 * ClassName: DemoSIDSVImpl <br>
 * Description: Demo 实现
 *
 * @author jiayu
 * @version V1.0
 * @date 2019/11/14
 */
public class DemoSIDSVImpl implements DemoSIDSV {

    /**
     * MethodName: queryAppName <br>
     * Description: 查询AppName
     *
     * @param
     * @return cn.jiayuli.common.client.vo.demo.DemoVO
     * @author jiayu
     * @date 2019-11-14
     * @version V1.0
     */
    @Override
    public DemoVO queryAppName() {
        DemoVO demoVO = new DemoVO();
        demoVO.setAppName("Client-Service");
        return demoVO;
    }
}
