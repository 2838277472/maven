<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/TextDemo/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/TextDemo/themes/default/easyui.css">
<script type="text/javascript" src="/TextDemo/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="/TextDemo/jquery.easyui.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('#dg').datagrid({    
		    url:'list.sw', 
		    queryParams: {
				name: '',
				id:0
			},
		    columns:[[    
		        {field:'id',title:'编号',width:100},    
		        {field:'org_name',title:'组织名称',width:100,formatter:function(value,row,index){
		        	return row.org?row.org.org_name:"--";
		        }},    
		        {field:'emp_no',title:'工号',width:100},
		        {field:'name',title:'姓名'},
		        {field:'sex',title:'性别'},
		        {field:'degree',title:'学历'},
		        {field:'update_date',title:'更新时间'}
		    ]]    
		});  

	})
	
	$(function(){
		$('#dg').datagrid({
			toolbar:'#f'
		});
	})
	
	$(function(){
		$.getJSON('list2.sw',{},function(data){
			$("<option></option>").attr("value",0).text("请选择").appendTo("#id");
			$.each(data,function(i,n){
				$("<option></option>").attr("value",n.id).text(n.org_name).appendTo("#id");
			})
		});
	})
	
	function cx(){
		$("#dg").datagrid('reload',{
			name:$("#f input[name='name']").val(),
			id:$("#id").val()
		})
	}
</script>
</head>
<body>
<form id="f" method="POST">
姓名：<input type="text" name="name">&nbsp;组织<select name="id" id="id"></select> &nbsp;<input type="button" value="查询" onclick="cx()">
</form>
<a href="/TextDemo/add.sw">添加</a>
<table id="dg"></table>
</body>
</html>