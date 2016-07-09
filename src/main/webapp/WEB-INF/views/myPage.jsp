<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="assets/css/bootstrap.min.css">
<script type="text/javascript" src="assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/myPage.js"></script>
<link rel="stylesheet" type="text/css" href="assets/css/common.css" />
<link rel="stylesheet" type="text/css" href="assets/css/myPage.css" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Insert title here</title>
</head>
<body>



	<div id="wrap">
		<header id="header"> <section
			class="nav-main nav-main-mini navbar" role="navigation"
			style="background-color:#2d3a45">
		<div class="container" style="background-color: #2d3a45">
			<div class="nav-inner" style="background-color: #2d3a45">
				<div class="navbar-header navbar-not-login"
					style="background-color: #2d3a45">
					<a id="mainname" class="navbar-brand" href="/">JOBHELP</a>
				</div>
				<nav>
				<ul class="nav navbar-nav nav-primary">
					<li><a href="#">자유게시판</a></li>
					<li class=""><a href="#">관심 기사</a></li>
					<li><a href="#">이용방법</a></li>
				</ul>
				<c:if test="${name!=null}">

					<span class="navbar-nav navbar-right">${name}님&nbsp;▼</span>

				</c:if> <c:if test="${name==null}">
				</c:if> </nav>
			</div>
		</div>
		</section> </header>


		<c:set var="category" value="${param.category}" scope="request" />
		<c:set var="mid" value="${studentNum}" />
		<div class="container">
			<div id="article">
				<div class="sidebar">

					<div class="sidebar-nav">
						<ul>
							<li class="active"><a href="#">전체보기</a></li>
							<li class=""><a href="#">Clip 기사</a></li>
							<li class=""><a href="#">개인정보 변경</a></li>
							<li class=""><a href="#">회원 탈퇴</a></li>
							<li class=""><a href="#">경력,학력, 자격증</a></li>

						</ul>
					</div>
				</div>

				<div class="content">
					<div class="content-inner" style="padding-top: 15px;">
						<section> <c:if test="${category=='myNews'}">
							<h3>${name}님의clip 기사</h3>
						</c:if> <c:if test="${category=='update'}">
							<h3>${name}님의개인정보</h3>
						</c:if> <c:if test="${category=='breakaway'}">
							<h3>${name}님의회원 탈퇴</h3>
						</c:if> </section>

						<hr>
						<c:if test="${category=='myNews'}">
							<c:forEach var="info" items="${infoList}">
								<div class="rssinfo">
									<form action="newsDelete.do" method="post">
										<h4 class="rssinfo_header">
											<a href="${info.news_url}">${info.news_title}</a>
										</h4>
										<br>
										<p class="rssinfo_date">${info.news_date}</p>
										<p class="rssinfo_description">${info.news_description}</p>
										<input type="hidden" value="${info.news_id}" name="news_id" />
										<input type="hidden" value="${category}" name="category" /> <input
											type="hidden" value="${mid}" name="member_id" />
										<p class="rssinfo_save">
											<input type="submit" class="save" value="del">
											<!-- 후에 delete로 기능으로 변경할거임 -->
										</p>

									</form>
								</div>


							</c:forEach>
						</c:if>


						<c:if test="${category=='update'}">
							<c:set var="member" value="${member}" scope="request" />

							<form class="form-horizontal" action="myUpdate.do" method="POST">
								
								<div class="form-group form-group-sm">
									<label class="col-sm-2 control-label" for="formGroupInputSmall">학번</label>
									<div class="col-sm-6">
										<input class="form-control" type="text" name="studentNum"
											id="formGroupInputSmall" value="${member.studentNum}" readonly>
											<input type="hidden" value="${category}" name="category"/>
									</div>
									
								</div><br>
								
								<div class="form-group form-group-sm">
									<label class="col-sm-2 control-label" for="formGroupInputSmall">사용자명</label>
									<div class="col-sm-6">
										<input class="form-control" type="text" name="name"
											id="formGroupInputSmall" value="${member.name}">
									</div>
									
								</div><br>
								
								<div class="form-group form-group-sm">
									<label class="col-sm-2 control-label" for="formGroupInputSmall">이메일</label>
									<div class="col-sm-6">
										<input class="form-control" type="text" name="email"
											id="formGroupInputSmall" value="${member.email}">
									</div>
									
								</div><br>
								
								<div class="form-group form-group-sm">
									<label class="col-sm-2 control-label" for="formGroupInputSmall">비밀번호</label>
									<div class="col-sm-6">
										<input class="form-control" type="text" name="password"
											id="formGroupInputSmall" value="${member.password}">
									</div>
									
								</div><br>
								<div class="text-center">
								<input type="submit" class="button-update" style="margin-top:40px;" onclick="myUpdate()" value="변경하기">
								</div>
								
								
								
								
							</form>
						
						
						</c:if>


						<c:if test="${category='breakaway'}">
						</c:if>


					</div>
				</div>
			</div>
		</div>



	</div>




	<div id="footer" style="background-color: #2D343F">
		<div class="contanier">
			<div id="footer-inner">
				<div class="info">
					<div class="footer-logo">
						<img class="footer-logo-img" src="#">
					</div>
					<br>
					<div class="contact">
						<i class="glyphicon glyphicon-user" style="color: #fff"></i> <a
							href="tel:82269254849">02-6925-4849</a><br> <i
							class="glyphicon glyphicon-envelope" style="color: #fff"></i> <a
							href="mailto:help@wishket.com">software705@naver.com</a><br>
						<img src="/static/img/yellow_id.png" style="margin-right: 4px;"><a
							href="http://goto.kakao.com/@wishket">Kakao ID 친구추가: whdms705</a><br>

						<br>
						<address class="address">
							주식회사 위시켓 / 사업자등록번호: 209-81-57303 / 대표이사: 조은호<br> 인천광역시 부평구
							십정2동 동암신동아아파트 110동<br>
						</address>
						<span class="copyright">© 2016 eunho </span>
					</div>

				</div>
				<div class="category">
					<h5 class="category-heading">위시켓</h5>
					<ul class="list-unstyled">
						<li class="category-item"><a href="/service-intro/">서비스
								소개</a></li>
						<li class="category-item"><a href="/client-use/">클라이언트
								이용방법</a></li>
						<li class="category-item"><a href="/partners-use/">파트너스
								이용방법</a></li>
						<li class="category-item"><a href="/service-fee/">이용요금</a></li>
						<li class="category-item"><a href="/faq">자주 묻는 질문</a></li>
					</ul>
				</div>

				<div class="category">
					<h5 class="category-heading">관련 링크</h5>
					<ul class="list-unstyled">
						<li class="category-item"><a href="#">페이스북</a></li>
						<li class="category-item"><a href="#">블로그</a></li>
						<li class="category-item"><a href="#">트위터</a></li>
					</ul>

				</div>
			</div>
		</div>
	</div>
</body>
</html>