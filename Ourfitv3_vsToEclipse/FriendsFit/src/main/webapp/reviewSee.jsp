<%@page import="java.util.ArrayList"%>
<%@page import="com.model.reviewSelectDTO"%>
<%@page import="com.model.dbDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FriendsFit</title>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/slideStyle.css">

</head>
<body>
	<div id="whole">
		<div id="mainframe">
			<div id="main-content">
				<div id="header">
					<div class="top-header">
						<img src="img/FFlogo.png" alt="friendsfit-logo"
							style="cursor: pointer" onclick="location.href='index.jsp'">
						<!-- <h1>Our fit</h1> -->
					</div>
					<div class="button-group">
						<form action="login.html">
							<button type="submit" class="sign-in-button"
								formaction="login.jsp">로그인 / 가입</button>
						</form>
					</div>
				</div>

				<div id="main" style="background-color: white;">

					<div class="reviewWrite">
						<a href="reviewWrite.jsp">리뷰쓰기</a>
					</div>

					<div class="reviewcontainer">


				<%
					  int reviewNum = Integer.parseInt(request.getParameter("reviewNum"));
					  dbDAO dbdao = new dbDAO();
					  reviewSelectDTO review = dbdao.getReview(reviewNum);
					  request.setAttribute("review", review);
				%>

						<div class="community-list-item">
							<div class="CommunityListItem__StyledListItemContent">
								<div class="CommunityListItem__bill">영수증후기</div>
								<div class="CommunityListItem__id">${review.ID}</div>
								<div class="CommunityListItem__point">(포인트)</div>
								<div class="CommunityListItem__registerDate">${review.registerDate}</div>
								<div class="CommunityListItem__content">
									<span class="CommunityListItem__content__span">
										${review.reviewContent} <span
										class="CommunityListItem__showMoreText"> <a
											href="reviewSee.jsp?reviewNum=${review.reviewNum}">..더 보기</a>
									</span>
									</span>
								</div>
							</div>
							<section class="CommunityListItem__StyledCommunityActionBar">
								<button class="like-button">
									<img src="img/like-icon.svg">
									<div>좋아요</div>
									<div>${review.reviewLike}</div>
								</button>
								<button class="like-button">
									<img src="img/comment-icon.svg">
									<div>댓글</div>
									<div>(댓글수)</div>
								</button>
								<button class="like-button">
									<img src="img/views-icon.svg">
									<div>조회수</div>
									<div>${review.reviewViews}</div>
								</button>
							</section>
						</div>


					</div>
					<% System.out.println(reviewNum + "jsp에서의 reviewNum"); %>

					<form action="reviewCommentAction?reviewNum=<%= Integer.toString(reviewNum) %>">
						<div type="comment" class="review-comment-textarea">
							<textarea name="reviewComment" maxlength="440"
								data-testid="comment-textarea" placeholder="댓글을 입력해주세요."
								class="CommunityDetailTemplate__StyledCommentTextarea-sc-alice7-27"
								style="height: 24px !important;"></textarea>
							<div
								class="CommunityDetailTemplate__StyledTextareaButtonsArea-sc-alice7-28 ljKWyy">
								<button type="reset"
									class="CommunityDetailTemplate__StyledCommentActionButton-sc-alice7-29 eLDXiU">취소</button>
								<button type="submit"
									class="CommunityDetailTemplate__StyledCommentActionButton-sc-alice7-29 jvbKoX">등록</button>
							</div>
						</div>
					</form>








				</div>

				<div id="footer">
					<h1>FriendsFit</h1>
					피트니스크루<br> 팀장 김대현: ysm691611@naver.com<br> 변지협 오주현 류혜림
					염다영<br> 인공지능사관학교<br> @all rights reserved+
				</div>
			</div>

			<div id="main-navbar" class="navbar">
				<ul class="navbar-ul">
					<li class="navbar-li1 navbar-li"><img src="img/nav_home.svg"
						alt="home icon" width="24" height="24" style="cursor: pointer"
						onclick="location.href='index.jsp'"> <br>홈</li>
					<li class="navbar-li2 navbar-li"><img src="img/nav_map.svg"
						alt="map icon" width="24" height="24" style="cursor: pointer"
						onclick="location.href='map.jsp'"> <br>지도</li>
					<li class="navbar-li3 navbar-li"><img src="img/nav_commu.svg"
						alt="community icon" width="24" height="24"
						style="cursor: pointer" onclick="location.href='community.jsp'">
						<br>커뮤니티</li>
					<li class="navbar-li4 navbar-li"><img src="img/nav_col.svg"
						alt="column icon" width="24" height="24" style="cursor: pointer"
						onclick="location.href='column.jsp'"> <br>컬럼</li>
					<li class="navbar-li5 navbar-li"><img src="img/nav_review.svg"
						alt="review icon" width="24" height="24" style="cursor: pointer"
						onclick="location.href='review.jsp'"> <br>ocr리뷰</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>