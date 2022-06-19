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
					<h1 class="m-0 text-dark">My Profile</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">My Profile</li>
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
				<h3 class="card-title">Room</h3>
			</div>
			<!-- /.card-header -->
			<div class="card-body">
				<sf:form role="form"
					action="${pageContext.request.contextPath}/profile"
					modelAttribute="form" method="post">
					<sf:hidden path="id" />

					
					
					<div class="form-group">
						<s:bind path="firstName">
							<label>First Name</label>
							<sf:input path="${status.expression}"
								placeholder="Enter First Name" class="form-control" />
							<font color="red"><sf:errors path="${status.expression}"
									cssClass="help-block" /></font>
						</s:bind>
					</div>
					
					<div class="form-group">
						<s:bind path="lastName">
							<label>Last Name</label>
							<sf:input path="${status.expression}"
								placeholder="Enter Last Name" class="form-control" />
							<font color="red"><sf:errors path="${status.expression}"
									cssClass="help-block" /></font>
						</s:bind>
					</div>
					
						<div class="form-group">
						<s:bind path="login">
							<label>Login</label>
							<sf:input path="${status.expression}"
								placeholder="Enter Login" class="form-control" />
							<font color="red"><sf:errors path="${status.expression}"
									cssClass="help-block" /></font>
						</s:bind>
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

