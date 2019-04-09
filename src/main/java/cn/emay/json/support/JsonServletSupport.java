package cn.emay.json.support;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import cn.emay.json.JsonHelper;

/**
 * servlet支持
 * 
 * @author Frank
 *
 */
public class JsonServletSupport {

	/**
	 * 响应Json串
	 * 
	 * @param response
	 * @param obj
	 */
	public static void outputWithJson(HttpServletResponse response, Object obj) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain;charset=utf-8");
		String json = JsonHelper.toJsonString(obj);
		OutputStream out = null;
		try {
			out = response.getOutputStream();
			out.write(json.getBytes("UTF-8"));
			out.flush();
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

}
