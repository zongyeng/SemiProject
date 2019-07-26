<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<style type="text/css">
	.section1 { width : 100%; height : 2000px;}
	.section1div1 { width : 1256px; height :600px; margin:0 auto;
					 background-image:url("images/musicpicture2.jpg");
					 background-repeat: no-repeat;
					 background-position: -300px;
					 position: relative; overflow: hidden;}
	.section1div1div { width : 1256px; height: 100px; color : white;
					font-size: 30px; text-align: center; padding-top: 50px;
					font-weight: bold;}

</style>
</head>
<body>
<%@ include file="./form/header.jsp"%>
<section class = "section1">
	<div class = "section1div1">
		<div class = "section1div1div">
			<span> 여러분의 음악을 공유하세요! </span>
		</div>
	</div>
	<div class = "section1div2">
		<div class = "section1div2div">
		</div>
	</div>
	
</section>
<%@ include file="./form/footer.jsp"%>
</body>
</html>