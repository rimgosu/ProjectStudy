<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

    <div id="whole" >
        <div id="mainframe" >
            
            <div id="main-content">
                <div id="header">
                    <div class="top-header">
                        <img src="img/FFlogo.png" alt="friendsfit-logo" style="cursor:pointer" onclick="location.href='index.jsp'">
                         <!-- <h1>Our fit</h1> -->
                    </div>
                    <div class="button-group">
                        <form action="login.html">
                            <button type="submit" class="sign-in-button" formaction="login.jsp">
                                로그인
                                /
                                가입
                            </button>
                    </form>
                    </div>
                </div>

                <div id="main" style="background-color: white;">
                
                    <div id="map" style="width:440px;height:900px;"></div>
                


























                </div>


                <div id="footer">
                    <h1>Ourfit</h1>
                    피트니스크루<br>
                    팀장 김대현: ysm691611@naver.com<br>
                    변지협 오주현 류혜림 염다영<br>
                    인공지능사관학교<br>
                    @all rights reserved
                
                </div>

            </div>

       
            <div id="main-navbar" class="navbar">
                <ul class="navbar-ul">
                    <li class="navbar-li1 navbar-li">
                    		<img src="img/nav_home.svg" alt="home icon" width="24" height="24" style="cursor:pointer" onclick="location.href='index.jsp'">
                    	<br>홈
                    </li>
                    <li class="navbar-li2 navbar-li">                    	
                    		<img src="img/nav_map.svg" alt="map icon" width="24" height="24" style="cursor:pointer" onclick="location.href='map.jsp'">
                            <br>지도
                     </li>
                    <li class="navbar-li3 navbar-li">
                    		<img src="img/nav_commu.svg" alt="community icon" width="24" height="24" style="cursor:pointer" onclick="location.href='community.jsp'">
                    		<br>커뮤니티
                    </li>
                    <li class="navbar-li4 navbar-li">
	                    	<img src="img/nav_col.svg" alt="column icon" width="24" height="24" style="cursor:pointer" onclick="location.href='column.jsp'">
                    		<br>컬럼
                    </li>
                    <li class="navbar-li5 navbar-li">
                    		<img src="img/nav_review.svg" alt="review icon" width="24" height="24" style="cursor:pointer" onclick="location.href='review.jsp'">
                        <br>ocr리뷰
                    </li>
				</ul>
            </div>
        

        </div>
        <div id="aside" >안녕하세요, 이 곳에 정보가 뜰 것입니다</div>
    </div>














	<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=79769e254f2328cac41473351ff2b861"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(33.450936,126.569477), // 지도의 중심좌표
		        level: 3, // 지도의 확대 레벨
		        mapTypeId : kakao.maps.MapTypeId.ROADMAP // 지도종류
		    }; 

		// 지도를 생성한다 
		var map = new kakao.maps.Map(mapContainer, mapOption); 

	// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
	var positions = [
		{
			content: '<div>카카오</div>', 
			latlng: new kakao.maps.LatLng(37.5096, 127.0000)
		},
		{
			content: '<div>생태연못</div>', 
			latlng: new kakao.maps.LatLng(33.450936, 126.569477)
		},
		{
			content: '<div>텃밭</div>', 
			latlng: new kakao.maps.LatLng(33.450879, 126.569940)
		},
		{
			content: '<div>근린공원</div>',
			latlng: new kakao.maps.LatLng(33.451393, 126.570738)
		}
	];

	for (var i = 0; i < positions.length; i ++) {
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
			map: map, // 마커를 표시할 지도
			position: positions[i].latlng // 마커의 위치
		});

		// 마커에 표시할 인포윈도우를 생성합니다 
		var infowindow = new kakao.maps.InfoWindow({
			content: positions[i].content // 인포윈도우에 표시할 내용
		});

		// 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
		// 이벤트 리스너로는 클로저를 만들어 등록합니다 
		// for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
		kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
		kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
        // 지도 클릭 이벤트를 등록한다 (좌클릭 : click, 우클릭 : rightclick, 더블클릭 : dblclick)
        // 마커에 클릭 이벤트를 등록한다 (우클릭 : rightclick)
		kakao.maps.event.addListener(marker, 'click', function() {
            document.getElementById('aside').style.display = 'block';
        });

        
        
	}

	// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
	function makeOverListener(map, marker, infowindow) {
		return function() {
			infowindow.open(map, marker);
		};
	}

	// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
	function makeOutListener(infowindow) {
		return function() {
			infowindow.close();
		};
	}

    // 지도 클릭 이벤트를 등록한다 (좌클릭 : click, 우클릭 : rightclick, 더블클릭 : dblclick)
    kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
        console.log('지도에서 클릭한 위치의 좌표는 ' + mouseEvent.latLng.toString() + ' 입니다.');
    });	
    
	</script>
    
</body>
</html>
