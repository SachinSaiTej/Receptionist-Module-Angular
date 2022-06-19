<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<br><br><br><br><br>
<section class="content">
	<div class="container-fluid" style="margin-left: 32%">
		<div class="row">
			<!-- left column -->
			<div class="col-md-5">
			<!-- Horizontal Form -->
            <div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">Login</h3>
                
								<b><%@ include file="businessMessage.jsp"%></b>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
             <sf:form method="post"
							action="${pageContext.request.contextPath}/login" modelAttribute="form"
							>
                <div class="card-body">
                  <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">UserName</label>
                    
                    <div class="col-sm-10">
                      <s:bind path="login">
									<sf:input path="${status.expression}" placeholder="Enter UserName"
										class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors
											path="${status.expression}" /></font>
								</s:bind>
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                    	<s:bind path="password">
									<sf:input type="password" path="${status.expression}"
									placeholder="Enter Password" class="form-control" />
									<font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font>
								</s:bind>
                    </div>
                  </div>
                <div class="card-footer">
                 <input type="submit" name="operation" class="btn btn-primary pull-right"
								value="SignIn">
                  <a href="${pageContext.request.contextPath}/forgetPassword">Forget Password ?</a>
                </div>
                <!-- /.card-footer -->
              </sf:form>
            </div>
            <!-- /.card -->
			</div>
		</div>
	</div>
</section>