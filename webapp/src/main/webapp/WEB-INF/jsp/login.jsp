<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<div class="row">
<header>


<div class="layer">
</div>

<s:include value="include/nav.jsp"></s:include> 




</header>
</div>
<div class="row">
<div class="container">
	<section>
	
		<div class="row justify-content-center"> 
		
			<h1 class="text-center"> Authentification</h1>
		

	
		</div>
		
			<div class="row justify-content-center m-2" style="text-align:center"> 
			Veuillez saisir le formulaire pour vous connecter
			</div>
			<div class="row justify-content-center m-2" style="text-align:center">
			L'authentification vous permettra d'accéder à votre espace personnel et suivre vos prêts
			</div>
			
			
			
			
		
		<div class="row justify-content-center "> 
		
			
	
			<s:form action="login" cssClass="well form-vertical   m-3 p-5" theme="bootstrap" enctype="multipart/form-data">
        		
        		<h3> Formulaire de connexion</h3>
        		
        		<s:textfield class="form-control" name="login" id="loginInput" label="Identifiant" requiredLabel="true" />
       	
       
        		<s:password class="form-control" name="password" id="mdpInput" label="Mot de passe" requiredLabel="true" />
      
       			<s:actionerror/>
		
				<div class="row justify-content-center">
        		<s:submit class="btn btn-primary m-2 col-6" value="Validation" id="logButton" disabled="true"/>
        		</div>
    		</s:form>
    		
    		</div>
    		
    		
			
			<div class="row justify-content-center">
					 <s:actionmessage/>
					<s:actionerror/>
			</div>		
    		
    		</section>
    		
			</div>
</div>




<footer>
<s:include value="include/footer.jsp"></s:include> 
</footer>
</body>
<script src="js/controlLogin.js"></script>
</html>