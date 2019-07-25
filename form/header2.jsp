<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>T I T</title>

<style type="text/css">
	*{ margin : 0px; padding : 0px;}
	.header{background-color: #212226;}
	#stovebar{	height : 100px; vertical-align : middle;}	
	#stovebar .stovebarleft{ position : relative; left: 130px; top : 13px; margin : 15px;
				font-size : 14px;}
	.stovebarleft:hover { cursor : pointer; }
	#stovebar .stovebarright{ position : relative; left: -40px; top : 3px; margin : 15px; font-size : 14px;
							float : right; text-decoration:none; color:#000000;}
	#stovebar img{ position : relative; left: 45%; top : 10px; }
	
	
    #menutop { height : 90px; border-bottom-style: solid; border-bottom-width:1px;
			border-bottom-color : rgba(255,255,255,0.10);}
			
	#menutop a { display: inline; color:White; font-family: "Goyang"; font-size: 20px;
				margin : 25px; height : 40px; position : relative; left: 80px; top: 5px;
				}
	#menubottom	{position :absolute; clear: left; float: left;
				left:0px; bottom:0px;
				background: rgba(0,0,0,0.55);
				width : 100%; height : 60px;
				color : White;
				}		
				
	#wholemenu { width : 100%; height: 670px; align : left;
				 padding : 0px;
				 background-repeat:no-repeat;
				 background-position :-300px;
				 background-image:url("resources/banner/445e2301c9d14db7bbd119cdfe03fe2e.jpg");
				 position : relative; left:0px; right:0px;}
	#menutop span { width :72px; height : 72px; 
					margin-right : 0px; margin-bottom : 0px; }		
	
	.loginbutton { position: relative; float : right; left : -40px; top: 30px; width :140px; height: 42px;}
	.loginbuttondiv {position: relative; 
					border-width : 1px; border-style:solid; border-color : rgba(255,255,255,0.2); 
					width :140px; height: 40px; text-align : center; color : White; 
					}
	
	.loginbutton:hover {background : White; color:black; font-color : black;}
	.introclassdiv1{ margin-top:10px; color :inherit; cursor : pointer; }

</style>
</head>
<body>

	<header class = "header">
			<div id = "stovebar">
				<a href = "https://www.onstove.com/">
					<img alt="bi" src="resources/mcc-logo-white.png" width = "250px" height = "80px">
				</a>
				<div class = "loginbutton">
							<div class = "loginbuttondiv">
								<div onclick = "location.href =''" class ="introclassdiv1"> <strong>로그인 </strong></div>
							</div>
				</div>
			</div>
			<div id = "wholemenu">
			<div id = "menutop">
				<div class = "menutopdiv1">
					<div onclick = "location.href = 'https://lostark.game.onstove.com/Main'"class = "lostarkbiglogo"> </div>
				</div>	
				<div class = "menutopdiv2"> 
					<div class = "menutopdiv2div" >
						<a href = "https://lostark.game.onstove.com/News/Notice/List" style ="text-decoration : none;"> 음악 </a>
						<a href ="https://lostark.game.onstove.com/WorldView" style ="text-decoration : none;"> 작곡가 </a>
						<a href ="https://lostark.game.onstove.com/GameGuide" style ="text-decoration : none;" target = black> 방송 </a>
						<a href ="https://lostark.game.onstove.com/ItemDictionary" style ="text-decoration : none;"> 공연장 </a>
						<a href ="https://lostark.game.onstove.com/Community/Free/List" style ="text-decoration : none;"> 커뮤니티 </a>
						<a href ="https://lostark.game.onstove.com/Shop/List/Package" style ="text-decoration : none;"> 고객센터 </a>
					</div>
				</div>
				<div class = "menutopdiv3">
							<a onclick = "registForm()">
								<img class ="menutopdiv3img" alt="bi" src="resources/layout/bt_header_gamestart.png" align="right"/>
							</a>
				</div>
			</div>
			<div onclick = "link()" id ="menumiddle">
			</div>
			
			<div id = "menubottom">
				<div class = "menubottomdiv">
					<div onclick = "menuleft()" class = "menubottomdivimg">
						<img class = "menubottomimg1" src=""/>
					</div>
					<div class = "menubottomdivdiv" onclick = "event1()">
						<span id = "menubottomdivspan0"> 일일 에포나 의뢰 개선!</span>
					</div>
					<div class = "menubottomdivdiv" onclick = "event2()">
						<span id = "menubottomdivspan1"> 호감도 원정대 통합!</span>
					</div>
					<div class = "menubottomdivdiv" onclick = "event3()">
						<span id = "menubottomdivspan2"> 폭신폭신 강아지를 부탁해! PC방 해피위크!</span>
					</div>
					<div class = "menubottomdivdiv" onclick = "event4()">
						<span id = "menubottomdivspan3"> 슈퍼빙고 완성하GO 빙고 인형탈 받GO!</span>
					</div>
					<div class = "menubottomdivimg" onclick = "menuright()" >
						<img class = "menubottomimg2" src=""/>
					</div>
				</div>
			</div>
		</div>
		</header>
</body>
</html>

