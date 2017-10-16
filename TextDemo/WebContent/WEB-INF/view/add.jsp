<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/TextDemo/jquery-1.8.0.min.js"></script>
<script>
$(function(){
	$.getJSON('list2.sw',{},function(data){
		/* $("<option></option>").attr("value",0).text("请选择").appendTo("#id"); */
		$.each(data,function(i,n){
			$("<option></option>").attr("value",n.id).text(n.org_name).appendTo("#id");
		})
	});
})
</script>
</head>

<body>

<a href="s.sw">返回</a>

<form method="POST" action="add.sw">
工号：<input type="text" name="emp_no"><br>
姓名：<input type="text" name="name"><br>
性别：<input type="radio" name="sex" value="男">男&nbsp;<input type="radio" name="sex" value="女">女<br>
学历：<input type="text" name="degree"><br>
组织：<select name="org_id" id="id"></select>
<input type="submit" value="保存">
</form>

</body>
</html>