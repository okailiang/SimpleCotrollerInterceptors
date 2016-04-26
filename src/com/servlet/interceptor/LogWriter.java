package com.servlet.interceptor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.model.LogBean;

/**
 * <p>
 * Class:LogWriter
 * </p>
 * <p>
 * Description:通过动态代理实现登录日志记录
 * </p>
 * <p>
 * Copyright: USTC
 * </p>
 * 
 * @author Oukailiang
 * @version 1.0.0
 */
public class LogWriter {

	/**
	 * @Description：
	 * @param proxy
	 * @param method
	 * @param args
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws Throwable
	 */
	public String log(LogBean logbean) throws FileNotFoundException,
			IOException, JDOMException {
		// 记录访问action信息
		createLogXml(logbean);
		return "seccess";
	}

	/**
	 * 
	 * @Description：获得当前是时间并格式化
	 * @return
	 */
	public String getCurrentTime() {
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss:SSS");
		String ctime = formatter.format(new Date());
		return ctime;
	}

	/**
	 * 
	 * @Description：记录访问action的时间和结果并写道log.xml文件中
	 * @param logBean
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws JDOMException
	 */
	private void createLogXml(LogBean logBean) throws FileNotFoundException,
			IOException, JDOMException {

		// 使xml文件 缩进效果
		Format format = Format.getPrettyFormat();
		XMLOutputter XMLOut = new XMLOutputter(format);
		File file = new File("D:/log.xml");
		// 文件不存在时先创建
		if (!file.exists()) {
			file.createNewFile();
			// 创建根节点 并设置它的属性 ;
			Element root = new Element("log");
			// 将根节点添加到文档中；
			Document Doc = new Document(root);
			//    
			root.addContent(createActionNode(logBean));
			XMLOut.output(Doc, new FileOutputStream(file));
		} else {
			SAXBuilder builder = new SAXBuilder();
			if (new FileReader(file).read() == -1) {
				Element root = new Element("log");
				Document Doc = new Document(root);
				XMLOut.output(Doc, new FileOutputStream(file));
			}
			Document doc = builder.build(file);
			Element root = doc.getRootElement();
			root.addContent(createActionNode(logBean));
			// 文件处理
			XMLOut.output(doc, new FileOutputStream(file));
		}
	}

	/**
	 * 
	 * @Description：创建action节点
	 * @param logBean
	 * @return
	 */
	private Element createActionNode(LogBean logBean) {
		// 创建节点 action;
		Element element = new Element("action");
		// 给 action 节点添加子节点并赋值；
		element
				.addContent(new Element("name")
						.setText(logBean.getActionName()));
		element.addContent(new Element("s-time")
				.setText(logBean.getStartTime()));
		element.addContent(new Element("e-time").setText(logBean.getEndTime()));
		element.addContent(new Element("result").setText(logBean.getResult()));
		return element;
	}
}
