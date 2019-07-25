<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header design</title>
<style type="text/css">
	*{ padding : 0px; margin : 0px;}
	.header{ widt : 100%; height : 200px;}
	.headerdiv1{ width: 100%; height :150px;
				background-color: snow;}
	.headerdiv2{ width: 100%; height :50px; 
					border-bottom : solid 2px;
					border-bottom-color: rgba(200,200,200,0.5); 
					border-top: solid 2px;
					border-top-color: rgba(200,200,200,0.5); 
				}
	.headerdiv1div { width:1200px; height:150px; margin : 0 auto; }
	.headerdiv1divdiv { width : 300px;margin-left : 70px;}
	.headerdiv2div a{ padding :2px 20px; margin: 10px; font-size: 35px;
					vertical-align : middle; font-family: "Goyang";}
	.headerdiv2div { width : 1200px; margin : 0 auto;
					 vertical-align : middle;
					 display : flex;}
	.headerunderdiv { width : 100%; height : 200px; margin : 0 auto;}
	.headerdiv2divdiv { width : 20%; height: 50px; 
						display: flex-basis; text-align: center; }
						
	.hedaerdiv3 { display : none; width : 100%; height : 300px; 
					background-image: linear-gradient;}
</style>
</head>
<body>


	<header class = "header">
		<div class = "headerunderdiv">
			<div class="headerdiv1">
				<div class="headerdiv1div">
					<div class = "headerdiv1divdiv">
						<a href = "" class="headerdiv1a"><!-- 홈으로 링크 -->
							<img alt="Mutes logo" src="resources2/mutes2.png" width = "300px" height = "150px">
						</a>
					</div>
				</div>
			</div>
		
			<div class="headerdiv2">
				<div class="headerdiv2div">
					<div class="headerdiv2divdiv">
					<a href ="" style ="text-decoration : none;"> <strong>음악 </strong></a>
						</div>
					<div class="headerdiv2divdiv">
					<a href ="" style ="text-decoration : none;"> <strong>작곡가 </strong> </a>
						</div>
					<div class="headerdiv2divdiv">
					<a href ="" style ="text-decoration : none;"> <strong>방송 </strong></a>
						</div>
					<div class="headerdiv2divdiv">
						<a href ="" style ="text-decoration : none;"> <strong>공연장 </strong></a>
					</div >
					<div class="headerdiv2divdiv">
						<a href ="" style ="text-decoration : none;"> <strong>커뮤니티 </strong></a>
					</div>
					<div class="headerdiv2divdiv">
						<a href ="" style ="text-decoration : none;"> <strong>고객센터</strong> </a>
					</div>
				</div>
			</div>
			<div class="headerdiv3">
				<div class="headerdiv3div">
					
				</div>
			</div>
		</div>
	</header>
</body>
</html>