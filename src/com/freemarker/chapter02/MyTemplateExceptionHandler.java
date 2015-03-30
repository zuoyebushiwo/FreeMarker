package com.freemarker.chapter02;

import java.io.IOException;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class MyTemplateExceptionHandler implements TemplateExceptionHandler {

	@Override
	public void handleTemplateException(TemplateException te, Environment env,
			java.io.Writer out) throws TemplateException {
		try {
			out.write("[ERROR: " + te.getMessage() + "]");
		} catch (IOException e) {
			throw new TemplateException(
					"Failed to print error message. Cause: " + e, env);
		}
	}

}
