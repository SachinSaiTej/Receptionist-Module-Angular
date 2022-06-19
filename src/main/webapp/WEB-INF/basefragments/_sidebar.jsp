<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="${pageContext.request.contextPath}/welcome" class="brand-link"> <span
		class="brand-text font-weight-light">Workspanda</span>
	</a>

	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
			<div class="image">
				<img
					src="${pageContext.request.contextPath}/resources/dist/img/user2-160x160.jpg"
					class="img-circle elevation-2" alt="User Image">
			</div>
			<div class="info">
				<a href="#" class="d-block">${sessionScope.user.firstName} ${sessionScope.user.lastName}</a>
			</div>
		</div>

		<!-- Sidebar Menu -->
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">
				<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/welcome"
					class="nav-link"> <!-- <i class="nav-icon fas fa-tachometer-alt"></i> -->
						<p>Dashboard</p>
				</a></li>

				<li class="nav-item"><a href="${pageContext.request.contextPath}/ctl/booking/search"
					class="nav-link"> <!-- <i class="fa fa-list-alt" aria-hidden="true"></i> -->
						<p>Booking</p>
				</a></li>

				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/ctl/guest/search"
					class="nav-link"> <!-- <i class="fa fa-users" aria-hidden="true"></i> -->
						<p>Guest</p>
				</a></li>

				

				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/ctl/roomType/search"
					class="nav-link"> <!-- <i class="fa fa-users" aria-hidden="true"></i> -->
						<p>Room Type</p>
				</a></li>

				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/ctl/floor/search"
					class="nav-link"> <!-- <i class="fa fa-users" aria-hidden="true"></i> -->
						<p>Floor</p>
				</a></li>

				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/ctl/room/search"
					class="nav-link"> <!-- <i class="fa fa-users" aria-hidden="true"></i> -->
						<p>Rooms</p>
				</a></li>

				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/ctl/priceManager/search"
					class="nav-link"> <!-- <i class="fa fa-users" aria-hidden="true"></i> -->
						<p>Price Manager</p>
				</a></li>


				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/ctl/paidService/search"
					class="nav-link"> <!-- <i class="fa fa-users" aria-hidden="true"></i> -->
						<p>Paid Service</p>
				</a></li>
				
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/ctl/employee/search"
					class="nav-link"> <!-- <i class="fa fa-users" aria-hidden="true"></i> -->
						<p>Employee</p>
				</a></li>
				
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/ctl/department/search"
					class="nav-link"> <!-- <i class="fa fa-users" aria-hidden="true"></i> -->
						<p>Department</p>
				</a></li>
				
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/profile"
					class="nav-link"> <!-- <i class="fa fa-users" aria-hidden="true"></i> -->
						<p>My Profile</p>
				</a></li>
				
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/changepassword"
					class="nav-link"> <!-- <i class="fa fa-users" aria-hidden="true"></i> -->
						<p>Change Password</p>
				</a></li>
				
			</ul>
		</nav>
		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->
</aside>