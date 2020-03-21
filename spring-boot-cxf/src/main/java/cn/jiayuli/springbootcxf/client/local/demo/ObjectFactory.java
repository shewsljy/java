
package cn.jiayuli.springbootcxf.client.local.demo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cn.jiayuli.springbootcxf.client.local.demo package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayDemo_QNAME = new QName("http://webservice.springbootcxf.jiayuli.cn/", "sayDemo");
    private final static QName _SayDemoResponse_QNAME = new QName("http://webservice.springbootcxf.jiayuli.cn/", "sayDemoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cn.jiayuli.springbootcxf.client.local.demo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayDemo }
     * 
     */
    public SayDemo createSayDemo() {
        return new SayDemo();
    }

    /**
     * Create an instance of {@link SayDemoResponse }
     * 
     */
    public SayDemoResponse createSayDemoResponse() {
        return new SayDemoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayDemo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.springbootcxf.jiayuli.cn/", name = "sayDemo")
    public JAXBElement<SayDemo> createSayDemo(SayDemo value) {
        return new JAXBElement<SayDemo>(_SayDemo_QNAME, SayDemo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayDemoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.springbootcxf.jiayuli.cn/", name = "sayDemoResponse")
    public JAXBElement<SayDemoResponse> createSayDemoResponse(SayDemoResponse value) {
        return new JAXBElement<SayDemoResponse>(_SayDemoResponse_QNAME, SayDemoResponse.class, null, value);
    }

}
