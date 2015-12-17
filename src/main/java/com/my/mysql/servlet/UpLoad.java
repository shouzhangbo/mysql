package com.my.mysql.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UpLoad extends  HttpServlet{
//	http://www.dedecms.com/knowledge/data-base/mysql/2012/0819/7582.html
	private String src = "http://127.0.0.1:89/";
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("coming in the upLoad!!!");
		String fileName = getFileName();
		request.setCharacterEncoding("UTF-8");
		String url = "http://localhost:89/";
		String src = "/srv/image/";
		  DiskFileItemFactory factory = new DiskFileItemFactory();
		  ServletFileUpload upload = new ServletFileUpload(factory);
		  
		  File tempFile = null;
		  try {
		   List items = upload.parseRequest(request);
		   Iterator itr = items.iterator();
		   while (itr.hasNext()) {
		    FileItem item = (FileItem) itr.next();
		    if (item.isFormField()) {
		     System.out.println("表单参数名:" + item.getFieldName() + "，表单参数值:" + item.getString("UTF-8"));
		    } else {
		     if (item.getName() != null && !item.getName().equals("")) {
		      System.out.println("上传文件的大小:" + item.getSize());
		      System.out.println("上传文件的类型:" + item.getContentType());
		      // item.getName()返回上传文件在客户端的完整路径名称
		      System.out.println("上传文件的名称:" + item.getName());

		      tempFile = new File(item.getName());
		      fileName = fileName +tempFile.getName().substring(tempFile.getName().lastIndexOf("."), tempFile.getName().length());
		      //上传文件的保存路径
		      File file = new File(src, fileName);
		      item.write(file);
		      request.setAttribute("upload.message", "上传文件成功！");
		     }else{
		      request.setAttribute("upload.message", "没有选择上传文件！");
		     }
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
	        System.out.println("src======"+url+tempFile.getName());
	        out.println("parent.imgCallBack('"+url+fileName+"');");
	        out.println("</script>");
	        out.println("</body>");
	        out.println("</html>");
        }
	
	public String getFileName(){
		return new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
	}
}
