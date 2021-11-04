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
			searchBtn
			$("#cancelBtn").click(function() {
				location.href = "${root}/"
			});
			$("#searchBtn").click(function() {
				$("#searchform").attr("action", "${root}/product").submit();
			});
		});
	</script>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<div class="container-fluid">
				<a class="navbar-brand" href="${root}/index.jsp">ujin's Product</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarColor01"
					aria-controls="navbarColor01" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarColor01">
					<ul class="navbar-nav me-auto">
						<li class="nav-item"><a class="nav-link active" href="#">${userinfo.userid}님
								안녕하세요. <span class="visually-hidden"></span>
						</a></li>
					</ul>
					<form id="searchform" class="d-flex" method="post" action="">
						<input type="hidden" name="act" value="search"> <input
							class="form-control me-sm-2" type="text" name="searchcontent"
							placeholder="Search">
						<button class="btn btn-secondary my-2 my-sm-0" type="submit"
							id="searchBtn">Search</button>
					</form>
				</div>
			</div>
		</nav>
		<div class="content" style="height: 900px; text-align: center;">
			<div class="page-header">
				<h1 style="padding-bottom: 10px; padding-top: 20px">상품 목록 페이지</h1>
				<div class="row" style="float: none; margin: 0 auto;">
					<div class="col-lg-10"
						style="float: none; margin: 0 auto; text-align: left">
						<form id="registerform" class="text-left mb-3" method="post"
							action="">
							<fieldset>
								<table class="table table-hover">
									<thead>
										<tr>
											<th scope="col">No</th>
											<th scope="col">상품코드</th>
											<th scope="col">상품명</th>
											<th scope="col">판매가</th>
											<th scope="col">공급사</th>
											<th scope="col">판매상태</th>
											<th scope="col">등록일</th>
											<th scope="col">파일</th>
											<th scope="col"></th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${not empty products}">
											<c:forEach var="product" items="${products}" varStatus="status">
												<tr class="table-active">
													<td><strong><c:out value="${status.count }"/></strong></td>
													<td>${product.pcode }</td>
													<td>${product.pname }</td>
													<td>${product.price }</td>
													<td>${product.sup }</td>
													<td>${product.status }</td>
													<td>${product.regtime }</td>
													<td>
													<c:if test="${!empty product.fileInfos}">
														<ul>
														<c:forEach var="file" items="${product.fileInfos}">
															<li>${file.file_name}<a href="#" class="filedown" sfolder="${file.file_path_org}" sfile="${file.savefile_name}" ofile="${file.file_name}">[다운로드]</a></li>
														</c:forEach>
														</ul>
													</c:if>
														</td>
													<td><a
											href="${root}/product/modify?pcode=${product.pcode }">수정</a>
										<a
											href="${root}/product/delete?pcode=${product.pcode }">삭제</a></td>
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${empty products}">
											<tr class="table-active">
												<td><strong></strong></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
											</tr>
										</c:if>
									</tbody>
								</table>

								<br>
								<button type="button" id="cancelBtn" class="btn btn-primary">Home</button>
							</fieldset>
						</form>

					</div>
				</div>
			</div>
		</div>
	</body>
	</html>
</c:if>