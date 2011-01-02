<%@LANGUAGE="JAVASCRIPT"%>
<html>
	<head>
		<title>LOGIN</title>
		<meta content="text/html; charset=utf-8" />
	</head>
	<body>
		<%
			var ten = "" + Request.Form("tendangnhap");
			var mk = "" + Request.Form("matkhau");
			Session("User")=ten;
			
			if(ten!="undefined" && ten!="" && mk!="undefined" && mk!="")
			{
				DBPath=Server.MapPath("db/QLHH.mdb");
				Response.Write(DBPath);
				conn = Server.CreateObject("ADODB.Connection");
				conn.ConnectionString="Provider = Microsoft.Jet.OLEDB.4.0; Data Source ="+DBPath+"";
				conn.Open();
				rs = Server.CreateObject("ADODB.Recordset");
				sql="select * from TAI_KHOAN where TenDangNhap='"+ten+"' and MatKhau='"+mk+"'";		
				rs=conn.Execute(sql);
				if(!rs.EOF)
					Response.Redirect("danhmucmathang.asp");
				else
					Response.Write("Ten dang nhap hoac Mat khau khong hop le!");
				rs.Close();
				conn.Close();
			}		
		%>
		<form action="login.asp" method="post">
			<h1>DANG NHAP</h1>
			Ten dang nhap: <input type="text" name="tendangnhap"/><br/>
			Mat khau: <input type="password" name="matkhau"/><br/>
			<input type="submit" value="Dang nhap"/>
		</form>
	</body>
</html>