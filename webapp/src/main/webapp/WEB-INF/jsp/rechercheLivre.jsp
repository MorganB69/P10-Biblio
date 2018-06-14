<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>
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

<div class="container justify-content-center">

	<div class="row justify-content-center m-2" style="text-align:center"> 
			<s:form action="recherche" cssClass="well form-vertical   m-3 p-5" theme="bootstrap" enctype="multipart/form-data">
        		
        		<h3> Recherche d'un ouvrage</h3>
        		
        		<s:textfield class="form-control" name="titre" />
        		
        		<s:if test="%{listLivre.isEmpty()==false}">
	
		
		
		<div class="row justify-content-center">
		<div class="col-6">
		<s:select 
		id="formAuteur"
		label="Auteur(s)"
		headerKey="10000"
        headerValue="TOUS"
        name="auteurIdOut"
        list="listAuteur"
        listKey="idAuteur"
        listValue="nom"
        value="%{listAuteur.{id}}"
               
 		/>
 		</div>
 		<div class="col-6">
 				<s:select 
		id="formGenre"
		label="Genre(s)"
		headerKey="10000"
        headerValue="TOUS"
        name="genreIdOut"
        list="listGenre"
        listKey="idGenre"
        listValue="genre"
        value="%{listGenre.{id}}"
               
 		/>
 		
 		</div>
			
		</div>

	
		
	</s:if>
       			
       			
       			<div class="row justify-content-center">
        		<s:submit class="btn btn-primary mt-2 col-6" value="Rechercher"/>
        		</div>
       		
       		</s:form>
	</div>
	
	
	
		<div class="row justify-content-center">
					 <s:actionmessage/>
					<s:actionerror/>
					
					<h4> Nombre d'ouvrage(s) trouvé(s) : <s:property value="nbResult" /></h4>
		</div>	
		
		<div class="row justify-content-center">
		
		
		<s:if test="%{listrecent.isEmpty()==false}">
		<div class="row justify-content-center">
		<h3>Dernières parutions </h3>
		</div>
		<div class="row justify-content-center">
			<s:iterator value="listrecent">
			<div class="col-lg-8 mb-8 m-3">
							<div class="card h-100 -dark">
								<h4 class="card-header"><s:a action="detail_livre">
									<s:param name="idLivre" value="idLivre"></s:param>
									<s:property value="titre" /></s:a></h4>
								<div class="card-body">
											<div class="row">
											<img class="img-fluid col-6" id="img-card" src="images/livre/<s:property value="image"/>" alt="">
											
											<ul class="col m-1" id="listeLivre">
												<s:if test="disponible==true">
												<li><b>Disponibilité :</b> <i class="fa fa-check-circle m-1" id="iconStatut"></i> <span id="statut">Le livre est disponible</span></li>
												</s:if>
												<s:else>
												<li><b>Disponibilité :</b> <i class="fa fa-times-circle m-1" id="iconStatutIndispo"></i> <span id="statutIndispo">Le livre est emprunté</span></li>
												
												</s:else>
												
									 			<li><b>Auteur(s) :</b><s:iterator value="auteurs">
									 				 <span id="attribut"><s:property value="prenom"/>  <s:property value="nom"/></span>
									 				</s:iterator>
									 			</li>
									 			
									 			<li><b>Editeur(s) :</b><s:iterator value="editeurs">
									 				 <span id="attribut"><s:property value="nom"/></span>  
									 				</s:iterator>
									 			</li>
									 			
									 			<li><b> Genre :  </b><s:iterator value="genres">
									 				 <span id="attribut"> <s:property value="genre"/></span> 
									 				</s:iterator>
									 			</li>
									 			
									 			<li><b> Parution : </b><span id="attribut"><javatime:parseLocalDate value="${parution}" pattern="yyyy-MM-dd" var="date" /><javatime:format value="${date}" pattern="dd-MM-yyyy" /></span> </li>

											</ul>
											
											</div>
											
			
								</div>
								<div class="card-footer">
									<s:a action="detail_livre" class="btn btn-primary">
									<s:param name="idLivre" value="idLivre"></s:param>
									En savoir plus</s:a>						
								</div>
							</div>				
						</div>
						</s:iterator>
		</div>
		</s:if>
	
	<s:else>
	<s:iterator value="listLivre">
			<div class="col-lg-8 mb-8 m-3">
							<div class="card h-100 -dark">
								<h4 class="card-header"><s:a action="detail_livre">
									<s:param name="idLivre" value="idLivre"></s:param>
									<s:property value="titre" /></s:a></h4>
								<div class="card-body">
											<div class="row">
											<img class="img-fluid col-6" id="img-card" src="images/livre/<s:property value="image"/>" alt="">
											
											<ul class="col m-1" id="listeLivre">
												<s:if test="disponible==true">
												<li><b>Disponibilité :</b> <i class="fa fa-check-circle m-1" id="iconStatut"></i> <span id="statut">Le livre est disponible</span></li>
												</s:if>
												<s:else>
												<li><b>Disponibilité :</b> <i class="fa fa-times-circle m-1" id="iconStatutIndispo"></i> <span id="statutIndispo">Le livre est emprunté</span></li>
												
												</s:else>
												
									 			<li><b>Auteur(s) :</b><s:iterator value="auteurs">
									 				 <span id="attribut"><s:property value="prenom"/>  <s:property value="nom"/></span>
									 				</s:iterator>
									 			</li>
									 			
									 			<li><b>Editeur(s) :</b><s:iterator value="editeurs">
									 				 <span id="attribut"><s:property value="nom"/></span>  
									 				</s:iterator>
									 			</li>
									 			
									 			<li><b> Genre :  </b><s:iterator value="genres">
									 				 <span id="attribut"> <s:property value="genre"/></span> 
									 				</s:iterator>
									 			</li>
									 			
									 			<li><b> Parution : </b><span id="attribut"><s:property value="parution"/></span> </li>
											
									 			
									 			
			
									 		
											</ul>
											
											</div>
											
			
								</div>
								<div class="card-footer">
									<s:a action="detail_livre" class="btn btn-primary">
									<s:param name="idLivre" value="idLivre"></s:param>
									En savoir plus</s:a>						
								</div>
							</div>				
						</div>
						</s:iterator>
						</s:else>
			</div>

<div class="row justify-content-md-center">
<nav aria-label="...">
	
  <ul class="pagination">
  
  <s:iterator status="incr" begin="1" end="%{lastPage}">  
    <li class="page-item">
       <s:a class="page-link" action="recherche">
						<s:param name="start" value="%{#incr.count}"></s:param>
						<s:property value="%{#incr.count}"/>
		</s:a>
    </li>
    
   </s:iterator >
   
  </ul>
</nav>

</div>

<s:debug/>

</div>



<footer>
<s:include value="include/footer.jsp"></s:include> 
</footer>

</body>
</html>