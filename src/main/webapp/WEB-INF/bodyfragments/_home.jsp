
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page isELIgnored="false"%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0 text-dark">Dashboard</h1>
				</div>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->

	<!-- Main content -->
	<section class="content">
		<div class="container-fluid">
			<!-- Small boxes (Stat box) -->
			<div class="row">
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-info">
						<div class="inner">
							<h3>${bookingTotal}</h3>
							<p>New Orders</p>
						</div>
						<div class="icon">
							<i class="ion ion-bag"></i>
						</div>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-success">
						<div class="inner">
							<h3>
								${amountTotal}<sup style="font-size: 20px"></sup>
							</h3>

							<p>Total Revenue</p>
						</div>
						<div class="icon">
							<i class="ion ion-stats-bars"></i>
						</div>
						
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-warning">
						<div class="inner">
							<h3>${roomTotal}</h3>
							<p>Rooms</p>
						</div>
						<div class="icon">
							<i class="fa fa-home" aria-hidden="true"></i>
						</div>
						
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-3 col-6">
					<!-- small box -->
					<div class="small-box bg-danger">
						<div class="inner">
							<h3>${guestTotal}</h3>

							<p>Guests</p>
						</div>
						<div class="icon">
							<i
							class="fas fa-users"></i>
						</div>
						
					</div>
				</div>
				<!-- ./col -->
			</div>
			<!-- /.row -->
		</div>
	</section>
	<section class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-header">
								<h3 class="card-title">Latest Booking</h3>
								<b><%@ include file="businessMessage.jsp"%></b>
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
											<th>Payment Status</th>
											<th>Room</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="bk" varStatus="booking">
											<tr>
												<td>${booking.index+1}</td>
												<td><c:out value="${bk.bookingNumber}"/></td>
												<td><c:out value="${bk.paymentStatus} "/> </td>
												<td><c:out value="${bk.roomTypeName}"/></td>
												
											</tr>
										</c:forEach>
									</tbody>
									
								</table>
							</div>
							<div class="card-footer clearfix">

								<ul class="pagination pagination-sm m-0 float-right">
									<li class="page-item"><a href="/Workspanda/ctl/booking/search" class="btn  btn-primary btn-sm" ><i class="fa fa-pencil" aria-hidden="true"></i>View All Bookings</a></li>
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
</div>
