package com.train.service.struts.rest.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.rest.DefaultHttpHeaders;
import org.apache.struts2.rest.HttpHeaders;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.train.service.struts.model.Book;
import com.train.service.struts.rest.BookService;

//定义返回 success 时重定向到 book Action 

@Namespace("/strutsRest") 

@Results(@Result(name = "success", type = "redirectAction", params = {
		"actionName", "book" }))
public class BookController extends ActionSupport implements
		ModelDriven<Object> {
	// 封装 id 请求参数的属性
	private int id;
	private Book model = new Book();
	private List<Book> list;
	// 定义业务逻辑组件
	private BookService bookService = new BookService();

	// 获取 id 请求参数的方法
	public void setId(int id) {
		this.id = id;
		// 取得方法时顺带初始化 model 对象
		if (id > 0) {
			this.model = bookService.get(id);
		}
	}

	public int getId() {
		return this.id;
	}

	// 处理不带 id 参数的 GET 请求
	// 进入首页
	public HttpHeaders index() {
		list = bookService.getAll();
		return new DefaultHttpHeaders("index").disableCaching();
	}

	// 处理不带 id 参数的 GET 请求
	// 进入添加新图书。
	public String editNew() {
		// 创建一个新图书
		model = new Book();
		return "editNew";
	}

	// 处理不带 id 参数的 POST 请求
	// 保存新图书
	public HttpHeaders create() {
		// 保存图书
		bookService.saveOrUpdate(model);
		addActionMessage("添加图书成功");
		return new DefaultHttpHeaders("success").setLocationId(model.getId());
	}

	// 处理带 id 参数的 GET 请求
	// 显示指定图书
	public HttpHeaders show() {
		return new DefaultHttpHeaders("show");
	}

	// 处理带 id 参数、且指定操作 edit 资源的 GET 请求
	// 进入编辑页面 (book-edit.jsp)
	public String edit() {
		return "edit";
	}

	// 处理带 id 参数的 PUT 请求
	// 修改图书
	public String update() {
		bookService.saveOrUpdate(model);
		addActionMessage("图书编辑成功！");
		return "success";
	}

	// 处理带 id 参数，且指定操作 deleteConfirm 资源的方法
	// 进入删除页面 (book-deleteConfirm.jsp)
	public String deleteConfirm() {
		return "deleteConfirm";
	}

	// 处理带 id 参数的 DELETE 请求
	// 删除图书
	public String destroy() {
		bookService.remove(id);
		addActionMessage("成功删除 ID 为" + id + "的图书！");
		return "success";
	}

	// 实现 ModelDriven 接口必须实现的 getModel 方法
	public Object getModel() {
		return (list != null ? list : model);
	}
}