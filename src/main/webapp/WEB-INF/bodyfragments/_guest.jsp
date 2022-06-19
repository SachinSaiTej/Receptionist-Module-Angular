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
					<h1 class="m-0 text-dark">Guest Form</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Guest</li>
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
				<h3 class="card-title">Guest</h3>
			</div>
			<!-- /.card-header -->
			<div class="card-body">
				<sf:form role="form"
					action="${pageContext.request.contextPath}/ctl/guest"
					modelAttribute="form" method="post" enctype="multipart/form-data">
					
					<sf:hidden path="id"/>
					
					<div class="row">
						<div class="col-sm-6">
							<!-- text input -->
							<div class="form-group">
								<s:bind path="firstName">
									<label>First Name</label>
									<sf:input path="${status.expression}"
										placeholder="Enter First Name" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<s:bind path="lastName">
									<label>Last Name</label>
									<sf:input path="${status.expression}"
										placeholder="Enter Last Name" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<!-- textarea -->
							<div class="form-group">
								<s:bind path="gender">
									<label>Gender:</label>
									<sf:select class="form-control" path="${status.expression}">
										<sf:option value="" label="Select" />
										<sf:options items="${gender}" />
									</sf:select>
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<s:bind path="dob">
									<label>Date of Birth:</label>

									<div class="input-group date" id="reservationdate"
										data-target-input="nearest">

										<sf:input path="${status.expression}"
											class="form-control datetimepicker-input" />




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
						<div class="col-sm-6">
							<!-- text input -->
							<div class="form-group">
								<s:bind path="email">
									<label>Email</label>
									<sf:input path="${status.expression}"
										placeholder="Enter Email Id.." class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<s:bind path="mobileNo">
									<label>Mobile No</label>
									<sf:input path="${status.expression}"
										placeholder="Enter Mobile No" class="form-control" />
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
								<s:bind path="password">
									<label>Password</label>
									<sf:input type="password" path="${status.expression}"
										placeholder="Enter Password" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<s:bind path="confirmPassword">
									<label>Confirm Password</label>
									<sf:input type="password" path="${status.expression}"
										placeholder="Enter Confirm Password" class="form-control" />
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
								<s:bind path="country">
									<label>Country</label>
									<sf:select style="margin-bottom: 10px" class="form-control"
										path="${status.expression}">
										<sf:option value="-1" label="Select" />
										<sf:options itemLabel="name" itemValue="id"
											items="${country}" />
									</sf:select>
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<s:bind path="region">
									<label>Region</label>
									<sf:select style="margin-bottom: 10px" class="form-control"
										path="${status.expression}">
										<sf:option value="-1" label="Select" />
										<sf:options itemLabel="name" itemValue="id"
											items="${state}" />
									</sf:select>
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
								<s:bind path="city">
									<label>City</label>
									<sf:select style="margin-bottom: 10px" class="form-control"
										path="${status.expression}">
										<sf:option value="-1" label="Select" />
										<sf:options itemLabel="name" itemValue="id"
											items="${city}" />
									</sf:select>
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<s:bind path="address">
									<label>Address</label>
									<sf:textarea path="${status.expression}" rows="3"
										placeholder="Enter Address" class="form-control" />
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
								<s:bind path="idType">
									<label>Id Type:</label>
									<sf:select class="form-control" path="${status.expression}">
										<sf:option value="" label="Select" />
										<sf:options items="${idTypeMap}" />
									</sf:select>
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<s:bind path="idNumber">
									<label>Id Number</label>
									<sf:input path="${status.expression}"
										placeholder="Enter Id Number" class="form-control" />
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
								<s:bind path="idImage">
									<label>Id Image</label>
									<input type="file"  name="idImage" placeholder="Enter image"
										class="form-control"  required/>
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<s:bind path="remark">
									<label>Remark</label>
									<sf:textarea path="${status.expression}" rows="3"
										placeholder="Enter Remark" class="form-control" />
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
								<div class="form-check">
									<s:bind path="vip">

										<form:checkbox path="${status.expression}"
											class="form-check-input" value="Yes" />

										<label class="form-check-label">VIP</label>

										<font color="red" style="font-size: 13px"><sf:errors
												path="${status.expression}" /></font>
									</s:bind>
								</div>
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
