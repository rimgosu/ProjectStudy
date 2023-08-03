<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<div id="whole">
	   	 <div id="mainframe">
	            <div id="main-content">
	            
	                <div id="header">
	                    <div class="top-header">
	                        <img src="img/FFlogo.png" alt="friendsfit-logo" style="cursor:pointer" onclick="location.href='index.jsp'">
	                    </div>
	                </div>
	                
	                <main id="screenmain" class="screen-main">
	                    <div class="SignInPageTemplate">
	                        <h1 class="SignInPageTemplate-1">여러분을 위한 운동 메이트! 프렌즈핏에 오신 것을 <br>환영합니다!</h1>
	                    </div>
	                    
	                    <div class="login">
	                    	<h3 class="boxTitle">LOGIN</h3>
	                    	<fieldset>
	                    		<legend>회원로그인</legend>
	                    		<label class="id ePlaceholder" title="아이디">
	                    			<input id="member_id" name="member_id" fw-filter="isFill" fw-label="아이디" fw-msg class="inputTypeText" placeholder="아이디" value type="text">
	                    		</label>
	                    		<label class="password ePlaceholder" title="비밀번호">
	                    			<input id="member_passwd" name="member_passwd" fw-filter="isFill&isMin[4]&isMax[16]" fw-label="패스워드" fw-msg autocomplete="off" placeholder="비밀번호" value type="password">
	                    		</label>
	                    		<a href="#none" class="btnLogin sizeL" onclick="MemberAction.login('member_form_3699931103'); return false;">로그인</a>
	                    		<ul class="find">
	                    			<li>
	                    				<a href="">아이디찾기</a>
	                    			</li>
	                    			<li>
	                    				<a href="">비밀번호찾기</a>
	                    			</li>
	                    			<li>
	                    				<a href="">회원가입</a>
	                    			</li>
	                    		</ul>
	                    	</fieldset>
	                    </div>
                   </main>
                   
                   
			   		
				</div>
		</div>
	</div>	               
</body>
</html>