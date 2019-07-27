<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.wholesection{width : 100%; height:2000px;}
	.section1 {width:100%; height : 1000px;}
	.section1div {width : 1000px; height : 1000px;
					margin-left : auto; margin-right : auto;
					margin-top : 100px;}
	.section1divtable {text-align: center;}
	.section1divtablecaption {height : 30px; margin-bottom:30px;
								font-size: 20px; border-bottom : 1px solid black;
								border-top : 1px solid black;}
	.section1divtablecaption a {text-decoration: none; color : black;}
	
	.section2 {width:100%; height : 1000px;}
	.section2div {width : 1000px; height : 1000px;margin-left : auto;
			      margin-right : auto; margin-top : 100px;
			      display : flex;}
	.section2div {display: flex-basis; width : 300px;
				margin-right: 50px;}      
</style>
</head>
<body>
<%@ include file="./form/header.jsp"%>
<section class ="wholesection">
	<section class ="section1"> <!-- 뮤직 탑 10/ 테이블로 (인기음악) -->
		<div class = "section1div">
			<table class = "section1divtable" border= "1" >
				<caption class = "section1divtablecaption"><a href="">인기차트</a> </caption>
				<colgroup>
					<col width = "100px"> <!-- 앨범이미지 -->
					<col width = "100px"> <!-- 등수 숫자  -->
					<col width = "800px"> <!-- 곡 이름 -->
				</colgroup>
				<thead>
				</thead>
				<tbody> <!-- 10개 까지만 출력 -->
				<% for(int a=1; a<=10; a++) {%>
					<tr height = 100px;>
						<td>여기는 앨범</td>
						<td><%= a %></td>
						<td>곡 이름출력<%= a %></td>
					</tr>
				<%}%>
				</tbody>
			</table>
		</div>
	</section>
	<section class ="section2"> <!-- 신규음악 /추천음악 /장르음악 // 사진3개 일렬로, 누를시 링크이동-->
		<div class = "section2div">
			<div class = "section2divdiv">
			</div>
			<div class = "section2divdiv">
			</div>
			<div class = "section2divdiv">
			</div>
		</div>
	</section>
</section>
<%@ include file="./form/footer.jsp"%>
</body>
</html>