package com.example.myTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;

public class DynaAttributesTag extends SimpleTagSupport
        implements DynamicAttributes {
    // 保存每个属性名的集合
    private ArrayList<String> keys = new ArrayList<>();
    // 保存每个属性值的集合
    private ArrayList<Object> values = new ArrayList<>();

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        // 此处只是简单的输出每个属性值
        out.println("<ol>");
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Object value = values.get(i);
            out.println("<li>" + key + " = " + value + "</li>");
        }
        out.println("</ol>");
    }

    @Override
    public void setDynamicAttribute(String uri, String localName, Object value) throws JspException {
        // 添加属性名
        keys.add(localName);
        // 添加属性值
        values.add(value);
    }
}
