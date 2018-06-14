<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
</head>
<body>
<div class="row">
<header>


<div class="layer">
</div>

<s:include value="include/nav.jsp"></s:include> 

<s:debug />


</header>
</div>

<div class="container justify-content-center" id="containerAccueil">
	
		<div id="sectionAccueil">
		<div class="row justify-content-center"> 
		
			<h1 class="text-center"> Médiathèque Biblio OCR</h1>
		

	
		</div>
		
			<div class="row justify-content-center m-2 pt-3" style="text-align:center"> 
			Bienvenue sur le site de la médiathèque Biblio OCR
			</div>
			<div class="row justify-content-center m-2" style="text-align:center">
			Vous pouvez consulter les ouvrages disponibles ou vous connecter à votre espace personnel
			</div>
			
			<div class="row justify-content-center m-2 pt-3" style="text-align:center"> 
			<s:form action="recherche" cssClass="well form-vertical   m-3 p-5" theme="bootstrap" enctype="multipart/form-data">
        		
        		<h3> Recherche d'un ouvrage</h3>
        		
        		<s:textfield class="form-control" name="titre" />
       			
       			
       			<div class="row justify-content-center">
        		<s:submit class="btn btn-primary m-2 col-6" value="Rechercher"/>
        		</div>
       		
       		</s:form>
			</div>
			
			
			
		
			
				<s:if test="#session.user">
          			<div class="row justify-content-center m-2" style="text-align:center"> 
						<h3 class="text-center"> Acceder votre espace personnel</h3>
					</div>
					
					<div class="row justify-content-center m-2" style="text-align:center"> 
						<s:a action="acces_perso" class="btn btn-primary my-2 my-sm-0 justify-content-center m-3">Espace personnel</s:a>
					</div>
              		
    		</s:if>
    			<s:else>
    			
    		<div class="row justify-content-center m-2 pt-5" style="text-align:center"> 
			<h3 class="text-center"> Connectez-vous pour acceder à votre espace personnel</h3>
			</div>
			<div class="row justify-content-center m-2" style="text-align:center"> 
			 <s:a action="login" class="btn btn-primary my-4 my-sm-0 justify-content-center m-3"><i class="fa fa-lock m-1"></i> Connexion</s:a>
    		</div>
    		</s:else>
    		</div>
			
			
			
			

    		
    		
			
	
    		
    		
    		

    		</div>
    		
			





<footer>
<s:include value="include/footer.jsp"></s:include> 
</footer>
</body>
</html>