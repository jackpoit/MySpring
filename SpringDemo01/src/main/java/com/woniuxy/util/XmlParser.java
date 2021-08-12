package com.woniuxy.util;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.List;

/**
 * @Author: rua
 * @Date: 2021/8/12 9:28
 * @Description: Xml解析工具
 */
public class XmlParser {

	/**
	 * 根据id获取类的全限定名
	 * @param id xml中bean的id
	 * @return 全限定名
	 */
	public static String getClassNameById(String id) {
		try {
			//1.从src路径下找到这个bean.xml
			String src = XmlParser.class.getClassLoader().getResource("").getPath();
			File file = new File(src + "application.xml");
			if (!file.exists())
				throw new NoSuchFileException("application.xml does not exist");

			System.out.println(file);
			//2.通过jsoup来将xml解析成文档树结构
			Document document = Jsoup.parse(file, "UTF-8");
			//3.将document转换成xpath能解析的树结构
			JXDocument doc = new JXDocument(document);
			//4,开始使用xpath来解析文档
			List<JXNode> list = doc.selN("//bean[@id=" + id + "]");
			if (list.size() < 1)
				throw new XpathSyntaxErrorException("bean id is not found");
			//5.通过id来获取对应的class
			return doc.selN("//bean[@id=" + id + "]/@class").get(0).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
