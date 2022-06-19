<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url var="orderUrl" value="/ctl/booking/order" />

<c:url var="detailUrl" value="/ctl/guest/detail" />

<c:url var="paymentUrl" value="/ctl/payment/search" />

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0 text-dark">Guest Detail</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Detail</li>
					</ol>
				</div>
				<!-- /.col -->
			</div>
			<b><%@ include file="businessMessage.jsp"%></b>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->

	<!-- right column -->
	<div class="col-md-12">
		<!-- general form elements disabled -->
		<div class="card card-primary">
			<div class="card-header">
				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="${detailUrl}">Detail</a></li>
					<li class="nav-item"><a class="nav-link active" href="${orderUrl}">Orders</a></li>
					<li class="nav-item"><a class="nav-link active" href="${paymentUrl}">Payment</a></li>
				</ul>
			</div>
			<!-- /.card-header -->
			<div class="card-body">
				<div class="row">
					<div class="col-sm-6">
						<!-- text input -->
						<div class="form-group">
							<label>First Name : </label> <font>${dto.firstName}</font>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<label>Last Name : </label> <font>${dto.lastName}</font>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<div class="form-group">
							<label>Gender : </label> <font>${dto.gender}</font>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<label>Date of Birth : </label> <font>${dto.dob}</font>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-6">
						<!-- text input -->
						<div class="form-group">
							<label>Email : </label> <font>${dto.email}</font>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<label>Mobile No : </label> <font>${dto.mobileNo}</font>
						</div>
					</div>
				</div>


				<div class="row">
					<div class="col-sm-6">
						<!-- text input -->
						<div class="form-group">
							<label>Country : </label> <font>${dto.country}</font>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<label>Region : </label> <font>${dto.region}</font>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-6">
						<!-- text input -->
						<div class="form-group">
							<label>City : </label> <font>${dto.city}</font>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<label>Address : </label> <font>${dto.address}</font>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-6">
						<!-- text input -->
						<div class="form-group">
							<label>Id Type : </label> <font>${dto.idType}</font>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="form-group">
							<label>Id Number : </label> <font>${dto.idNumber}</font>
						</div>
					</div>
				</div>

				<div class="row">

					<div class="col-sm-6">
						<div class="form-group">
							<label>Remark : </label> <font>${dto.remark}</font>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-6">
						<!-- text input -->
						<div class="form-group">
							<label>VIP : </label> <font>${dto.vip}</font>
						</div>
					</div>

				</div>
			</div>
			<!-- /.card-body -->
		</div>
		<!-- /.card -->
		<!-- general form elements disabled -->
	</div>
</div>
