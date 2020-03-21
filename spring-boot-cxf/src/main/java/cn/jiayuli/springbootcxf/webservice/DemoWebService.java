package cn.jiayuli.springbootcxf.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * ClassName: DemoWebService <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2020/03/16
 */
@WebService
        (
        name = "demoWebService",
        targetNamespace = "http://webservice.springbootcxf.jiayuli.cn/"
)
public interface DemoWebService {

    @WebMethod(action = "sayDemo")
    @WebResult(name = "sayDemoResponse")
    public String sayDemo(
            @WebParam(name = "sayDemoRequest")
                    String name);
}
