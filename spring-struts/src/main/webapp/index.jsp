<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
<%--<form action="login">
    姓名<s:property value="user.userName" />
    密码<s:property value="user.passWord" />
</form>--%>
<s:form action="login">
    姓名:<s:textfield name="userName"/>
    密码:<s:textfield name="passWord"/>
    <s:submit value="登入"/>
    <input type="submit" value="注册" onclick="regist();"
</s:form>
</body>

<script type="application/javascript">
    function regist() {
        targetForm = document.form[0];
        targetForm.action = "login!regist";
    }


</script>
</html>
