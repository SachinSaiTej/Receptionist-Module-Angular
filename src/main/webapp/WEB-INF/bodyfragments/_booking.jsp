<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0 text-dark">Booking Form</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Booking</li>
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
	<div class="col-md-10">
		<!-- general form elements disabled -->
		<div class="card card-primary">
			<div class="card-header">
				<h3 class="card-title">Booking</h3>
			</div>
			<!-- /.card-header -->
			<div class="card-body">
				<sf:form role="form"
					action="${pageContext.request.contextPath}/ctl/booking"
					modelAttribute="form" method="post">
					<div class="row">
						<div class="col-sm-6">
							<!-- text input -->
							<div class="form-group">
								<s:bind path="guestId">
									<label>Guest</label>
									<sf:select style="margin-bottom: 10px" class="form-control"
										path="${status.expression}">
										<sf:option value="-1" label="Select" />
										<sf:options itemLabel="firstName" itemValue="id"
											items="${guestList}" />
									</sf:select>
									<font color="red"><sf:errors path="${status.expression}"
											cssClass="help-block" /></font>
								</s:bind>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<s:bind path="roomTypeId">
									<label>Room Type</label>
									<sf:select style="margin-bottom: 10px" class="form-control"
										path="${status.expression}">
										<sf:option value="-1" label="Select" />
										<sf:options itemLabel="title" itemValue="id"
											items="${roomTypeList}" />
									</sf:select>
									<font color="red"><sf:errors path="${status.expression}"
											cssClass="help-block" /></font>
								</s:bind>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-6">
							<!-- text input -->
							<div class="form-group">
								<s:bind path="adult">
									<label>Adult</label>
									<sf:input path="${status.expression}"
										placeholder="Enter Adult" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<s:bind path="kids">
									<label>Kids</label>
									<sf:input path="${status.expression}"
										placeholder="Enter Kids" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-6">
							<!-- text input -->
							<div class="form-group">
								<s:bind path="checkIn">
									<label>Check In:</label>

									<div class="input-group date" id="reservationdate"
										data-target-input="nearest">

										<sf:input  path="${status.expression}"
											class="form-control datetimepicker-input"
											 />




										<div class="input-group-append" data-target="#reservationdate"
											data-toggle="datetimepicker">
											<div class="input-group-text">
												<i class="fa fa-calendar"></i>
											</div>
										</div>

									</div>
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<s:bind path="checkOut">
									<label>Check Out:</label>

									<div class="input-group date" id="reservationdate"
										data-target-input="nearest">

										<sf:input  path="${status.expression}"
											class="form-control datetimepicker-input"
											 />




										<div class="input-group-append" data-target="#reservationdate"
											data-toggle="datetimepicker">
											<div class="input-group-text">
												<i class="fa fa-calendar"></i>
											</div>
										</div>

									</div>
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>



					<div class="row">
						<div class="col-12">
							<input type="submit" value="Save" name="operation"
								class="btn btn-success float-right">
						</div>
					</div>
				</sf:form>
			</div>
			<!-- /.card-body -->
		</div>
		<!-- /.card -->
		<!-- general form elements disabled -->
	</div>
</div>
