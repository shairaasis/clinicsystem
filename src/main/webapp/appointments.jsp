<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Boxicons -->
      <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>
      <!-- My CSS -->
      <link rel="stylesheet" href="css/admincss/style.css">
	  <link rel="stylesheet" href="css/admincss/modal.css">
      <title>Profile</title>
    </head>
<body>
  <!-- SIDEBAR -->
	<section id="sidebar">
		<a href="#" class="brand">
			<i class='bx bxs-smile'></i>
			<span class="text">PetClinic</span>
		</a>
		<ul class="side-menu top">
			<li class="">
				<a href="profile.jsp">
					<i class='bx bxs-dashboard' ></i>
					<span class="text">Dashboard</span>
				</a>
			</li>
			<li class="active">
				<a href="<s:url action='appointments' />">
					<i class='bx bxs-calendar'></i>
					<span class="text">Appointments</span>
				</a>
			</li>
			<li>
				<a href="<s:url action='listaccounts' />">
					<i class='bx bxs-user' ></i>
					<span class="text">Accounts</span>
				</a>
			</li>
			<li>
				<a href="#">
					<i class='bx bxs-clinic'></i>
					<span class="text">Services</span>
				</a>
			</li>
		</ul>
		<ul class="side-menu">
			<li>
				<a href="#" class="logout">
					<i class='bx bxs-log-out-circle' ></i>
					<span class="text">Logout</span>
				</a>
			</li>
		</ul>
	</section>
	<!-- SIDEBAR -->
  <!-- CONTENT -->
	<section id="content">
		<!-- NAVBAR -->
		<nav>
			<i class='bx bx-menu' ></i>
			<a href="#" class="nav-link">Categories</a>
			<form action="#">
				<div class="form-input">
					<input type="search" placeholder="Search...">
					<button type="submit" class="search-btn"><i class='bx bx-search' ></i></button>
				</div>
			</form>
			<input type="checkbox" id="switch-mode" hidden>
			<label for="switch-mode" class="switch-mode"></label>
			<a href="#" class="notification">
				<i class='bx bxs-bell' ></i>
				<span class="num">8</span>
			</a>
			<a href="#" class="profile">
				<img src="img/people.png">
			</a>
		</nav>
		<!-- NAVBAR -->
    <!-- MAIN -->
		<main>
			<div class="head-title">
				<div class="left">
					<h1>Appointments</h1>
					<ul class="breadcrumb">
						<li>
							<a href="#">Dashboard</a>
						</li>
						<li><i class='bx bx-chevron-right' ></i></li>
						<li>
							<a class="active" href="#">Appointments</a>
						</li>
					</ul>
				</div>
				
			</div>


			<div class="table-data">
				<div class="order">
					<div class="head">
						<h3>Appointments</h3>
						<i class='bx bx-search' ></i>
						<i class='bx bx-filter' ></i>
					</div>
					<table>
						<thead>
							<tr>
                                <th>Appointment Id</th>
								<th>Client</th>
                                <th>Pet</th>
                                <th>Veterinarian</th>
                                <th>Service</th>
                                <th>Schedule</th>
                                <th>Manage</th>
							</tr>
						</thead>
						<tbody>
                        <s:iterator value="appointments" var="appointment">  
                            <tr>
                                <td><s:property value="client"/></td>
                                <td><s:property value="clientId"/></td>
                                <td><s:property value="appointmentId"/></td>
                                <td><s:property value="petName"/></td>
                                <td><s:property value="veterinarian"/></td>
                                <td><s:property value="service"/>
                                <td><s:property value="service"/>
                                <td>
                                    <s:url action="update" var="update">
                                        <s:param name="accountId" value="accountId"></s:param>
                                    </s:url>
                                    <s:a href="%{update}"><button type="button" style="padding: 3px; background-color: #ED6436; border: none; border-radius: 5px; color: white;">
                                    <i class='bx bxs-edit bx-sm'></i></button></s:a>
                                    
                                    <s:url action="delete" var="delete">
                                        <s:param name="accountId" value="accountId"></s:param>
                                    </s:url>
                                    <s:a href="%{delete}"><button type="button" style="padding: 3px; background-color: #d22a2a; border: none; border-radius: 5px; color: white;">
                                    <i class='bx bx-x bx-sm'></i></button></s:a>					
                                </td>
                            </tr>
                        </s:iterator>
						</tbody>
					</table>
				</div>
				
			</div>
		</main>
		<!-- MAIN -->
	</section>
	<!-- CONTENT -->
  </div>

  <script src="css/admincss/script.js"></script>
  <script src="css/admincss/modal.js"></script>
</body>
</html>