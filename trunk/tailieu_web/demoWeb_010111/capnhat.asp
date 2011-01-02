<%@LANGUAGE="JAVASCRIPT"%>
<html>
	<head><title>CAP NHAT</title></head>
	<%
		//kiem tra user da login chua???
		username = "" +Session("User");
		if(username=="undefined")
			Response.Redirect("login.asp");
			
		//thiet lap ket noi
		DBPath = Server.MapPath("db/QLHH.mdb");
		conn=Server.CreateObject("ADODB.Connection");
		conn.ConnectionString="Provider = Microsoft.Jet.OLEDB.4.0; Data source="+DBPath+"";
		conn.Open();
		
		//lay thong tin mat hang tuong ung
		mahang = Request.QueryString("mahang");
		if(mahang!="undefined" && mahang!=""){
			rs=Server.CreateObject("ADODB.Recordset");
			rs1=Server.CreateObject("ADODB.Recordset");
			sql="select * from MAT_HANG where MaHang='"+mahang+"'";
			sql1="select * from NHA_SAN_XUAT";
			rs=conn.Execute(sql);
			rs1=conn.Execute(sql1);
		}
			
		if(!rs.EOF)		
		{
			maNSX = "" + rs("MaNsx");
	%>
	<body>
		<h1>CAP NHAT</h1>
		<form action="xyly.asp?action=capnhat" method="post">
			Ma hang: <input type="text" name="mahang" readonly="true" value="<%=mahang%>"/><br/>
			Ten hang: <input type="text" name="tenhang" value="<%=rs("TenHang")%>"/><br/>
			So luong: <input type="text" name="soluong" value="<%=rs("SoLuong")%>"/><br/>
			Don gia: <input type="text" name="dongia" value="<%=rs("DonGia")%>"/><br/>
			Ten nha san xuat: 
			<select name="nsx">
			<%while(!rs1.EOF){
				maNSX_1 = "" + rs1("MaNsx");
				if(maNSX==maNSX_1){%>
				<option value="<%=rs1("MaNsx")%>" selected="selected"><%=rs1("TenNsx")%></option>
			<%}else{%>
				<option value="<%=rs1("MaNsx")%>"><%=rs1("TenNsx")%></option>
			<%}rs1.MoveNext();}
			rs1.Close();%>
			</select>
			<br/>
			<input type="submit" value="Cap nhat"/>
		</form>
	</body>
	<%rs.MoveNext();}
	rs.Close();
	conn.Close();%>
</html>
