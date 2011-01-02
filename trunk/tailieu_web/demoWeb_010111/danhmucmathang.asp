<%@LANGUAGE="JAVASCRIPT"%>
<html>
	<head>
		<title>DANH MUC MAT HANG</title>
	</head>
	<body>
		<%
			username = "" +Session("User");
			if(username=="undefined")
				Response.Redirect("login.asp");
			//Session.Abandon(); //sau khi refresh se quay tro lai trang login.asp
			//Response.Write(username);	
			DBPath = Server.MapPath("db/QLHH.mdb");
			conn=Server.CreateObject("ADODB.Connection");
			conn.ConnectionString="Provider = Microsoft.Jet.OLEDB.4.0; Data source="+DBPath+"";
			conn.Open();
			sql="select mh.MaHang,mh.TenHang,mh.SoLuong,mh.DonGia,nsx.TenNSX";
			sql+=" from MAT_HANG mh,NHA_SAN_XUAT nsx where nsx.MaNsx=mh.MaNsx";
			rs=Server.CreateObject("ADODB.Recordset");
			rs=conn.Execute(sql);
		%>
		<center><h1>DANH MUC MAT HANG</h1></center>
		<table border="1">
			<tr>
				<th>MA HANG</th>
				<th>TEN HANG</th>
				<th>SO LUONG</th>
				<th>DON GIA</th>
				<th>TEN NHA SAN XUAT</th>
				<th>CAP NHAT</th>
				<th>XOA</th>
			</tr>
			<% while(!rs.EOF){%>
			<tr>
				<td><%=rs("MaHang")%></td>
				<td><%=rs("TenHang")%></td>
				<td><%=rs("SoLuong")%></td>
				<td><%=rs("DonGia")%></td>
				<td><%=rs("TenNsx")%></td>
				<td><a href="capnhat.asp?mahang=<%=rs("MaHang")%>">Cap nhat</a></td>						
				<td><a href="xyly.asp?action=xoa&mahang=<%=rs("MaHang")%>" onClick="return confirm('Ban muon xoa mat hang: <%=rs("TenHang")%>')">Xoa</a></td>				
			</tr>
			<%rs.MoveNext();
			}rs.Close();%>
		</table>
		<a href="themmoi.asp">Them moi</a>
		<%conn.Close();%>
	</body>
</html>