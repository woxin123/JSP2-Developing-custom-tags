<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/21
  Time: 1:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@taglib prefix="simple" uri="/WEB-INF/mytaglib.tld" %>
<html>
<head>
    <title>测试DataFormatterTag</title>
</head>
<body>
<simple:dataFormatter header="字母" item="A,B,C,D"/>
<br/>
<simple:dataFormatter header="国家">
    <jsp:attribute name="item">
        美国,中国,加拿大
    </jsp:attribute>
</simple:dataFormatter>
<div style='padding:10px;border:1px;solid:black;"
             + "border-radius:20px'>
</div>
</body>
</html>
