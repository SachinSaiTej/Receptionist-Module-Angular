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
					<h1 class="m-0 text-dark">Room Type</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Room Type</li>
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
				<h3 class="card-title">Room Type</h3>
			</div>
			<!-- /.card-header -->
			<div class="card-body">
				<sf:form role="form"
					action="${pageContext.request.contextPath}/ctl/roomType"
					modelAttribute="form" method="post">
					<sf:hidden path="id" />

					<div class="form-group">
						<s:bind path="title">
							<label>Title</label>
							<sf:input path="${status.expression}" placeholder="Enter Title"
								class="form-control" />
							<font color="red" style="font-size: 13px"><sf:errors
									path="${status.expression}" /></font>
						</s:bind>
					</div>

					<div class="form-group">
						<s:bind path="slug">
							<label>Slug</label>
							<sf:input path="${status.expression}" placeholder="Enter Slug"
								class="form-control" />
							<font color="red" style="font-size: 13px"><sf:errors
									path="${status.expression}" /></font>
						</s:bind>
					</div>

					<div class="form-group">
						<s:bind path="shortCode">
							<label>Sort Code</label>
							<sf:input path="${status.expression}"
								placeholder="Enter Sort Code" class="form-control" />
							<font color="red" style="font-size: 13px"><sf:errors
									path="${status.expression}" /></font>
						</s:bind>
					</div>

					<div class="form-group">
						<s:bind path="description">
							<label>Description</label>
							<sf:textarea class="form-control"
								placeholder="Place some text here" path="${status.expression}"
								rows="3" />
							<font color="red" style="font-size: 13px"><sf:errors
									path="${status.expression}" /></font>
						</s:bind>
					</div>

					<div class="form-group">
						<s:bind path="baseOccupancy">
							<label>Base Occupancy</label>
							<sf:input path="${status.expression}"
								placeholder="Enter Base Occupancy" class="form-control" />
							<font color="red" style="font-size: 13px"><sf:errors
									path="${status.expression}" /></font>
						</s:bind>
					</div>

					<div class="form-group">
						<s:bind path="higherOccupancy">
							<label>Higher Occupancy</label>
							<sf:input path="${status.expression}"
								placeholder="Enter Higher Occupancy" class="form-control" />
							<font color="red" style="font-size: 13px"><sf:errors
									path="${status.expression}" /></font>
						</s:bind>
					</div>

					<div class="form-group">
						<s:bind path="extraBad">
							<label>Extra Bad</label>
							<sf:input path="${status.expression}"
								placeholder="Enter Extra Bad" class="form-control" />
							<font color="red" style="font-size: 13px"><sf:errors
									path="${status.expression}" /></font>
						</s:bind>
					</div>

					<div class="form-group">
						<s:bind path="higherOccupancy">
							<label>Higher Occupancy</label>
							<sf:input path="${status.expression}"
								placeholder="Enter Higher Occupancy" class="form-control" />
							<font color="red" style="font-size: 13px"><sf:errors
									path="${status.expression}" /></font>
						</s:bind>
					</div>

					<div class="form-group">
						<s:bind path="kidOccupancy">
							<label>Kid Occupancy</label>
							<sf:input path="${status.expression}"
								placeholder="Enter Kid Occupancy" class="form-control" />
							<font color="red" style="font-size: 13px"><sf:errors
									path="${status.expression}" /></font>
						</s:bind>
					</div>

					<div class="form-group">
						<s:bind path="amenities">
							<label>Amenities</label>
							<sf:input path="${status.expression}"
								placeholder="Enter Amenities" class="form-control" />
							<font color="red" style="font-size: 13px"><sf:errors
									path="${status.expression}" /></font>
						</s:bind>
					</div>

					<div class="form-group">
						<s:bind path="basePrice">
							<label>Base Price</label>
							<sf:input path="${status.expression}"
								placeholder="Enter Base Price" class="form-control" />
							<font color="red" style="font-size: 13px"><sf:errors
									path="${status.expression}" /></font>
						</s:bind>
					</div>

					<div class="form-group">
						<s:bind path="additionalPersionPrice">
							<label>Additional Person Price</label>
							<sf:input path="${status.expression}"
								placeholder="Enter Additional Person Price" class="form-control" />
							<font color="red" style="font-size: 13px"><sf:errors
									path="${status.expression}" /></font>
						</s:bind>
					</div>

					<div class="form-group">
						<s:bind path="extraBedPrice">
							<label>Extra Bed Price</label>
							<sf:input path="${status.expression}"
								placeholder="Enter Extra Bed Price" class="form-control" />
							<font color="red" style="font-size: 13px"><sf:errors
									path="${status.expression}" /></font>
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
<script>
	$(function() {
		// Summernote
		$('.textarea').summernote()
	})
</script>
