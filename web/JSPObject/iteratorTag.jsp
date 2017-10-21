<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/21
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="mytag" uri="/WEB-INF/mytaglib.tld"%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<html>
<head>
    <title>测试带标签体的标签</title>
</head>
<body>
<h2>带有标签体的标签-迭代器标签</h2>
<%
    // 创建一个List对象
    List<String> a = new ArrayList<String>();
    a.add("中国");
    a.add("美国");
    a.add("英国");
    // 将List对象放进page范围
    pageContext.setAttribute("a", a);
%>
<table border="1" bgcolor="#7fffd4" width="300">
    <!-- 使用迭代器标签，对a集合进行迭代 -->
    <mytag:iterator item="item" collection="a">
        <tr>
            <td>${pageScope.item}</td>
        </tr>
    </mytag:iterator>
</table>
</body>
</html>
