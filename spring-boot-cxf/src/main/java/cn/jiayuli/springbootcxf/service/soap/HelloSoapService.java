package cn.jiayuli.springbootcxf.service.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * ClassName: HelloService <br>
 * Description: TODO
 *
 * @author jiayu
 * @version V1.0
 * @date 2020/03/15
 */
@WebService(name = "helloSoapService",// 暴露服务名称
        targetNamespace = "http://soap.service.springbootcxf.jiayuli.cn"// 命名空间,一般是接口的包名倒序
)
public interface HelloSoapService {

    @WebMethod
    @WebResult(name = "returnUserName")// 设置返回值名称
    public String sayHello(@WebParam(name = "userName") String name);// 设置请求参数
}
