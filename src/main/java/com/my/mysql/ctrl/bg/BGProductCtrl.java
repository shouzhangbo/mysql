package com.my.mysql.ctrl.bg;

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
import com.my.mysql.response.CategorySecResponse;
import com.my.mysql.response.CategoryThrResponse;
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
public class BGProductCtrl {

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
	/**
	 * 查询商品种类
	 * @return
	 */
	@RequestMapping(value = "/queryCategory", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public CategoryResponse queryCategory(ProductForm form,HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		CategoryResponse cate = new CategoryResponse();
		List<CategoryBeans> list = new ArrayList<CategoryBeans>();
		List<Category> cList = categoryService.queryCategoryByCon(form);
		int count = categoryService.queryByCount(form);//总记录数
		for(int i=0;i<cList.size();i++){
			CategoryBeans cb = new CategoryBeans();
			BeanCopier copier = BeanCopier.create(Category.class, CategoryBeans.class,
                    false);
            copier.copy(cList.get(i), cb, null);
//            cb.setSecList(getSecSet(cList.get(i).getCategorySec()));
            list.add(cb);
		}
		cate.setList(list);
		cate.setRespCode(GlobalConstant.successRespCode);
		cate.setRespMsg("success");
		cate.setTotalReco(count);
		cate.setTotalPage(count%form.getPageSize()==0?count/form.getPageSize():count/form.getPageSize()+1);
		return cate;
	}
	@RequestMapping(value = "/queryCateSec", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public CategorySecResponse getCateSec(ProductForm form,HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		CategorySecResponse sec = new CategorySecResponse();
		List<CategorySec> secList = categorySecService.queryCateSec(form);
		int count = categorySecService.queryCateSecCount(form);
		List<CategorySecBeans> list = new ArrayList<CategorySecBeans>();
		for(CategorySec s:secList){
			CategorySecBeans bean = new CategorySecBeans();
			BeanCopier copier = BeanCopier.create(CategorySec.class, CategorySecBeans.class,
                    false);
            copier.copy(s, bean, null);
			list.add(bean);
		}
		sec.setRespCode(GlobalConstant.successRespCode);
		sec.setRespMsg("success");
		sec.setList(list);
		sec.setTotalReco(count);
		sec.setTotalPage(count%form.getPageSize()==0?count/form.getPageSize():count/form.getPageSize()+1);
		return sec;
	}
	@RequestMapping(value = "/queryCateThr", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public CategoryThrResponse getCateThr(ProductForm form,HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		CategoryThrResponse sec = new CategoryThrResponse();
		List<CategoryThr> secList = categoryThrService.queryCateSec(form);
		int count = categoryThrService.queryCateSecCount(form);
		List<CategoryThrBeans> list = new ArrayList<CategoryThrBeans>();
		for(CategoryThr s:secList){
			CategoryThrBeans bean = new CategoryThrBeans();
			BeanCopier copier = BeanCopier.create(CategoryThr.class, CategoryThrBeans.class,
                    false);
            copier.copy(s, bean, null);
			list.add(bean);
		}
		sec.setRespCode(GlobalConstant.successRespCode);
		sec.setRespMsg("success");
		sec.setList(list);
		sec.setTotalReco(count);
		sec.setTotalPage(count%form.getPageSize()==0?count/form.getPageSize():count/form.getPageSize()+1);
		return sec;
	}
	@RequestMapping(value = "/queryProduct", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
	public ProductResponse queryCategory(ProductForm form,Integer cateSecId,Integer cateThrId,
			HttpServletRequest request,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*" );
		ProductResponse p = new ProductResponse();
		List<ProductBeans> list = new ArrayList<ProductBeans>();
		List<Product> pList = productService.queryProduct(form);//(Product.class, "productStatus", GlobalConstant.okInt);
		int count = productService.queryProductByCount(form);
		for(Product pro : pList){
			ProductBeans cb = new ProductBeans();
			BeanCopier copier = BeanCopier.create(Product.class, ProductBeans.class,
                    false);
            copier.copy(pro, cb, null);
            cb.setBrandName(pro.getBrand().getBrandName());
            cb.setCateThrName(pro.getCategoryThr().getCateThrName());
            list.add(cb);
		}
		p.setList(list);
		p.setRespCode(GlobalConstant.successRespCode);
		p.setRespMsg("success");
		p.setTotalReco(count);
		p.setTotalPage(count%form.getPageSize()==0?count/form.getPageSize():count/form.getPageSize()+1);
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
	
	public static List<CategoryThrBeans> getThrSet(Set<CategoryThr> set){
		List<CategoryThrBeans> list = new ArrayList<CategoryThrBeans>();
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
