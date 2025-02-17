<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header design</title>
<style type="text/css">
	*{ padding : 0px; margin : 0px;}
	.header{ width : 100%; height : 154px; 
	font-family: "Goyang"; }
	.headerdiv1{ width: 100%; height :100px;
				background-image: linear-gradient(-225deg, #E3FDF5 0%, #FFE6FA 100%);
				background-image: linear-gradient(to top, #a8edea 0%, #fed6e3 100%);	}
	.headerdiv2{ 	width: 100%; height :50px; 
					border-bottom : solid 2px;
					border-bottom-color: rgba(200,200,200,0.5); 
					border-top: solid 2px;
					border-top-color: rgba(200,200,200,0.5); 
					background: rgb(100,100,100);
				}
	.headerdivwrapa {float : left; width : 20%; height : 100px; text-align:center;}

	.headerdiv1div { width:70%; height:150px; margin : 0 auto; }
	.headerdiv1divdiv { width : 100%; height : 96px;}
	.headerdiv2div a{ padding :2px 20px; margin: 10px; font-size: 15px;
					vertical-align : middle; font-family: "Goyang";
					font-weight:bold;}
	.headerdiv2div { width : 70%; margin : 0 auto; height : 50px;
					 vertical-align : middle;
					 display : flex;}
	.headerdiv2divul{list-style: none;width : 100%;}	
	.headerdiv2divulli {float : left; width : calc(20% - 1.2px); height : 50px;text-align:center;
						border-left : 1px solid; border-left-color:rgba(200,200,200,0.5); 
						border-bottom : solid 2px;
						border-bottom-color: rgba(200,200,200,0.5);
						position : relative;  }
	.headerdiv2divullia {line-height:50px; text-decoration: none;
							font-weight:bold; color:#cccccc; } 
	.headerdiv2divulli:hover { background: rgb(80,80,80); transition : 0.5s;}						
	.headerdiv2divulli:hover .headerdiv2divullia{ color:#ffffff;}		
	.headerdiv2divulli:hover .headerdiv2divulliul{display : block; z-index:200;
													border-top : solid 2px;
													border-top-color: rgba(30,110,150,0.5); }			 
	.headerdiv2divulliul li{list-style: none;width : 100%;}				 
					 
	.headerunderdiv { width : 100%; height : 154px; margin : 0 auto;}
	.headerdiv2divulliul {display : none; background: rgb(100,100,100); width:100%; 
	 					  line-height:50px; position : absolute; z-index:200;}
	.headerdiv2divulliul li {border-bottom : solid 2px; 
							border-bottom-color: rgba(200,200,200,0.5);}
	.headerdiv2divulliul > li a { text-decoration: none;
							font-weight:bold; color:#cccccc;}
	.headerdiv2divulliul li:hover{background: rgb(80,80,80); transition : 0.5s;}
	.headerdiv2divulliul li:hover >a{color:#ffffff;}
	
						
	.hedaerdiv3 { display : none; width : 100%; height : 300px;}
	
	 #search { height: 30px; width: 95%; border: none;
 			 border-radius: 10px; padding: 5px;  }
	 #search:focus {outline : none;}
	.searchbar{ padding: 30px; width : 45%; }
 	.searchbardiv {display: flex; margin-left : 10px; width:80%; margin : 0 auto; text-align: center;}
    .searchbardivbtn { width : 40px; height: 40px; background-color: rgba(200,200,200,0.5);
  				  margin-left: 5px;border: none; border-radius: 10px;}
    .searchbardivbtn:hover {background-color: #B6B6B6; transition: .8s; cursor: pointer;}
    .searchbardivbtn:focus {outline : none;}
    
    .logindiv {padding-top:35px; padding-bottom: 35px; padding-right: 5px; width : 20%;}
    .logindivdiv {display : flex; width:80%; margin : 0 auto;}
    .logindivdivbtn { width : 100px; height: 30px; background-color: rgba(200,200,200,0.5);
  				  margin-left: 15px;border: none; border-radius: 10px; }
  	.logindivdivbtn:hover {background-color: #B6B6B6; transition: .8s; cursor: pointer;}			  
	.logindivdivbtn:focus {outline : none;}
</style>
</head>
<body>


	<header class = "header">
		<div class = "headerunderdiv">
			<div class="headerdiv1">
				<div class="headerdiv1div">
					<div class = "headerdiv1divdiv">
						<div class = "headerdivwrapa">
						<a href = "" class="headerdiv1a"><!-- 홈으로 링크 -->
							<img alt="Mutes logo" src="images/mutes2.png" width = "200px" height = "100px">
						</a>
						</div>
						
						<div class="logindiv" style="float : right;">
  							<div class="logindivdiv">
  								<button class="logindivdivbtn">
     								로그인   
   							    </button>  
   							    <button class="logindivdivbtn">
     								회원가입
   							    </button>    
 							</div>
						</div>
						
						<div class="searchbar" style="float : right;">
  							<div class="searchbardiv">
   								<input type="text" id="search" type="text" placeholder="Search"/>
  								<button class="searchbardivbtn">
     								<img src="images/search.png" alt="대충 돋보기이미지" width="35px" height="35px"/>     
   							    </button>    
 							</div>
						</div>
						
						
					</div>
				</div>
			</div>
		
		
			<div class="headerdiv2">
				<div class="headerdiv2div">
					<ul class = "headerdiv2divul">
						<li class = "headerdiv2divulli">
							<a class = "headerdiv2divullia" href =""> 음악 </a>
							<ul class = "headerdiv2divulliul">
								<li><a href=""> 장르별 음악 </a></li>
								<li><a href=""> 앨범 음악</a></li>
							</ul>
						</li>
						<li class = "headerdiv2divulli">
							<a class = "headerdiv2divullia" href =""> 아티스트 </a>
							<ul class = "headerdiv2divulliul">
								<li><a href=""> 인기 아티스트 </a></li>
								<li><a href=""> 추천 아티스트 </a></li>
							</ul>
						</li>
						<li class = "headerdiv2divulli">
							<a class = "headerdiv2divullia" href =""> 방송 </a>
							<ul class = "headerdiv2divulliul">
								<li><a href=""> TOP 10 </a></li>
								<li><a href=""> 인기 방송 </a></li>
								<li><a href=""> 추천 방송</a></li>
							</ul>
						</li>
						<li class = "headerdiv2divulli">	
							<a class = "headerdiv2divullia" href =""> 공연장 </a>
							<ul class = "headerdiv2divulliul">
								<li><a href=""> 공연장 소개 </a></li>
								<li><a href=""> 오시는길  </a></li>
								<li><a href=""> 예약하기</a></li>
							</ul>
						</li>
						<li class = "headerdiv2divulli" 
						style = "border-right : 1px solid; border-right-color:rgba(200,200,200,0.5);">
							<a class = "headerdiv2divullia" href ="">고객센터</a>
							<ul class = "headerdiv2divulliul">
								<li><a href=""> 문의하기 </a></li>
								<li><a href=""> 챗봇 </a></li>
								<li><a href=""> 환불하기</a></li>
								<li><a href=""> 결제하기</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</header>
</body>
</html>