<%@ page import="file.FileDAO" %>
<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 파일 업로드</title>
</head>
<body>
	<%
		String directory = "C:/JSP/upload";//application.getRealPath("/upload/");
		int maxSize = 1024 * 1024 * 100;
		String encoding = "UTF-8";
		
		MultipartRequest mulitpartRequest=
				new MultipartRequest(request,directory,maxSize,encoding,
						new DefaultFileRenamePolicy());
		String fileName = mulitpartRequest.getOriginalFileName("file");
		String fileRealName = mulitpartRequest.getFilesystemName("file");
		if(!fileName.endsWith(".doc") &&!fileName.endsWith(".hwp") 
				&&!fileName.endsWith(".pdf") &&!fileName.endsWith(".xls")){
			File file = new File(directory + fileRealName);
			file.delete();
			out.write("업로드할 수 없는 파일입니다.");
		}// 시큐어 코딩 적용
		else{
			new FileDAO().upload(fileName,fileRealName);
			out.write("파일명" + fileName + "<br>");
			out.write("실제파일명" + fileRealName + "<br>");
		}
		
	%>
</body>
</html>

