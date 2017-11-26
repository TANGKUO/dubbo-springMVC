package com.tangkuo.cn.online.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * 
 * @author 61650
 *
 */
@Controller
public class BaseController {

	/**
	 * serverSign:是否驗證簽名標識
	 */
	@Value("${server.sign}")
	protected String serverSign;
	/**
	 * serverPost:是否打印post請求日志信息標識
	 */
	@Value("${server.post}")
	protected String serverPost;
	/**
	 * serverGet:是否打印Get請求日志信息標識
	 */
	@Value("${server.get}")
	protected String serverGet;

	/**
	 * 加密key值
	 */
	@Value("${encrypt_key}")
	protected String encryptKey;

	/**
	 * 
	 * @Title: autoSubmitForm
	 * @Description: (autoSubmitForm输出text/html;charset=utf-8)
	 * @param response
	 *            HttpServletResponse
	 * @param sb
	 *            StringBuilder
	 * 
	 * @return void 返回类型
	 * @throws IOException
	 */
	protected void autoSubmitForm(HttpServletResponse response, String result) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

	/**
	 * 
	 * @param result
	 * @param response
	 * @throws IOException
	 */
	protected void writeKeyValue(String result, HttpServletResponse response) throws IOException {
		response.setContentType("application/x-www-form-urlencoded; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

	/**
	 * 
	 * @param result
	 * @param response
	 * @throws IOException
	 */
	protected void writeResult(String result, HttpServletResponse response) throws IOException {
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

	/**
	 * 
	 * @param code
	 * @param desc
	 * @param response
	 * @throws IOException
	 */
	protected void writeResult(int code, String desc, HttpServletResponse response) throws IOException {
		StringBuffer jsonStr = new StringBuffer();
		jsonStr.append("{\"code\":");
		jsonStr.append(code);
		jsonStr.append(",\"desc\":\"");
		jsonStr.append(desc);
		jsonStr.append("\"}");
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(jsonStr.toString());
		out.flush();
		out.close();
	}

	/**
	 * 
	 * @param code
	 * @param desc
	 * @param data
	 * @param response
	 * @throws IOException
	 */
	protected void writeResult(int code, String desc, String data, HttpServletResponse response) throws IOException {
		StringBuffer jsonStr = new StringBuffer();
		jsonStr.append("{\"code\":");
		jsonStr.append(code);
		jsonStr.append(",\"desc\":\"");
		jsonStr.append(desc);
		jsonStr.append("\",\"data\":\"");
		jsonStr.append(data);
		jsonStr.append("\"}");
		response.setContentType("application/json; charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(jsonStr.toString());
		out.flush();
		out.close();
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public String getDefaultValue(String value) {
		if (StringUtils.isEmpty(value)) {
			return "";
		}
		return value;
	}

}
