<%@LANGUAGE="JAVASCRIPT"%>
<html>
	<head>
		<title>demo 1</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8">
	</head>
	<body>
		<%
			ds1 = "" + Request.Form("dayso1");
			ds2 = "" + Request.Form("dayso2");
			ds3 = "" + Request.Form("dayso3");
			choose = "" + Request.Form("group");		
			if(choose=="Tron")
			{
				if(ds2!="undefined" && ds2!="" && ds3!="undefined" && ds3!="")
					Response.Write("successfull");
				else
					Response.Write("Dãy số 2 hoặc dãy số 3 chưa có giá trị!");
			}
			if(choose=="Tach")
			{
				if(ds1!="undefined" && ds1!="")
					Response.Write("successfull");
				else
					Response.Write("Dãy số 1 chưa có giá trị!");
			}
		%>
		<form action="demo1.asp" method="post">
			Dãy số 1: <input type="text" name="dayso1"/><br/>
			Trộn <input type="radio" value="Tron" name="group" checked="checked"/> &nbsp;&nbsp; 
			Tách <input type="radio" value="Tach" name="group"/><br/>
			Dãy số 2: <input type="text" name="dayso2"/><br/>
			Dãy số 3: <input type="text" name="dayso3"/><br/>
			<input type="submit" value="Xử lý"/>&nbsp;<input type="button" value="Đóng cửa sổ" onClick="window.close();"/>
		</form>
	</body>
</html>