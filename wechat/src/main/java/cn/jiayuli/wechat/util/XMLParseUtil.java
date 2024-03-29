/**
 * 对公众平台发送给公众账号的消息加解密示例代码.
 * 
 * @copyright Copyright (c) 1998-2014 Tencent Inc.
 */

// ------------------------------------------------------------------------

package cn.jiayuli.wechat.util;

import cn.jiayuli.wechat.constant.WXConstant;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * XMLParse class
 *
 * 提供提取消息格式中的密文及生成回复消息格式的接口.
 */
public class XMLParseUtil {

	/**
	 * @param xml 要转换的xml字符串
	 * @return 转换成map后返回结果
	 * @throws Exception
	 */
	public static Map<String, String> xmlToMap(String xml) throws Exception {
		Map<String, String> respMap = new HashMap<>();
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new ByteArrayInputStream(xml.getBytes(WXConstant.CHARSET_UTF8)));
		Element root = doc.getRootElement();
		xmlToMap(root, respMap);
		return respMap;
	}

	/**
	 * 递归转换
	 *
	 * @param tmpElement
	 * @param respMap
	 * @return
	 */
	private static Map<String, String> xmlToMap(Element tmpElement, Map<String, String> respMap) {
		if (tmpElement.isTextOnly()) {
			respMap.put(tmpElement.getName(), tmpElement.getText());
			return respMap;
		}
		Iterator<Element> eItor = tmpElement.elementIterator();
		while (eItor.hasNext()) {
			Element element = eItor.next();
			xmlToMap(element, respMap);
		}
		return respMap;
	}

	/**
	 * map对象转行成xml
	 *
	 * @param map
	 * @return
	 * @throws IOException
	 */
	public static String mapToXml(Map<String, Object> map) throws IOException {
		Document d = DocumentHelper.createDocument();
		Element root = d.addElement(WXConstant.ROOT_XML);
		mapToXml(root, map);
		StringWriter sw = new StringWriter();
		OutputFormat format = new OutputFormat();
		format.setSuppressDeclaration(true);
		XMLWriter xw = new XMLWriter(sw,format);
		xw.setEscapeText(false);
		xw.write(d);
		return sw.toString();
	}


	/**
	 * 递归转换
	 *
	 * @param root
	 * @param map
	 * @return
	 * @throws IOException
	 */
	private static Element mapToXml(Element root, Map<String, Object> map) throws IOException {
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (entry.getValue() instanceof Map) {
				Element element = root.addElement(entry.getKey());
				mapToXml(element, (Map<String, Object>) entry.getValue());
			} else {
				root.addElement(entry.getKey()).addText(entry.getValue().toString());
			}
		}
		return root;
	}


//	/**
//	 * 提取出xml数据包中的加密消息
//	 * @param xmltext 待提取的xml字符串
//	 * @return 提取出的加密消息字符串
//	 * @throws AesException
//	 */
//	public static Object[] extract(String xmltext) throws AesException     {
//		Object[] result = new Object[3];
//		try {
//			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//			dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
//			dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
//			dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
//			dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
//			dbf.setXIncludeAware(false);
//			dbf.setExpandEntityReferences(false);
//			DocumentBuilder db = dbf.newDocumentBuilder();
//			StringReader sr = new StringReader(xmltext);
//			InputSource is = new InputSource(sr);
//			Document document = db.parse(is);
//
//			Element root = document.getDocumentElement();
//			NodeList nodelist1 = root.getElementsByTagName("Encrypt");
//			NodeList nodelist2 = root.getElementsByTagName("ToUserName");
//			result[0] = 0;
//			result[1] = nodelist1.item(0).getTextContent();
//			result[2] = nodelist2.item(0).getTextContent();
//			return result;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new AesException(AesException.ParseXmlError);
//		}
//	}
//
//	/**
//	 * 生成xml消息
//	 * @param encrypt 加密后的消息密文
//	 * @param signature 安全签名
//	 * @param timestamp 时间戳
//	 * @param nonce 随机字符串
//	 * @return 生成的xml字符串
//	 */
//	public static String generate(String encrypt, String signature, String timestamp, String nonce) {
//
//		String format = "<xml>\n" + "<Encrypt><![CDATA[%1$s]]></Encrypt>\n"
//				+ "<MsgSignature><![CDATA[%2$s]]></MsgSignature>\n"
//				+ "<TimeStamp>%3$s</TimeStamp>\n" + "<Nonce><![CDATA[%4$s]]></Nonce>\n" + "</xml>";
//		return String.format(format, encrypt, signature, timestamp, nonce);
//
//	}
}
