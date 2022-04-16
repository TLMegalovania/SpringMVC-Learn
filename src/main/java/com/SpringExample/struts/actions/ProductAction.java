package com.SpringExample.struts.actions;

import com.SpringExample.model.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class ProductAction extends ActionSupport {

    private Product product;

    // Map类型的request
    private Map<String, Object> request;
    // Map类型的session
    private Map<String, Object> session;
    // Map类型的application
    private Map<String, Object> application;



    public ProductAction(){
        // 获取ActionContext对象
        ActionContext context = ActionContext.getContext();
        // 获取Map类型的request
        request = (Map<String, Object>) context.get("request");
        // 获取Map类型的session
        session = context.getSession();
        // 获取Map类型的application
        application = context.getApplication();
    }

    public Product getProduct(){
        return product;
    }

    public Product setProduct(Product product){
        this.product = product;
        return this.product;
    }

    public String add(){
        return SUCCESS;
    }

    public String get() {
        Product model = new Product();
        model.setName("汽车");
        model.setPrice(100000.0);
        model.setFactory("东风");

        product = model;
        return SUCCESS;
    }

    /**
     * 请求处理方法
     * @return String
     */
    public String execute() throws Exception{
        // 字符串信息
        String info = "武汉大学";
        // 向request添加信息
        request.put("info", info);
        // 向session添加信息
        session.put("info", info);
        // 向application添加信息
        application.put("info", info);
        // 成功返回
        return SUCCESS;
    }
}
