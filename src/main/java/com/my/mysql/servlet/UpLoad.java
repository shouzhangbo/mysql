package com.my.mysql.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UpLoad {
//	http://www.dedecms.com/knowledge/data-base/mysql/2012/0819/7582.html
	private String src = "http://localhost:8080/mysql/img/";
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		this.doGet(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
	    File tempFile = null;
	    try {
	    	List items = upload.parseRequest(request);
		    Iterator itr = items.iterator();
		    while (itr.hasNext()) {
			    FileItem item = (FileItem) itr.next();
			    if (!item.isFormField()&&item.getName() != null && !item.getName().equals("")) 
			    {
			      tempFile = new File(item.getName());
			      //上传文件的保存路径
//			      File file = new File("E:/workspace/MyTest/src/main/webapp/img/", tempFile.getName());
			      File file = new File(src, tempFile.getName());
			      item.write(file);
			      break;
			    }
		    }
		  }catch (Exception e) {
			   e.printStackTrace();
		  }
		 	//输出到js然后调用父页面的回调方法
	        PrintWriter out = response.getWriter();
	        out.println("<html><head>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<script type='text/javascript'>");
	        out.println("parent.imgCallBack('"+src+tempFile.getName()+"');");
	        out.println("</script>");
	        out.println("</body>");
	        out.println("</html>");
        }
}
