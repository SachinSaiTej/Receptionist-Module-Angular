<!-- Content Wrapper. Contains page content -->

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>

<c:url var="addUrl" value="/ctl/room" />

<c:url var="addSearch" value="/ctl/room/search" />

<c:url var="editUrl" value="/ctl/room?id=" />


<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">

			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>Room List</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Rooms</li>
					</ol>
				</div>

			</div>
			<a href="${pageContext.request.contextPath}/ctl/room"
				class="btn  btn-primary btn-sm"><i class="fa fa-plus"
				aria-hidden="true"></i>Add</a>
		</div>
		<!-- /.container-fluid -->



	</section>
	
	


	<sf:form action="${addSearch}" method="post" modelAttribute="form">
	
	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<!-- Info boxes -->
			<div class="row">
				<div class="col-12 col-sm-6 col-md-3">
					<div class="info-box">
						<span class="info-box-icon bg-info elevation-1"><i class="fas fa-leaf"></i></span>

						<div class="info-box-content">
							<span class="info-box-text">ROOMS</span> <span
								class="info-box-number">${total}
							</span>
						</div>
						<!-- /.info-box-content -->
					</div>
					<!-- /.info-box -->
				</div>
				<!-- /.col -->
				<div class="col-12 col-sm-6 col-md-3">
					<div class="info-box mb-3">
						<span class="info-box-icon bg-danger elevation-1"><i class="fa fa-list-alt" aria-hidden="true"></i></i></span>

						<div class="info-box-content">
							<span class="info-box-text">FLOOR</span> <span
								class="info-box-number">${floorTotal}</span>
						</div>
						<!-- /.info-box-content -->
					</div>
					<!-- /.info-box -->
				</div>
				<!-- /.col -->

				<!-- fix for small devices only -->
				<div class="clearfix hidden-md-up"></div>

				<div class="col-12 col-sm-6 col-md-3">
					<div class="info-box mb-3">
						<span class="info-box-icon bg-success elevation-1"><i class="fa fa-list-alt" aria-hidden="true"></i></span>

						<div class="info-box-content">
							<span class="info-box-text">ROOM TYPE</span> <span
								class="info-box-number">${roomTypeTotal}</span>
						</div>
						<!-- /.info-box-content -->
					</div>
					<!-- /.info-box -->
				</div>
				<!-- /.col -->
				<div class="col-12 col-sm-6 col-md-3">
					<div class="info-box mb-3">
						<span class="info-box-icon bg-warning elevation-1"><i
							class="fas fa-users"></i></span>

						<div class="info-box-content">
							<span class="info-box-text">BOOKING ROOM TODAY</span> <span
								class="info-box-number">${bookingTotal}</span>
						</div>
						<!-- /.info-box-content -->
					</div>
					<!-- /.info-box -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
	</section>
	<!-- Main content -->
	
		<section class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">Rooms</h3>

								<div class="card-tools">
									<div class="input-group input-group-sm" style="width: 150px;">
										<s:bind path="roomNumber">
											<sf:input path="${status.expression}"
												placeholder="Room Number" class="form-control float-right" />
										</s:bind>
										<div class="input-group-append">
											<input type="submit" class="btn btn-primary btn btn-info"
												name="operation" value="Search">
										</div>
									</div>
								</div>
							</div>
							<b><%@ include file="businessMessage.jsp"%></b>
							<sf:input type="hidden" path="pageNo" />
							<sf:input type="hidden" path="pageSize" />

							<sf:input type="hidden" path="listsize" />
							<sf:input type="hidden" path="total" />
							<sf:input type="hidden" path="pagenosize" />

							<!-- /.card-header -->
							<div class="card-body">
								<table id="example2" class="table table-bordered table-hover">
									<thead>
										<tr>
											<th class="th-sm">Select</th>
											<th>#</th>
											<th>Room Number</th>
											<th>Room Type</th>
											<th>Floor Number</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="rmn" varStatus="roomN">
											<tr>
												<td><input type="checkbox" class="case" name="ids"
													value="${rmn.id}"></td>
												<td>${roomN.index+1}</td>
												<td><c:out value="${rmn.roomNumber}" /></td>
												<td><c:out value="${rmn.roomType.title}" /></td>
												<td><c:out value="${rmn.floor.name}" /></td>
												<td><a href="${editUrl} ${rmn.id}"
													class="btn  btn-primary btn-sm"><i
														class="fa fa-pencil" aria-hidden="true"></i>Edit</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="card-footer clearfix">

								<ul class="pagination pagination-sm m-0 float-left">
									<li class="page-item"><input type="submit"
										name="operation"
										<c:if test="${listsize== 0}">disabled="disabled"</c:if>
										class="btn  btn-danger btn-sm" value="Delete"></li>

								</ul>
								<ul class="pagination pagination-sm m-0 float-right">
									<li class="page-item"><input type="submit"
										name="operation"
										<c:if test="${form.pageNo == 1}">disabled="disabled"</c:if>
										value="Previous"></li>
									<li class="page-item"><input type="submit"
										name="operation"
										<c:if test="${total == pagenosize  || listsize < pageSize   }">disabled="disabled"</c:if>
										value="Next"></li>
								</ul>
							</div>
							<!-- /.card-body -->
						</div>


						<!-- /.card -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</section>
		<!-- /.content -->
	</sf:form>
</div>
<!-- /.content-wrapper -->
