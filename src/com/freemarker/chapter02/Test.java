package com.freemarker.chapter02;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.SimpleHash;
import freemarker.template.SimpleSequence;
import freemarker.template.Template;
import freemarker.template.TemplateCollectionModel;
import freemarker.template.TemplateDateModel;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Test {

	public static void main(String[] args) throws Exception {

		System.out.println(System.getProperty("user.dir"));

		/* 在整个应用的生命周期中，这个工作你应该只做一次。 */
		/* 创建和调整配置。 */
		Configuration cfg = new Configuration();
		cfg.setDirectoryForTemplateLoading(new File(
				"E:/WorkSpace/My/FreeMarker/src/com/freemarker/chapter02"));

		cfg.setObjectWrapper(new DefaultObjectWrapper());
		cfg.setTemplateExceptionHandler(new MyTemplateExceptionHandler());

		/* 在整个应用的生命周期中，这个工作你可以执行多次 */
		/* 获取或创建模板 */
		Template temp = cfg.getTemplate("test.ftl");

		/* 创建数据模型 */
		SimpleHash root = new SimpleHash();
		root.put("user", "Big Joe");
		Map latest = new HashMap();
		root.put("latestProduct", latest);
		latest.put("url", "products/greenmouse.html");
		latest.put("name", "green mouse");

		// 加入方法
		root.put("indexOf", new IndexOfMethod());

		// 加入指令
		root.put("upper", new UpperDirective());
		root.put("repeat", new RepeatDirective());

		Map map = new HashMap();
		map.put("anotherString", "blah");
		map.put("anotherNumber", new Double(3.14));
		List list = new ArrayList();
		list.add("red");
		list.add("green");
		list.add("blue");
		// 将会使用默认的包装器
		root.put("theString", "wombat");
		root.put("theNumber", new Integer(8));
		// 可以拿到Java对象":
		root.put("theObject", new TestObject("green mouse", 1200));
		root.put("theMap", map);
		root.put("theList", list);

		/* 将模板和数据模型合并 */
		Writer out = new OutputStreamWriter(System.out);

		Environment env = temp.createProcessingEnvironment(root, out);
		env.setLocale(java.util.Locale.ITALY);
		env.setNumberFormat("0.####");
		env.process(); // 处理模板

		temp.process(root, out);
		out.flush();
	}

	public void testName() throws Exception {
		TemplateModel templateModel;
		TemplateDateModel templateDateModel;

		TemplateHashModel templateHashModel;

		SimpleSequence sequence;

		TemplateCollectionModel templateCollectionModel;
	}
}
