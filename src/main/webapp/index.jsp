<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    request.setAttribute("rnum",12);
%>

<html>
<head>
    <title>Hello World!</title>
</head>
<body>
    <h1>main page</h1>
    <h2><a href="index">test index</a></h2>
    <h2><a href="login.jsp">test login</a></h2>
    <h2><a href="ueditor.jsp">test 富文本</a></h2>
</body>
</html>
