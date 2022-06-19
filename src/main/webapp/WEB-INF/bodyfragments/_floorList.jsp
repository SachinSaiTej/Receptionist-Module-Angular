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

<c:url var="addUrl" value="/ctl/floor" />

<c:url var="addSearch" value="/ctl/floor/search" />

<c:url var="editUrl" value="/ctl/floor?id=" />


<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">

			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>Floor List</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Floors</li>
					</ol>
				</div>
				
			</div>
			<a  href="${pageContext.request.contextPath}/ctl/floor" class="btn  btn-primary btn-sm" ><i class="fa fa-plus" aria-hidden="true"></i>Add</a>
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
								<h3 class="card-title">Floor</h3>
								
								<div class="card-tools">
									<div class="input-group input-group-sm" style="width: 150px;">
										<s:bind path="name">
											<sf:input path="${status.expression}" placeholder="Name"
												class="form-control float-right" />

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
											<th>Name</th>
											<th>Status</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="flr" varStatus="floor">
											<tr>
											<td><input type="checkbox" class="case" name="ids"
													value="${flr.id}"></td>
												<td>${floor.index+1}</td>
												<td><c:out value="${flr.name}"/> </td>
												<td><c:out value="${flr.status}"/></td>
												<td>
													<a href="${editUrl} ${flr.id}" class="btn  btn-primary btn-sm" ><i class="fa fa-pencil" aria-hidden="true"></i>Edit</a>
												</td>
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
