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

<c:url var="addUrl" value="/ctl/booking" />

<c:url var="addSearch" value="/ctl/booking/search" />

<c:url var="editUrl" value="/ctl/booking?id=" />


<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">

			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>Booking List</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Booking</li>
					</ol>
				</div>
				
			</div>
			<a  href="${pageContext.request.contextPath}/ctl/booking" class="btn  btn-primary btn-sm" ><i class="fa fa-plus" aria-hidden="true"></i>Add</a>
		</div>
		<!-- /.container-fluid -->
		
		
		
	</section>

	
	<sf:form action="${addSearch}" method="post" modelAttribute="form">
		<section class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">Booking</h3>
								<b><%@ include file="businessMessage.jsp"%></b>
								<div class="card-tools">
									<div class="input-group input-group-sm" style="width: 150px;">
										<s:bind path="bookingNumber">
											<sf:input path="${status.expression}" placeholder="Booking Number"
												class="form-control float-right" />
										</s:bind>
										<div class="input-group-append">
											<input type="submit" class="btn btn-primary btn btn-info"
												name="operation" value="Search">
										</div>
									</div>
								</div>
							</div>

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
											<th>#</th>
											<th>Booking Number</th>
											<th>Guest</th>
											<th>Check In</th>
											<th>Check Out</th>
											<th>Booking Date</th>
											<th>Payment Status</th>
											<th>Booking Status</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="bk" varStatus="booking">
											<tr>
												<td>${booking.index+1}</td>
												<td><c:out value="${bk.bookingNumber}"/></td>
												<td><c:out value="${bk.guestName} "/> </td>
												<td><c:out value="${bk.checkIn}"/></td>
												<td><c:out value="${bk.checkOut}"/></td>
												<td><c:out value="${bk.bookingDate}"/></td>
												<td><c:out value="${bk.paymentStatus}"/></td>
												<td><c:out value="${bk.bookingStatus}"/></td>
												
											</tr>
										</c:forEach>
									</tbody>
									
								</table>
							</div>
							<div class="card-footer clearfix">

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
