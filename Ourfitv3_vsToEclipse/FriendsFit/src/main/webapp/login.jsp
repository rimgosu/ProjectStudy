<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" href="css/_login.css">


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
	                    
	                    <form id="member_form_3699931103" name="" action="/exec/front/Member/login/" method="post" target="_self" enctype="multipart/form-data">
	
							<div class="login">
							        <h3 class="boxTitle">LOGIN</h3>
							        <fieldset>
									<legend>ȸ���α���</legend>
							            <label class="id ePlaceholder" title="���̵�">
							            	<input id="member_id" name="member_id" fw-filter="isFill" fw-label="���̵�" fw-msg="" class="inputTypeText" placeholder="���̵�" value="" type="text">
							            </label>
							            <label class="password ePlaceholder" title="��й�ȣ">
							            	<input id="member_passwd" name="member_passwd" fw-filter="isFill&amp;isMin[4]&amp;isMax[16]" fw-label="�н�����" fw-msg="" autocomplete="off" value="" type="password" placeholder="��й�ȣ">
							            </label>
							            
							            <a href="#none" class="btnLogin sizeL" onclick="MemberAction.login('member_form_3699931103'); return false;">�α���</a>
										<ul class="find">
											<li class="findlist"><a href="/member/id/find_id.html">���̵�ã��</a></li>
							                <li class="findlist"><a href="/member/passwd/find_passwd_info.html">��й�ȣã��</a></li>
							                <li class="findlist"><a href="join.jsp">ȸ������</a></li>
							            </ul>
							</fieldset>
							</div>
							</div>
							</form>
                   </main>
                   
                   
			   		
				</div>
		</div>
	</div>	               
</body>
</html>