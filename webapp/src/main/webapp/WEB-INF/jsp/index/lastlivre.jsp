<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>

<h2 class="col-12 text-center">Sorties récentes</h2>

			
			
			
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
			
			
			
</body>
</html>