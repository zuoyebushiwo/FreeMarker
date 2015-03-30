package com.freemarker.my.test.freemarker.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.freemarker.my.test.client.Book;
import com.freemarker.my.test.client.ClassRoom;
import com.freemarker.my.test.client.PIG;
import com.freemarker.my.test.client.User;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author hailang
 * @date 2009-7-9 上午09:55:43
 * @param templateName
 *            模板文件名称
 * @param root
 *            数据模型根对象
 * @param templateEncoding
 *            模板文件的编码方式
 */
public class FreeMarkertUtil {

	public static void analysisTemplate(String templateName,
			String templateEncoding, Map<?, ?> root) {
		try {
			Configuration config = new Configuration();
			File file = new File("src/templates");
			// 设置要解析的模板所在的目录，并加载模板文件
			config.setDirectoryForTemplateLoading(file);
			// 设置包装器，并将对象包装为数据模型
			config.setObjectWrapper(new DefaultObjectWrapper());

			// 获取模板,并设置编码方式，这个编码必须要与页面中的编码格式一致
			Template template = config.getTemplate(templateName,
					templateEncoding);

			// 合并数据模型与模板
			Writer out = new OutputStreamWriter(System.out); // 或者用StringWriter
																// stringWriter
																// = new
																// StringWriter();
																// 以便得到一个字符串
			template.process(root, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}

	}

	public static void analysisTemplateTwo(File file, String templateName,
			String templateEncoding, Map<?, ?> root, Writer out) {
		try {
			Configuration config = new Configuration();

			// 设置要解析的模板所在的目录，并加载模板文件
			config.setDirectoryForTemplateLoading(file);
			// 设置包装器，并将对象包装为数据模型
			config.setObjectWrapper(new DefaultObjectWrapper());
			config.setDefaultEncoding(templateEncoding);
			// 获取模板,并设置编码方式，这个编码必须要与页面中的编码格式一致
			Template template = config.getTemplate(templateName,
					templateEncoding);
			template.setEncoding(templateEncoding);
			// 合并数据模型与模板
			// Writer out = new OutputStreamWriter(System.out);
			template.process(root, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("来了");
		// response.setCharacterEncoding("utf-8");
		User user = new User();
		user.setUserName("张三");
		user.setUserPassword("123");

		User user2 = new User();
		user2.setUserName("李四");
		user2.setUserPassword("345");

		User user3 = new User();
		user3.setUserName("王五");
		user3.setUserPassword("678");

		List<User> users = new ArrayList<User>();
		users.add(user);
		users.add(user2);
		users.add(user3);

		ClassRoom cRoom = new ClassRoom();
		cRoom.setName("三年级乙班");
		cRoom.setUser(users);

		PIG pig = new PIG();
		pig.setAge(2);
		pig.setName("小猪");
		pig.setWeight("200KG");

		Book book = new Book();
		book.setAuthor("小明");
		book.setName("语文");
		book.setSubject("文学");

		Map<String, Object> root = new HashMap<String, Object>();
		root.put("classR", cRoom);
		root.put("pig", pig);
		root.put("book", book);

		// PrintWriter out = response.getWriter();
		File file = new File("E:/WorkSpace/My/FreeMarker/src/templates");

		FreeMarkertUtil.analysisTemplateTwo(file, "user.ftl", "UTF-8", root);
	}

	public static void analysisTemplateTwo(File file, String templateName,
			String templateEncoding, Map<?, ?> root) {
		try {
			Configuration config = new Configuration();

			// 设置要解析的模板所在的目录，并加载模板文件
			config.setDirectoryForTemplateLoading(file);
			// 设置包装器，并将对象包装为数据模型
			config.setObjectWrapper(new DefaultObjectWrapper());
			config.setDefaultEncoding(templateEncoding);
			// 获取模板,并设置编码方式，这个编码必须要与页面中的编码格式一致
			Template template = config.getTemplate(templateName,
					templateEncoding);
			template.setEncoding(templateEncoding);
			// 合并数据模型与模板
			Writer out = new OutputStreamWriter(System.out);
			template.process(root, out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

}
