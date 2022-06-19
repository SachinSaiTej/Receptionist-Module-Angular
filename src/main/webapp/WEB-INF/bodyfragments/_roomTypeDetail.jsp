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
					<h1 class="m-0 text-dark">Room Type Detail</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Room Type Detail</li>
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
				<h3 class="card-title">Room Type Detail</h3>
			</div>
			<!-- /.card-header -->
			<div class="card-body">
				

					<div class="form-group">
							<label>Title : </label>
							<font>${dto.title}</font>
					</div>

					<div class="form-group">
							<label>Slug : </label>
							<font>${dto.slug}</font>
					</div>

					<div class="form-group">
							<label>Sort Code : </label>
							<font>${dto.shortCode}</font>
					</div>

					<div class="form-group">
							<label>Description : </label>
							<font>${dto.description}</font>
					</div>

					<div class="form-group">
							<label>Base Occupancy : </label>
							<font>${dto.baseOccupancy}</font>
					</div>

					<div class="form-group">
							<label>Higher Occupancy : </label>
							<font>${dto.higherOccupancy}</font>
					</div>

					<div class="form-group">
							<label>Extra Bad : </label>
								<font>${dto.extraBad}</font>
					</div>

					

					<div class="form-group">
							<label>Kid Occupancy : </label>
							<font>${dto.kidOccupancy}</font>
					</div>

					<div class="form-group">
							<label>Amenities : </label>
						<font>${dto.amenities}</font>
					</div>

					<div class="form-group">
							<label>Base Price : </label>
							<font>${dto.basePrice}</font>
					</div>

					<div class="form-group">
							<label>Additional Person Price : </label>
							<font>${dto.additionalPersionPrice}</font>
					</div>

					<div class="form-group">
							<label>Extra Bed Price : </label>
							<font>${dto.extraBedPrice}</font>
					</div>

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
