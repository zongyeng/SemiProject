<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background-image: linear-gradient(to top, #a8edea 0%, #fed6e3 100%);
	background-attachment: fixed;
	background-repeat: no-repeat; }
	
.ee { display : block;
	width: 45%;
	margin: 0px auto;
}
.ff{ display : block;
	width: 45%;
	margin: 0px auto;
}
body {
	text-align: center;
}
h1{
	color: blue;
}
input{
	background-color:skyblue;
	color: black;
	size:10px;
}
.a{
	text-decoration: none;
	color: black;
}
.b:hover{
	cursor: pointer;
	

}
</style>
</head>
<body>
	<%@ include file="./form/header.jsp"%>


	<div>
		<a class="b" href=""><img class="ee" src="images/ee.jpg" alt=""></a>
	</div><br/>
		<h1><a class="a" href="">신도림 디큐브 아트센터</a></h1>
		<br/>
	<div>
		<a class="b" href=""><img class="ff" src="images/ff.jpg" alt=""></a>
	</div><br/>
		<h1><a class="a" href="">청담동 SAC 아트홀</a></h1>
		<br/>

<%@ include file="./form/footer.jsp"%>
</body>
</html>