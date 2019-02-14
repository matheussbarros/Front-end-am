<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.ArrayList" %>
<%@ page import="br.com.fiap.beans.*"%>
<%@ page import="br.com.fiap.dao.*"%>
<%@ page import="br.com.fiap.bo.*"%>


<!DOCTYPE html>
<html lang="pt-BR">

<head>
<meta charset="UTF-8">
<title>GEMT - Admin Instituição</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="css/bootstrap-reboot.min.css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/bootstrap-grid.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/custom.css">
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" type="text/css" href="css/index.css" />
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
</head>

<body>


	<nav class="navbar navbar-default">
		<div class="container-fluid">

			<div class="logo">
				<a class="navbar-brand logo" href="index.html"> <img
					src="img/logo-gemt.png"></a>
			</div>

			<div class="navbar-header">
				<button type="button" id="sidebarCollapse"
					class="btn btn-info navbar-btn">
					<i class="fas fa-bars"></i> <span>Toggle Sidebar</span>
				</button>
			</div>

			<!--  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">Page</a></li>
                    <li><a href="#">Page</a></li>
                    <li><a href="#">Page</a></li>
                    <li><a href="#">Page</a></li>
                </ul>
            </div> -->
		</div>
	</nav>