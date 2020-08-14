<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
	<script>
		function a(){
			var flag = confirm("정말 삭제하시겠습니까?");
			if(flag){
				document.f.action="${pageContext.request.contextPath}/seller/Del?num=${p.num}";
				document.f.submit();
			}else{
				alert("삭제가 취소되었습니다.");
			}
		}
	</script>
</head>
<body>
	<form name="f" action="${pageContext.request.contextPath }/seller/Edit" method="post">
		<table border = "1">
			<tr>
			<th>상품명</th><td><input type="text" value="${p.name }" name="name"></td>
			</tr>
			<tr>
			<th>가격</th><td><input type="text" value="${p.price}" name="price"></td>
			</tr>
			<tr>
			<th>수량</th><td><input type="text" value="${p.quantity }" name="quantity"></td>
			</tr>
			<tr>
			<th>상품 이미지</th><td>${p.img }<br><img src="${p.img }" width="300" height="300"/></td>
			</tr>
			<tr>
			<th>상품 상세설명</th><td><input type="text" value="${p.content}" name="content"></td>
			</tr>
			<td colspan="2"><input type="submit" value="수정">
			<input type="button" value="삭제" onclick ="a();"></td>
			
		</table>
		<input type="hidden" name="num" value="${p.num}">
	</form>
</body>
</html>