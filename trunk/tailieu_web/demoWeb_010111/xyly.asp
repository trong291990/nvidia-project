<%@LANGUAGE="JAVASCRIPT"%>
<html>
	<head></head>
	<%
		username = "" +Session("User");
		if(username=="undefined")
			Response.Redirect("login.asp");
				
		//thiet lap ket noi
		DBPath=Server.MapPath("db/QLHH.mdb");
		conn=Server.CreateObject("ADODB.Connection");
		conn.ConnectionString="Provider=Microsoft.Jet.OLEDB.4.0; Data Source="+DBPath+"";
		conn.Open();
		action = "" + Request.QueryString("action");
		if(action=="them")
		{
			//Thuc hien them moi
			mahang = "" + Request.Form("mahang");
			tenhang = "" + Request.Form("tenhang");
			soluong = "" + Request.Form("soluong");
			dongia = "" + Request.Form("dongia");
			nsx = "" + Request.Form("nsx");
			if(tenhang!="undefined" && tenhang!="" && soluong!="undefined" && soluong!="" && dongia!="undefined" && dongia!="" && nsx!="undefined" && nsx!=""){
			Response.Write(mahang);
			Response.Write(tenhang);
			Response.Write(soluong);
			Response.Write(dongia);
			Response.Write(nsx);
			sqlinsert="insert into MAT_HANG values('"+mahang+"','"+tenhang+"',"+soluong+","+dongia+",'"+nsx+"')";
			conn.Execute(sqlinsert);}
			//Response.Redirect("danhmucmathang.asp");
		}
		
		if(action=="xoa")
		{			
			mahang = "" + Request.QueryString("mahang");
			sqldelete="delete from MAT_HANG where MaHang='"+mahang+"'";
			conn.Execute(sqldelete);			
			Response.Redirect("danhmucmathang.asp");
		}
		if(action=="capnhat")
		{		
			//thuc hien cap nhat
			mahang="" + Request.Form("mahang");
			tenhang="" + Request.Form("tenhang");
			soluong="" + Request.Form("soluong");
			dongia="" + Request.Form("dongia");
			nsx="" + Request.Form("nsx");
			if(tenhang!="undefined" && tenhang!="" && soluong!="undefined" && soluong!="" && dongia!="undefined" && dongia!="" && nsx!="undefined" && nsx!=""){
				sqlupdate="update MAT_HANG set TenHang='"+tenhang+"', SoLuong="+soluong+", DonGia="+dongia+", MaNsx='"+nsx+"'";
				sqlupdate+=" where MaHang='"+mahang+"'";
				conn.Execute(sqlupdate);}
				//Response.Write("Cap nhat thanh cong!");
				Response.Redirect("danhmucmathang.asp");
		}
		conn.Close();
	%>
	<body></body>
</html>