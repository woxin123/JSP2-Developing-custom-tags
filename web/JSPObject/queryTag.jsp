<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/21
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<!-- 导入标签库，指定mytag前缀的标签 -->
<%@ page contentType="text/html;charset=UTF-8"
         language="java" pageEncoding="UTF-8" %>

<%@taglib prefix="mytag" uri="/WEB-INF/mytaglib.tld" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>使用query</title>
</head>
<body>
<mytag:query driver="com.mysql.jdbc.Driver"
             url="jdbc:mysql://localhost:3306/javaee"
             user="root" pass="*******" sql="select * from news_inf" />
</body>
</html>
