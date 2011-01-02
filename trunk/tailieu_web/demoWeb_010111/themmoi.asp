<%@LANGUAGE="JAVASCRIPT"%>
<html>
	<head><title>THEM MOI SAN PHAM</title></head>
	<%
		//kiem tra user da login chua???
		username=""+Session("User");
		if(username=="undefined")
			Response.Redirect("login.asp");
		
		//thiet lap ket noi	
		DBPath=Server.MapPath("db/QLHH.mdb");
		conn=Server.CreateObject("ADODB.Connection");
		conn.ConnectionString="Provider=Microsoft.Jet.OLEDB.4.0; Data Source="+DBPath+"";
		conn.Open();
		
		//Lay thong tin NSX
		sql="select * from NHA_SAN_XUAT";
		rs=Server.CreateObject("ADODB.Recordset");
		rs=conn.Execute(sql);		
	%>
	<body>
		<h1>Them moi san pham</h1>
		<form action="xyly.asp?action=them" method="post">
			Ma hang: <input type="text" name="mahang"/><br/>
			Ten hang: <input type="text" name="tenhang"/><br/>
			So luong: <input type="text" name="soluong"/><br/>
			Don gia: <input type="text" name="dongia"/><br/>
			Ten nha san xuat: 
			<select name="nsx">
			<%while(!rs.EOF){%>
				<option values="<%=rs("MaNsx")%>"><%=rs("TenNsx")%></option>
			<%rs.MoveNext();
			}rs.Close();%>
			</select>
			<br/>
			<input type="submit" value="Cap nhat"/>
		</form>
	</body>
	<%conn.Close();%>
</html>