package com.my.mysql.ctrl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.my.mysql.response.bean.CategoryBeans;
import com.my.mysql.response.bean.CategorySecBeans;
import com.my.mysql.response.bean.CategoryThrBeans;
import com.my.mysql.response.bean.ProductBeans;
import com.my.mysql.service.BrandService;
import com.my.mysql.service.CategorySecService;
import com.my.mysql.service.CategoryService;
import com.my.mysql.service.CategoryThrService;
import com.my.mysql.service.ProductService;
import com.my.mysql.util.CommUtil;

import net.sf.cglib.beans.BeanCopier;

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
	/**
	 * 查询商品种类
	 * @return
	 */
	@RequestMapping(value = "/queryCategory", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public CategoryResponse queryCategory(){
		CategoryResponse cate = new CategoryResponse();
		List<CategoryBeans> list = new ArrayList<CategoryBeans>();
		List<Category> cList = categoryService.findByProperty(Category.class, "status", GlobalConstant.okInt);
		for(int i=0;i<cList.size();i++){
			CategoryBeans cb = new CategoryBeans();
			BeanCopier copier = BeanCopier.create(Category.class, CategoryBeans.class,
                    false);
            copier.copy(cList.get(i), cb, null);
            cb.setSecList(getSecSet(cList.get(i).getCategorySec()));
            list.add(cb);
		}
		cate.setList(list);
		cate.setRespCode(GlobalConstant.successRespCode);
		cate.setRespMsg("success");
		return cate;
	}
	@RequestMapping(value = "/queryProduct", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public ProductResponse queryCategory(Integer categoryId,Integer cateSecId,Integer cateThrId){
		ProductResponse p = new ProductResponse();
		List<ProductBeans> list = new ArrayList<ProductBeans>();
		List<Product> pList = productService.findByProperty(Product.class, "productStatus", GlobalConstant.okInt);
		for(Product pro : pList){
			ProductBeans cb = new ProductBeans();
			BeanCopier copier = BeanCopier.create(Product.class, ProductBeans.class,
                    false);
            copier.copy(pro, cb, null);
            cb.setBrandName(pro.getBrand().getBrandName());
            list.add(cb);
		}
		p.setList(list);
		p.setRespCode(GlobalConstant.successRespCode);
		p.setRespMsg("success");
		return p;
	}
	/**
	 * 
	 * @param set
	 * @return
	 */
	public static Set<CategorySecBeans> getSecSet(Set<CategorySec> set){
		Set<CategorySecBeans> list = new HashSet<CategorySecBeans>();
		for(CategorySec obj1:set){
			CategorySecBeans obj2 = new CategorySecBeans();
			BeanCopier copier = BeanCopier.create(CategorySec.class, CategorySecBeans.class,
                    false);
            copier.copy(obj1, obj2, null);
            obj2.setCategoryThr(getThrSet(obj1.getCategoryThr()));
			list.add(obj2);
		}
		return list;
	}
	
	public static Set<CategoryThrBeans> getThrSet(Set<CategoryThr> set){
		Set<CategoryThrBeans> list = new HashSet<CategoryThrBeans>();
		for(CategoryThr obj1:set){
			CategoryThrBeans obj2 = new CategoryThrBeans();
			BeanCopier copier = BeanCopier.create(CategoryThr.class, CategoryThrBeans.class,
                    false);
            copier.copy(obj1, obj2, null);
			list.add(obj2);
		}
		return list;
	}
}
