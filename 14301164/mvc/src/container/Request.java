package container;
import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.UnsupportedEncodingException;  
import java.util.Enumeration;  
import java.util.Locale;  
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletInputStream;  
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;  
  
public class Request implements ServletRequest  
{
	//所需变量
    private InputStream input;  
    private String uri;  
    private String requestw; 
    
    public Request(InputStream input)  
    {  
        this.input = input;  
    }  

    public void parse()  
    {  
        //处理请求
        StringBuffer request = new StringBuffer(2048);  
        int i;  
        byte[] buffer = new byte[2048];  
        try  
        {  
            i = input.read(buffer);  
        }  
        catch (IOException e)  
        {  
            e.printStackTrace();  
            i = -1;  
        }  
        for (int j = 0; j < i; j++)  
        {  
            request.append((char) buffer[j]);  
        }
        //储存相应请求 
        requestw = request.toString();
        uri = parseUri(request.toString());  
    }
    
    public String getUri()  
    {  
    	if(uri==null){
    		return "";
    	}
        return uri;  
    }  
  
    //返回uri
    private String parseUri(String requestdata)  
    {  
    	try{
	    	String[] data = requestdata.split("\r\n");
	    	String[] data2 = data[0].split(" ");
	    	return data2[1];
    	} catch(Exception e){
    		return null;
    	}  
    }  

	public String getParameter(String arg0) {
		String value = "null";
		try{
			//返回相应变量
			String[] data = requestw.split("\r\n\r\n");
			String[] paras = data[data.length-1].split("&");
			for(int i = 0; i < paras.length; i++){
				String[] a = paras[i].split("=");
				if(arg0.equals(a[0])){
					if(a.length == 1){
						value = "";
					}else{
						value = a[1];
						break;
					}
				}
			}
		}catch(Exception e){
			return "null";
		}
		return value;
	}

	@Override
	public AsyncContext getAsyncContext() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public Object getAttribute(String arg0) {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public String getCharacterEncoding() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public int getContentLength() {
		// TODO �Զ���ɵķ������
		return 0;
	}

	@Override
	public long getContentLengthLong() {
		// TODO �Զ���ɵķ������
		return 0;
	}

	@Override
	public String getContentType() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public DispatcherType getDispatcherType() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public String getLocalAddr() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public String getLocalName() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public int getLocalPort() {
		// TODO �Զ���ɵķ������
		return 0;
	}

	@Override
	public Locale getLocale() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public Enumeration<Locale> getLocales() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public String[] getParameterValues(String arg0) {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public String getProtocol() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public BufferedReader getReader() throws IOException {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public String getRealPath(String arg0) {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public String getRemoteAddr() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public String getRemoteHost() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public int getRemotePort() {
		// TODO �Զ���ɵķ������
		return 0;
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String arg0) {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public String getScheme() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public String getServerName() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public int getServerPort() {
		// TODO �Զ���ɵķ������
		return 0;
	}

	@Override
	public ServletContext getServletContext() {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public boolean isAsyncStarted() {
		// TODO �Զ���ɵķ������
		return false;
	}

	@Override
	public boolean isAsyncSupported() {
		// TODO �Զ���ɵķ������
		return false;
	}

	@Override
	public boolean isSecure() {
		// TODO �Զ���ɵķ������
		return false;
	}

	@Override
	public void removeAttribute(String arg0) {
		// TODO �Զ���ɵķ������
		
	}

	@Override
	public void setAttribute(String arg0, Object arg1) {
		// TODO �Զ���ɵķ������
		
	}

	@Override
	public void setCharacterEncoding(String arg0) throws UnsupportedEncodingException {
		// TODO �Զ���ɵķ������
		
	}

	@Override
	public AsyncContext startAsync() throws IllegalStateException {
		// TODO �Զ���ɵķ������
		return null;
	}

	@Override
	public AsyncContext startAsync(ServletRequest arg0, ServletResponse arg1) throws IllegalStateException {
		// TODO �Զ���ɵķ������
		return null;
	}  
}