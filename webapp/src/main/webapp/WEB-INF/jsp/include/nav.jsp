<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>

<link
	href="<s:url value='webjars/bootstrap/4.0.0-1/css/bootstrap.css'/>"
	rel="stylesheet" />
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="<s:url value='css/Layout.css'/>" rel="stylesheet" />
</head>
<body>

	<div class="container">
	<!-- Navigation -->
	<nav
		class="navbar  fixed-top  navbar-expand-lg mb-1  " >

		
		<button class="navbar-toggler" type="button"
			data-toggle="collapse" data-target="#navbarResponsive"
			aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<i class="fa fa-list m-1" id="menuIcon"></i>
		</button>
		<div class="collapse navbar-collapse justify-content-md-center" id="navbarResponsive">
			<ul class="navbar-nav justify-content-center" id="listeNav">

			
				<li class="nav-item ml-3 mr-3">
					<s:a class="nav-link" action="index">ACCUEIL</s:a>
				</li>

				
				<li class="nav-item ml-3 mr-3">
					<s:a class="nav-link" action="recherche">RECHERCHE D'OUVRAGE</s:a>
				</li>

				
				
				<li class="nav-item ml-3 mr-3">
					<s:a class="nav-link" action="getPrets">ESPACE PERSONNEL</s:a>
				</li>

				

				
				
			</ul>
		</div>
		
					<s:if test="#session.user">
            Bienvenue 
            
            <s:property value="#session.user.identifiant" />
            

            <s:a action="Logout" class="btn btn-primary my-2 my-sm-0 justify-content-right m-3">Deconnexion</s:a>
    		
    		</s:if>
    			<s:else>
       				 <s:a action="Login" class="btn btn-primary my-2 my-sm-0 justify-content-right m-3"><i class="fa fa-lock m-1"></i> Connexion</s:a>
    			</s:else>
			

	
	</nav>
	
	
	
	</div>





</body>
<script src="webjars/jquery/3.0.0/jquery.min.js"></script>
<script src="webjars/popper.js/1.12.9-1/umd/popper.min.js"></script>
<script src="webjars/bootstrap/4.0.0-1/js/bootstrap.js"></script>
</html>