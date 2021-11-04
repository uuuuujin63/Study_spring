<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/include/header.jsp"%>

<c:if test="${empty userinfo }">
	<script type="text/javascript">
		alert("로그인 후 이용 가능한 페이지입니다.");
		location.href = "${root}/";
	</script>
</c:if>
<c:if test="${!empty userinfo }">
<script type="text/javascript">
	$(document).ready(function() {
		$("#registerBtn").click(function() {
			if (!$("#pname").val()) {
				alert("상품명 입력!!!");
				return;
			} else if (!$("#pcode").val()) {
				alert("상품코드 입력!!!");
				return;
			} else if (!$("#price").val()) {
				alert("가격 입력!!!");
				return;
			} else if (!$("#sup").val()) {
				alert("공급사 입력!!!");
				return;
			} else if (!$("#canbuy").val()&&!$("#cantbuy")) {
				alert("판매 상태 확인!!");
				return;
			} else {
				$("#registerform").attr("action", "${root}/product/register").submit();
			}
		});
		$("#cancelBtn").click(function() {
			location.href = "${root}/"
		});
	});
</script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="${root}/">ujin's Product</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarColor01"
				aria-controls="navbarColor01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarColor01">
				<ul class="navbar-nav me-auto">
					<c:if test="${not empty userinfo}">
						<li class="nav-item"><a class="nav-link active" href="#">${userinfo.userid}님
								안녕하세요. <span class="visually-hidden"></span>
						</a></li>
					</c:if>
				</ul>
				<form class="d-flex">
					<input class="form-control me-sm-2" type="text"
						placeholder="Search">
					<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>
	<div class="content" style="height: 900px; text-align: center;">
		<div class="page-header">
			<h1 style="padding-bottom: 10px; padding-top: 20px">상품 등록</h1>
			<div class="row" style="float: none; margin: 0 auto;">
				<div class="col-lg-6"
					style="float: none; margin: 0 auto; text-align: left">
					<form id="registerform" class="text-left mb-3" method="post"
						enctype="multipart/form-data">
						<fieldset>
							<div class="form-group">
								<strong><label for="id" class="form-label mt-4">상품코드</label></strong> <input
									type="text" class="form-control" id="pcode" name="pcode"
									aria-describedby="emailHelp" placeholder="상품코드">
							</div>
							<div class="form-group">
								<strong><label for="id" class="form-label mt-4">상품명</label></strong> <input
									type="text" class="form-control" id="pname" name="pname"
									aria-describedby="emailHelp" placeholder="상품명">
							</div>
							<div class="form-group">
								<strong><label for="id" class="form-label mt-4">판매가</label></strong> <input
									type="text" class="form-control" id="price" name="price"
									aria-describedby="emailHelp" placeholder="판매가">
							</div>
							<div class="form-group">
								<strong><label for="id" class="form-label mt-4">공급사</label></strong> <input
									type="text" class="form-control" id="sup" name="sup"
									aria-describedby="emailHelp" placeholder="공급사">
							</div>
							<div class="form-group">
								<strong><label for="id" class="form-label mt-4">판매상태</label></strong>
								<div class="form-check">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="status"
										id="canbuy" value="canbuy" checked=""> 판매함
									</label>
								</div>
								<div class="form-check">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="status"
										id="cantbuy" value="cantbuy" checked=""> 판매불가
									</label>
								</div>
							</div>
							<div class="form-group">
								<strong><label for="id" class="form-label mt-4">파일</label></strong> <input
									type="file" class="form-control" id="upfile" name="upfile"
									multiple="multiple" >
							</div>
							<br>
							<button type="button" id="cancelBtn" class="btn btn-primary">Cancel</button>
							<button type="button" id="registerBtn" class="btn btn-primary">Register</button>
						</fieldset>
					</form>

				</div>
			</div>
		</div>
	</div>
</body>
</html>
</c:if>