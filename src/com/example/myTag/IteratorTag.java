package com.example.myTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collection;

public class IteratorTag extends SimpleTagSupport {
    // 标签属性，用于指定需要被迭代的集合
    private String collection;
    // 标签属性，指定被迭代的集合元素，为集合元素指定名称
    private String item;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    // 处理标签的方法，在标签处理类中只需要重写doTag()方法

    @Override
    public void doTag() throws JspException, IOException {
        // 从page scope中获取名为collection的集合
        Collection itemList = (Collection)getJspContext().getAttribute(collection);
        // 遍历集合
        for (Object s : itemList) {
            // 将集合元素设置到page范围内
            getJspContext().setAttribute(item, s);
            // 输出标签体
            getJspBody().invoke(null);
        }
    }
}
