<%@ page import="file.FileDTO" %>
<%@ page import="file.FileDAO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 파일 업로드</title>
</head>
<body>
<%
	ArrayList<FileDTO> fileList = new FileDAO().getList();
	for(FileDTO file : fileList){
		out.write("<a href=\""+request.getContextPath()+"/downloadAction?file="
				+java.net.URLEncoder.encode(file.getFileRealName(),"UTF-8")+"\">"+
				file.getFileName() + "(다운로드횟수 :"+file.getDownloadCount()+")</a><br>");
	}
%>
</body>
</html>

