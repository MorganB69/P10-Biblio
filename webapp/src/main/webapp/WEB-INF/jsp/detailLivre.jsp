<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://sargue.net/jsptags/time" prefix="javatime" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="livre.titre"/></title>
</head>
<body>
	<header> 
	<%@ include file="include/nav.jsp"%>  


	</header>
	
	    <!-- Page Content -->
    <div class="container" id="detail-cont">
    
    	<section>

      <!-- Page Heading/Breadcrumbs -->

            <h1 class="text-center text-uppercase"><s:property value="livre.titre"/>
      		</h1>
      <div class="row">
      		<div class="col-xs-12 col-md-2 col-lg-2" id="left-column">
      		            <div class="row  pt-5">
      		             
       	 <figure class="figure m-3 " >
          <img class="figure-img img-fluid rounded " id="detailImgLivre" src="images/livre/<s:property value="livre.image"/>"alt="Livre image">
        </figure>
       </div>
      		</div>
      
             <div class="col-xs-12 col-md-5 col-lg-6" id="center-column">


        
        <s:if test="%{livre.resume!=''}">
        <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-desc" aria-expanded="true" aria-controls="associated-desc">
      	   		<i class="fa fa-leanpub"></i> Résumé <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3 mb-3" id="associated-desc" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     				<p><s:property value="livre.resume"/></p><br>
		
       		</div>
    
  </div>
  		</s:if>
  		
  		
  		
         
     
        
      </div>
      <div class="col-xs-12 col-md-5 col-lg-4" id="right-column">
        		    <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-detail" aria-expanded="true" aria-controls="associated-detail">
      	   		<i class="fa fa-leanpub"></i> Détails <i class="fa fa-arrow-down pull-right"></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3 mb-3" id="associated-detail" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
	        <ul>
	        <li><b>Auteur(s) :</b><s:iterator value="livre.auteurs">
									 				 <span id="attribut"><s:property value="prenom"/>  <s:property value="nom"/></span>
									 				</s:iterator>
									 			</li>
									 			
									 			<li><b>Editeur(s) :</b><s:iterator value="livre.editeurs">
									 				 <span id="attribut"><s:property value="nom"/></span>  
									 				</s:iterator>
									 			</li>
									 			
									 			<li><b> Genre :  </b><s:iterator value="livre.genres">
									 				 <span id="attribut"> <s:property value="genre"/></span> 
									 				</s:iterator>
									 			</li>
									 			
									 			<li><b> Parution : </b><span id="attribut"><javatime:parseLocalDate value="${livre.parution}" pattern="yyyy-MM-dd" var="date" /><javatime:format value="${date}" pattern="dd-MM-yyyy" /></span> </li>
											
	        
	        </ul>
		
       		</div>
    
  </div>
  
      
 
      
      <h5 class="mt-3" data-toggle="collapse" href="#associated-situ" aria-expanded="true" aria-controls="associated-situ">
      	   		<i class="fa fa-info-circle"></i> Informations <i class="fa fa-arrow-down pull-right" ></i>
      	    </h5>
      	    
      	    <div class="collapse collapse show mt-3 mb-3" id="associated-situ" aria-expanded="true">
    		
      		<div class="card card-body bg-light text-dark rounded">
      	
        
     	<ul>
						<s:if test="livre.disponible==true">
												<li><b>Disponibilité :</b> <i class="fa fa-check-circle m-1" id="iconStatut"></i> <span id="statut">Le livre est disponible</span></li>
												</s:if>
												<s:else>
												<li>
												<b>Disponibilité :</b> <i class="fa fa-times-circle m-1" id="iconStatutIndispo"></i> <span id="statutIndispo">Le livre est emprunté</span>
												</li>
												<li>
												<b>Date de retour prévue :</b>  <span id="attribut"> <javatime:parseLocalDate value="${dateRetour}" pattern="yyyy-MM-dd" var="date" /><javatime:format value="${date}" pattern="dd-MM-yyyy" /></span>
												</li>
												
												</s:else>
												
												
												
												
												
												
									 			
									 			
									 			
           				    
		</ul>

		
		
		
    
  </div>
  <s:actionmessage/>
      	    
      </div>
      

      </div>

	</section>
	</div>
	
	
      
      
	
	
	<footer> <%@ include file="include/footer.jsp"%> </footer>
</body>
</html>