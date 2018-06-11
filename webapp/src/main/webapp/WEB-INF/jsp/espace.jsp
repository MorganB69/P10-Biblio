<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="#session.user.identifiant"/></title>
</head>
<body>
	<header> 
	<%@ include file="include/nav.jsp"%>  


	</header>
	
	    <!-- Page Content -->
    <div class="container" id="detail-cont">
    
    	<section>

      <!-- Page Heading/Breadcrumbs -->

      <h1 class="text-center text-uppercase">Espace Personnel de <s:property value="#session.user.identifiant"/>
      		</h1>
      <div class="row">
             <div class="col-xs-12 col-md-8 col-lg-9" id="left-column">
             

        
       
        <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-prets" aria-expanded="true" aria-controls="associated-prets">
      	   		<i class="fa fa-leanpub"></i> Mes prêts en cours <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    <s:iterator value="#session.user.prets">
      	    <div class="collapse collapse show mt-3 mb-3" id="associated-prets" aria-expanded="true">
      	    
      	    <div class="card card-body bg-light text-dark rounded">
      	
        
     		     	<div class="row">
				 
				 		<div class="col-lg-5 m-3">
				<div class="card ">
					<h4 class="card-header"><s:a action="detail_livre">
						<s:param name="idLivre" value="idLivre"></s:param>
						<s:property value="titre" /></s:a></h4>
					<div class="card-body">
								<div class="row">
								<ul class="col-5 m-1">
	       										 <li><b>Auteurs :</b><s:iterator value="livre.auteurs">
									 				 <span id="attribut"><s:property value="prenom"/>  <s:property value="nom"/></span>
									 				</s:iterator>
									 			</li>
									 			
									 			<li><b>Editeurs :</b><s:iterator value="livre.editeurs">
									 				 <span id="attribut"><s:property value="nom"/></span>  
									 				</s:iterator>
									 			</li>
									 			
									 			<li><b> Genre :  </b><s:iterator value="livre.genres">
									 				 <span id="attribut"> <s:property value="genre"/></span> 
									 				</s:iterator>
									 			</li>
									 			
									 			<li><b> Parution : </b><span id="attribut"><s:property value="livre.parution"/></span> </li>
											
	        
	        					</ul>
								
								<img class="img-fluid col-6" id="img-card" src="images/livres/<s:property value="image"/>" alt="">
								</div>
								

					</div>
					
				</div>
				
			</div>
			
				<div class="col-lg-6 m-3">
					<s:iterator value="prets">
					<div class="card-body bg-white m-2 border border-primary rounded">
								<div class="row">
								<h6>Demande de prêt</h6>
								</div>
								<div class="row">
								<ul class="m-1">
						 			<li><b>Pseudo emprunteur : </b><s:property value="emprunteur.pseudo"/></li>
						 			<li><b>Mail emprunteur : </b><s:property value="emprunteur.mail"/></li>
						 			<li><b>Statut de la demande:</b> <s:property value="statut"/></li>
						 			
						 		
								</ul>
								</div>
								
									<s:if test="statut=='En cours'">
									<s:a class="btn btn-success m-3" action="acceptPret" >Accepter le prêt
									<s:param name="id" value="topo.id"></s:param>
									<s:param name="idPret" value="id"></s:param>
									</s:a>
									
									<s:a class="btn btn-danger m-3" action="annulPret" >Refuser le prêt
										<s:param name="id" value="topo.id"></s:param>
										<s:param name="idPret" value="id"></s:param>
									</s:a>
									</s:if>
									<s:elseif test="statut=='Annulé'" >
									<div class="row">
											
											<p>La réservation a été annulée</p>
											<s:a class="btn btn-secondary m-3" action="supprimPret" >Supprimer la réservation
										<s:param name="id" value="topo.id"></s:param>
										<s:param name="idPret" value="id"></s:param>
									</s:a>
									</div>
									</s:elseif>
									<s:else>
									<div class="row">
											<h6>Réservation en cours</h6>
									</div>
									<div class="row">
									<ul class="m-1">
										<li><b>Début : </b><s:property value="debut"/> </li>
										<li><b>Fin : </b><s:property value="fin"/> </li>
									
									</ul> 
									<s:a class="btn btn-danger m-3" action="annulPret" >Annuler la réservation
										<s:param name="id" value="topo.id"></s:param>
										<s:param name="idPret" value="id"></s:param>
									</s:a>
									</div>
									</s:else>
								
								
								
								</div>
								
					</s:iterator>			
								
				</div>
				
				</div>	
		
       		</div>
       		</div>
       		</s:iterator> 

    
 
  		
  
  	
        
      </div>
      <div class="col-xs-12 col-md-4 col-lg-3" id="right-column">
      
      <h5 class="mt-3" data-toggle="collapse" href="#associated-situ" aria-expanded="true" aria-controls="associated-situ">
      	   		<i class="fa fa-info-circle"></i> Informations <i class="fa fa-arrow-down pull-right" ></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3" id="associated-situ" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        <h6> <i class="fa fa-globe"></i> Informations personnelles</h6>
     	<ul>
						 <li><b>Prénom : </b><s:property value="#session.user.prenom"/></li>
           				 <li><b>Nom : </b><s:property value="#session.user.nom"/></li>
           				 <li><b>Mail : </b><s:property value="#session.user.mail"/></li>
           				    
		</ul>
		
		
    
  </div>
      	    
      </div>
      

      </div>

	</section>
	</div>
	
	
      
      
	
	
	<footer> <%@ include file="include/footer.jsp"%> </footer>
</body>
</html>