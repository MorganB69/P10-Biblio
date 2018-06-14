<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>

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
             <div class="col-xs-12 col-md-7 col-lg-8" id="left-column">
             

        
       
        <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-prets" aria-expanded="true" aria-controls="associated-prets">
      	   		<i class="fa fa-leanpub"></i> Mes prêts en cours <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    <s:if test="%{listPret.isEmpty()==false}">
      	    <s:iterator value="listPret">
      	    <div class="collapse collapse show mt-3 mb-3" id="associated-prets" aria-expanded="true">
      	    
      	    <div class="card card-body bg-light text-dark rounded">
      	
        
     		     	<div class="row">
				 
				 		<div class="col-lg-4 m-2">
				<div class="card ">
							
							<h4 class="card-header text-center">
							<s:a action="detail_livre">	
							<s:param name="idLivre" value="livre.idLivre"></s:param>
							<s:property value="livre.titre" /></s:a>
							</h4>
							
						
					<div class="card-body">
								<div class="row justify-content-center">
	
	       										
								
								<img class="img-fluid" id="img-card" src="images/livre/<s:property value="livre.image"/>" alt="">
								</div>
								

					</div>
					
				</div>
				
			</div>
			
				<div class="col-lg-7 m-2">
					
					<div class="card-body m-2 border border-primary rounded">
								<div class="row">
								<h4>Détail du prêt :</h4>
								</div>
								<div class="row">
								<ul class="m-1" id="listeLivre">
						 			<li><b>Date de début : </b> <span id="attribut"><javatime:parseLocalDate value="${dateDebut}" pattern="yyyy-MM-dd" var="date" /><javatime:format value="${date}" pattern="dd-MM-yyyy" /></span></li>
						 			<li><b>Date de fin prévue : </b><span id="attribut"><javatime:parseLocalDate value="${dateFin}" pattern="yyyy-MM-dd" var="date" /><javatime:format value="${date}" pattern="dd-MM-yyyy" /></span></li>
						 			<li><b>Prolongé :</b><span id="attribut"><s:if test="prolonge==true"> Oui</s:if><s:else> Non</s:else></span></li>
						 			<s:if test="%{dateFin.isBefore(dateJour)}">
						 				<i class="fa fa-times-circle m-1" id="iconStatutIndispo"></i> <span id="statutIndispo">Attention, vous êtes en retard sur ce prêt</span>
						 			</s:if>
								</ul>
								</div>
								
									<s:if test="prolonge==false">
									<s:a class="btn btn-success m-3" action="prolongerPret" >Prolonger le prêt
									<s:param name="idPret" value="idPret"></s:param>
									</s:a>
									</s:if>
									<s:else>Ce prêt a déjà été prolongé une fois. Il n'est plus possible de le prolonger à nouveau</s:else>
									
								
								
								
								</div>
								
							
								
				</div>
				
				</div>	
		
       		</div>
       		</div>
       		</s:iterator> 

    		</s:if>
    		<s:else>
    		Vous n'avez pas de prêt en cours.
    		</s:else>
 
  		
  
  	
        
      </div>
      <div class="col-xs-12 col-md-5 col-lg-4" id="right-column">
      
      <h5 class="mt-3" data-toggle="collapse" href="#associated-situ" aria-expanded="true" aria-controls="associated-situ">
      	   		<i class="fa fa-info-circle"></i> Informations <i class="fa fa-arrow-down pull-right" ></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3 mb-3" id="associated-situ" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        <h5> <i class="fa fa-globe"></i> Informations personnelles</h5>
     	<ul id="listeLivre">
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