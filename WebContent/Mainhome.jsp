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
	.section1div2 { width : 1256px; height :600px; margin:20px auto;}
	.section1div2div1 { width : 1256px; height: 50px; color : black;
					font-size: 30px; text-align: center; padding-top: 10px;
					font-weight: bold; display : table;} 
	.section1div2div1div {display: table-cell; vertical-align: middle;
						border-top: 2px groove gray; border-bottom:2px double gray;}
	.section1div2div2 {width : 1256px; height :600px; margin:20px auto;}
	.section1div2div2div1 { display : flex; }
	.section1div2div2div1div { display : flex-basis; width : 250px; height: 250px;
								border : solid 1px;}
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
		<div class = "section1div2div1">
			<div class = "section1div2div1div">
			<span> 음악 top10 </span>
			</div>
		</div>
		<div class = "section1div2div2">
			<div class = "section1div2div2div1">
				<div class = "section1div2div2div1div">
					<div>
						<img src="" alt ="앨범이미지1"/>
					</div>
					<div>
						<span></span>
					</div>
				</div>
				<div class = "section1div2div2div1div">
				</div>
				<div class = "section1div2div2div1div">
				</div>
				<div class = "section1div2div2div1div">
				</div>
				<div class = "section1div2div2div1div">
				</div>
			</div>
			<div class = "section1div2div2div1">
				<div class = "section1div2div2div1div">
				</div>
				<div class = "section1div2div2div1div">
				</div>
				<div class = "section1div2div2div1div">
				</div>
				<div class = "section1div2div2div1div">
				</div>
				<div class = "section1div2div2div1div">
				</div>
			</div>
		</div>
	</div>
	
	
</section>
<%@ include file="./form/footer.jsp"%>
</body>
</html>