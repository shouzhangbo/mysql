package com.my.mysql.ctrl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.mysql.form.BaseForm.addCategoryForm;
import com.my.mysql.constants.GlobalConstant;
import com.my.mysql.form.BaseForm.addCateSecForm;
import com.my.mysql.form.BaseForm.addBrandForm;
import com.my.mysql.form.BaseForm.addProductForm;
import com.my.mysql.form.ProductForm;
import com.my.mysql.model.Brand;
import com.my.mysql.model.Category;
import com.my.mysql.model.CategorySec;
import com.my.mysql.model.CategoryThr;
import com.my.mysql.model.Product;
import com.my.mysql.response.BaseResponse;
import com.my.mysql.response.CategoryResponse;
import com.my.mysql.response.ProductResponse;
import com.my.mysql.service.BrandService;
import com.my.mysql.service.CategorySecService;
import com.my.mysql.service.CategoryService;
import com.my.mysql.service.CategoryThrService;
import com.my.mysql.service.ProductService;

@Controller
public class ProductCtrl {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategorySecService categorySecService;
	@Autowired
	private CategoryThrService categoryThrService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductService productService;
	/***
	 * 添加类别
	 * @param productForm
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addCategory", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public BaseResponse addCategory(@Validated({addCategoryForm.class}) ProductForm productForm, 
			BindingResult result,HttpServletRequest request,HttpServletResponse response){
		BaseResponse baseRes = new BaseResponse();
		 try {
	            if (result.hasErrors()) {
	                for (ObjectError e : result.getAllErrors()) {
	                	baseRes.setRespMsg(e.getDefaultMessage());
	                    return baseRes;
	                }
	            }
		 }catch(Exception e){
			 baseRes.setRespMsg("网络异常");
			 e.printStackTrace();
		 }
		 Category c = new Category();
		 c.setCategoryName(productForm.getCategoryName());
		 c.setCategoryDesc(productForm.getCategoryDesc());
		 c.setCategoryImg(productForm.getCategoryImg());
		 c.setCategoryIndex(1);///?
		 c.setStatus(GlobalConstant.okInt);
		 c.setStatusName(GlobalConstant.nOStatusName);
		 c.setCreateAt(new Date());
		 c.setUpdateAt(new Date());
		 categoryService.save(c);
		 baseRes.setRespCode(GlobalConstant.successRespCode);
		 baseRes.setRespMsg("success");
		 
		 return baseRes;
	}
	/***
	 * 添加品牌
	 * @param productForm
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addBrand", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public BaseResponse addBrand(@Validated({addProductForm.class}) ProductForm productForm, 
			BindingResult result,HttpServletRequest request,HttpServletResponse response){
		BaseResponse baseRes = new BaseResponse();
		 try {
	            if (result.hasErrors()) {
	                for (ObjectError e : result.getAllErrors()) {
	                	baseRes.setRespMsg(e.getDefaultMessage());
	                    return baseRes;
	                }
	            }
		 }catch(Exception e){
			 baseRes.setRespMsg("网络异常");
			 e.printStackTrace();
		 }
		 Brand brand = new Brand();
		 brand.setBrandName(productForm.getBrandName());
		 brand.setBrandDesc(productForm.getBrandDesc());
		 brand.setStatus(GlobalConstant.okInt);
		 brand.setStatusName(GlobalConstant.nOStatusName);
		 brand.setCreateAt(new Date());
		 brand.setUpdateAt(new Date());
		 brandService.save(brand);
		 baseRes.setRespCode(GlobalConstant.successRespCode);
		 baseRes.setRespMsg("success");
		 
		 return baseRes;
	}
	
	/***
	 * 添加商品
	 * @param productForm
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addProduct", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public BaseResponse addProduct(@Validated({addBrandForm.class}) ProductForm productForm, 
			BindingResult result,HttpServletRequest request,HttpServletResponse response){
		BaseResponse baseRes = new BaseResponse();
		 try {
	            if (result.hasErrors()) {
	                for (ObjectError e : result.getAllErrors()) {
	                	baseRes.setRespMsg(e.getDefaultMessage());
	                    return baseRes;
	                }
	            }
		 }catch(Exception e){
			 baseRes.setRespMsg("网络异常");
			 e.printStackTrace();
		 }
		 Product pro = new Product();
		 CategoryThr thr = categoryThrService.findById(CategoryThr.class, productForm.getCategoryId());
		 Brand brand = brandService.findById(Brand.class,productForm.getBrandId());
		 pro.setBrand(brand);
		 pro.setCategoryThr(thr);
		 
		 pro.setProductName(productForm.getProductName());
		 pro.setProductDesc(productForm.getProductDesc());
		 pro.setProductImgFirst(productForm.getProductImgFirst());
		 pro.setProductImg(productForm.getProductImg());
		 pro.setProductStatus(GlobalConstant.okInt);
		 pro.setProductStatusName(GlobalConstant.nOStatusName);
		 
		 pro.setCreateAt(new Date());
		 pro.setUpdateAt(new Date());
		 productService.save(pro);
		 baseRes.setRespCode(GlobalConstant.successRespCode);
		 baseRes.setRespMsg("success");
		 
		 return baseRes;
	}
	/****
	 * 添加二级类别
	 * @param productForm
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addCateSec", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public BaseResponse addCateSec(@Validated({addCateSecForm.class}) ProductForm productForm, 
			BindingResult result,HttpServletRequest request,HttpServletResponse response){
		BaseResponse baseRes = new BaseResponse();
		 try {
	            if (result.hasErrors()) {
	                for (ObjectError e : result.getAllErrors()) {
	                	baseRes.setRespMsg(e.getDefaultMessage());
	                    return baseRes;
	                }
	            }
		 }catch(Exception e){
			 baseRes.setRespMsg("网络异常");
			 e.printStackTrace();
		 }
		 CategorySec sec = new CategorySec();
		 Category c = categoryService.findById(Category.class,productForm.getCategoryId());
		 sec.setCategory(c);
		 sec.setCateSecName(productForm.getCategoryName());
		 sec.setCateSecDesc(productForm.getCategoryDesc());
		 sec.setCateSecImg(productForm.getCategoryImg());
		 sec.setCateSecIndex(1);///?
		 sec.setStatus(GlobalConstant.okInt);
		 sec.setStatusName(GlobalConstant.nOStatusName);
		 sec.setCreateAt(new Date());
		 sec.setUpdateAt(new Date());
		 categorySecService.save(sec);
		 baseRes.setRespCode(GlobalConstant.successRespCode);
		 baseRes.setRespMsg("success");
		 
		 return baseRes;
	}
	/***
	 * 添加三级商品类别
	 * @param productForm
	 * @param result
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addCateThr", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public BaseResponse addCateThr(@Validated({addCateSecForm.class}) ProductForm productForm, 
			BindingResult result,HttpServletRequest request,HttpServletResponse response){
		BaseResponse baseRes = new BaseResponse();
		 try {
	            if (result.hasErrors()) {
	                for (ObjectError e : result.getAllErrors()) {
	                	baseRes.setRespMsg(e.getDefaultMessage());
	                    return baseRes;
	                }
	            }
		 }catch(Exception e){
			 baseRes.setRespMsg("网络异常");
			 e.printStackTrace();
		 }
		 CategoryThr thr = new CategoryThr();
		 CategorySec c = categorySecService.findById(CategorySec.class,productForm.getCategoryId());
		 thr.setCategorySec(c);
		 thr.setCateThrName(productForm.getCategoryName());
		 thr.setCateThrDesc(productForm.getCategoryDesc());
		 thr.setCateThrImg(productForm.getCategoryImg());
		 thr.setCateThrIndex(1);///?
		 thr.setStatus(GlobalConstant.okInt);
		 thr.setStatusName(GlobalConstant.nOStatusName);
		 thr.setCreateAt(new Date());
		 thr.setUpdateAt(new Date());
		 categoryThrService.save(thr);
		 baseRes.setRespCode(GlobalConstant.successRespCode);
		 baseRes.setRespMsg("success");
		 return baseRes;
	}
	
	public CategoryResponse queryCategory(){
		CategoryResponse cate = new CategoryResponse();
		return cate;
	}
}