package zyl.utils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class HttpUtil {
	
	public static ServletContext getApplication() {
		ServletContext servletContext = ServletActionContext.getRequest().getSession().getServletContext();
		return servletContext;
	}

	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ServletActionContext.getRequest();
		return request;
	}
}
