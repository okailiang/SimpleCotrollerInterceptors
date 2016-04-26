package com.utils;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.model.Action;
import com.model.ActionClass;
import com.model.ActionResult;
import com.model.InterceptorBean;
import com.model.InterceptorRef;

public class SaxParseXmlUtil extends DefaultHandler {

	private ActionResult result;
	private Set<ActionResult> results;
	private Action action;
	private ActionClass cla;
	private Set<Action> actions;
	private String preTag;
	private InterceptorBean interceptor;
	private Set<InterceptorBean> interceptors;
	private InterceptorRef interceptorRef;
	private Set<InterceptorRef> interceptorRefs;

	@Override
	public void startDocument() throws SAXException {
		results = new HashSet<ActionResult>();
		actions = new HashSet<Action>();
		interceptors = new HashSet<InterceptorBean>();
		interceptorRefs = new HashSet<InterceptorRef>();
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// 给interceptor各元素赋值
		if (interceptor != null) {
			String data = new String(ch, start, length);
			if (cla == null) {
				if ("name".equals(preTag)) {
					interceptor.setName(data);
				}
			} else {
				if ("name".equals(preTag)) {
					cla.setCname(data);
				} else if ("method".equals(preTag)) {
					cla.setMethod(data);
				}
			}
		} else if (action != null) {// 给action各元素赋值
			String data = new String(ch, start, length);
			if ("name".equals(preTag)) {
				action.setName(data);
			} else if ("cname".equals(preTag)) {
				cla.setCname(data);
			} else if ("method".equals(preTag)) {
				cla.setMethod(data);
			} else if ("rname".equals(preTag)) {
				result.setResultName(data);
			} else if ("type".equals(preTag)) {
				result.setType(data);
			} else if ("value".equals(preTag)) {
				result.setValue(data);
			} else if ("iname".equals(preTag)) {
				interceptorRef.setName(data);
			}
		}
	}

	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attr) throws SAXException {

		if ("interceptor".equals(name)) {
			interceptor = new InterceptorBean();
		} else if ("action".equals(name)) {
			action = new Action();
		} else if ("class".equals(name)) {
			cla = new ActionClass();
		} else if ("result".equals(name)) {
			result = new ActionResult();
		} else if ("interceptor-ref".equals(name)) {
			interceptorRef = new InterceptorRef();
		}
		preTag = name;
	}

	@Override
	public void endElement(String uri, String localName, String name)
			throws SAXException {

		if (interceptor != null && "interceptor".equals(name)) {
			interceptor.setActionClass(cla);
			interceptors.add(interceptor);
			interceptor = null;
			cla = null;
		} else if (action != null && "action".equals(name)) {
			action.setCla(cla);
			action.setResults(results);
			action.setInterceptorRefs(interceptorRefs);
			actions.add(action);
			action = null;
			cla = null;
			results = new HashSet<ActionResult>();
			interceptorRefs = new HashSet<InterceptorRef>();
		} else

		if (result != null && "result".equals(name)) {
			results.add(result);
			result = null;
		} else if (interceptorRef != null && "interceptor-ref".equals(name)) {
			interceptorRefs.add(interceptorRef);
			interceptorRef = null;
		}
		preTag = null;
	}

	public Set<Action> getActions() {
		return actions;
	}

	public Set<InterceptorBean> getInterceptors() {
		return interceptors;
	}

	/**
	 * 
	 * @Description： 解析配置文件
	 * @return
	 * @throws Exception
	 */
	public SaxParseXmlUtil parseXMLFile() throws Exception {
		// 得到SAX解析器的工厂实例
		SAXParserFactory factory = SAXParserFactory.newInstance();
		// 从SAX工厂实例中获得SAX解析器
		SAXParser saxParser = factory.newSAXParser();
		// 把要解析的XML文档转化为输入流，以便DOM解析器解析它
		InputStream is = SaxParseXmlUtil.class.getClassLoader()
				.getResourceAsStream("controller.xml");

		SaxParseXmlUtil handle = new SaxParseXmlUtil();
		// 解析XML文档
		saxParser.parse(is, handle);
		is.close();
		return handle;
	}
}
