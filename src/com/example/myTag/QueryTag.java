package com.example.myTag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.Writer;
import java.sql.*;

public class QueryTag extends SimpleTagSupport {
    // 定义成员变量来代替标签属性
    private String driver;
    private String url;
    private String user;
    private String pass;
    private String sql;

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private ResultSetMetaData rsmd = null;
    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public void doTag() throws JspException, IOException {
        try {
            // 注册数据库驱动
            Class.forName(driver);
            // 获取数据库连接
            conn = DriverManager.getConnection(url,user,pass);
            // 创建Statement对象
            stmt = conn.createStatement();
            // 执行查询
            rs = stmt.executeQuery(sql);
            rsmd = rs.getMetaData();
            // 获取列数目
            int columnCount = rsmd.getColumnCount();

            // 获取页面输出流
            Writer out = getJspContext().getOut();
            // 在页面输出表格
            out.write("<table border='1' bgColor='#9999cc' width='400'>");
            // 遍历结果
            while (rs.next()) {
                out.write("<tr>");
                for (int i = 1; i <= columnCount; i++) {
                    out.write("<td>");
                    out.write(rs.getObject(i).toString());
                    System.out.println(rs.getString(i));
                    out.write("</td>");
                }
                out.write("</tr>");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new JspException("自定义标签错误" + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new JspException("自定义标签错误" + e.getMessage());
        } finally {
            // 关闭结果集
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null)
                    stmt.close();;
                if (conn != null)
                    conn.close();
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }
}
