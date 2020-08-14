<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
${sessionScope.id }님 로그인 성공<br>
<a href="${pageContext.request.contextPath }/SearchController"> 내정보수정</a><br>
<a href="${pageContext.request.contextPath }/LogoutController"> 로그아웃</a><br>
<a href="${pageContext.request.contextPath }/DelController"> 탈퇴</a><br>
<a href="${pageContext.request.contextPath }/seller/List"> 쇼핑몰</a><br>

</a></body>
</html>