package cn.jiayuli.springbootcxf.service.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * ClassName: DemoSoapService <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2020/03/16
 */
@WebService(name = "demoSoapService",
        targetNamespace = "http://soap.service.springbootcxf.jiayuli.cn"
)
public interface DemoSoapService {

    @WebMethod
    @WebResult(name = "returnDemoName")
    public String sayDemo(@WebParam(name = "demoName") String name);
}
