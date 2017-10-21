<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/21
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@taglib prefix="mytag" uri="/WEb-INF/mytaglib.tld" %>
<html>
<head>
    <title>测试动态属性的标签</title>
</head>
<body>
<h2>下面显示的是自定义标签的内容</h2>
<h4>指定两个属性</h4>
<mytag:dynaAttr name="你的名字" age="10000"/>
<h4>指定4个属性</h4>
<mytag:dynaAttr name="星武者" age="20" work="暂无" birthday="****年**月**日"/>
</body>
</html>
