<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url var="addSearch" value="/ctl/payment/search" />

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
					<h1 class="m-0 text-dark">Payment</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Payment</li>
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
			<sf:form action="${addSearch}" method="post" modelAttribute="form">
				<section class="content">
					<div class="container-fluid">
						<div class="row">
							<div class="col-12">
								<div class="card">
									<div class="card-header">
										<h3 class="card-title">Payment</h3>
										<b><%@ include file="businessMessage.jsp"%></b>
										<div class="card-tools">
											
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
													<th>Date</th>
													<th>Invoice Number</th>
													<th>Amount</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${list}" var="pym" varStatus="payment">
													<tr>
														<td>${payment.index+1}</td>
														<td><c:out value="${pym.date}" /></td>
														<td><c:out value="${pym.invoiceNumber} " /></td>
														<td><c:out value="${pym.amount}" /></td>

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
		<!-- /.card -->
		<!-- general form elements disabled -->
	</div>
</div>
