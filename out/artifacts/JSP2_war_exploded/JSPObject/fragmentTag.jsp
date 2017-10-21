<%--
  Created by IntelliJ IDEA.
  User: 孟晨
  Date: 2017/10/21
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java" %>
<%@taglib prefix="mytag" uri="/WEB-INF/mytaglib.tld" %>
<html>
<head>
    <title>测试：以页面片段作为标签属性</title>
</head>
<body>
<h2>下面显示的是自定义标签中的内容</h2>
<mytag:fragment>
<jsp:attribute name="fragment">
    <%-- 使用后jsp:attribute标签传入fragment参数（改注释不能放在fragment内） --%>
    <mytag:helloWorld/>
</jsp:attribute>
</mytag:fragment>
<br/>
<mytag:fragment>
<jsp:attribute name="fragment">
<!-- 下面是动态的JSP页面 -->
    ${pageContext.request.remoteAddr}
</jsp:attribute>
</mytag:fragment>
<br/>
</body>
</html>
