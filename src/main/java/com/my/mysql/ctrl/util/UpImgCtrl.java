package com.my.mysql.ctrl.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.mysql.constants.GlobalConstant;
import com.my.mysql.response.BaseResponse;

@Controller
public class UpImgCtrl {

	@RequestMapping(value = "/up", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public String upImpl(){
		return "ddd";
	}
	@RequestMapping(value = "/upLoad", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public BaseResponse upImpl(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		System.out.println("*********");
		BaseResponse b = new BaseResponse();
		  DiskFileItemFactory factory = new DiskFileItemFactory();
		  ServletFileUpload upload = new ServletFileUpload(factory);
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

		      File tempFile = new File(item.getName());

		      //上传文件的保存路径
		      File file = new File("/srv/file/mysql/", tempFile.getName());
		      item.write(file);
		      request.setAttribute("upload.message", "上传文件成功！");
		     }else{
		      request.setAttribute("upload.message", "没有选择上传文件！");
		     }
		    }
		   }
		  }catch(FileUploadException e){
		   e.printStackTrace();
		  } catch (Exception e) {
		   e.printStackTrace();
		   request.setAttribute("upload.message", "上传文件失败！");
		  }
		  b.setRespCode(GlobalConstant.successRespCode);
		return b;
	}
	
	@RequestMapping(value = "/upp", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public String upImplByHtml(HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		System.out.println("*********");
		BaseResponse b = new BaseResponse();
		  DiskFileItemFactory factory = new DiskFileItemFactory();
		  ServletFileUpload upload = new ServletFileUpload(factory);
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

		      File tempFile = new File(item.getName());

		      //上传文件的保存路径
		      File file = new File("/srv/file/mysql/", tempFile.getName());
		      item.write(file);
		      request.setAttribute("upload.message", "上传文件成功！");
		     }else{
		      request.setAttribute("upload.message", "没有选择上传文件！");
		     }
		    }
		   }
		  }catch(FileUploadException e){
		   e.printStackTrace();
		  } catch (Exception e) {
		   e.printStackTrace();
		   request.setAttribute("upload.message", "上传文件失败！");
		  }
		  b.setRespCode(GlobalConstant.successRespCode);
		return "aa";
	}
}
