<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Recherche de livre</title>
</head>
<body>
<div class="row">
<header>




<div class="layer">
</div>
<s:include value="include/nav.jsp"></s:include> 
</header>
</div>

<div class="container justify-content-center" id="containerAccueil">

	<div class="row justify-content-center m-2 pt-3" style="text-align:center"> 
			<s:form action="recherche" cssClass="well form-vertical   m-3 p-5" theme="bootstrap" enctype="multipart/form-data">
        		
        		<h3> Recherche d'un ouvrage</h3>
        		
        		<s:textfield class="form-control" name="titre" />
       			
       			
       			<div class="row justify-content-center">
        		<s:submit class="btn btn-primary m-2 col-6" value="Rechercher"/>
        		</div>
       		
       		</s:form>
	</div>
	
		<div class="row justify-content-center">
					 <s:actionmessage/>
					<s:actionerror/>
			</div>	
	
	
	<s:iterator value="listLivre">
<div class="col-lg-8 mb-8 m-3">
				<div class="card h-100 -dark">
					<h4 class="card-header"><s:a action="detail_livre">
						<s:param name="idLivre" value="idLivre"></s:param>
						<s:property value="titre" /></s:a></h4>
					<div class="card-body">
								<div class="row">
								<img class="img-fluid col-6" id="img-card" src="images/livre/<s:property value="image"/>" alt="">
								
								<ul class="col-5 m-1">
						 			<li>Auteurs :<s:iterator value="auteurs">
						 				<b> <s:property value="prenom"/>  <s:property value="nom"/></b>
						 				</s:iterator>
						 			</li>
						 			
						 			<li><b>Statut :</b> <s:property value="disponible"/></li>

						 		
								</ul>
								
								</div>
								

					</div>
					<div class="card-footer">
						<s:a action="detail_livre" class="btn btn-primary">
						<s:param name="id" value="id"></s:param>
						En savoir plus</s:a>						
					</div>
				</div>				
			</div>
			</s:iterator>


</div>



<footer>
<s:include value="include/footer.jsp"></s:include> 
</footer>

</body>
</html>