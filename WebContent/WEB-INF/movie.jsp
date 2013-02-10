<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>DONE</title>
</head>

<body>

<form name="form1" >

<TABLE BORDER=10>
<%
     {
        %>
        <TR>
        
        <TD><label>Title : </label><%= request.getAttribute("title") %></TD>
        </TR>
        <TR>
        <TD><label>Genre : </label><%= request.getAttribute("genre") %></TD>
        </TR>
        <TR>
        <TD><label>Release Date : </label><%= request.getAttribute("date") %></TD>
        </TR>
        <TR>
        <TD><label>Poster : </label><%= request.getAttribute("poster") %></TD>
        </TR>
        <%
    }
%>
</TABLE>

</form>

</body>
</html>