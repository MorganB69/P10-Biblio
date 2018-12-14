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
            <div class="col-xs-12 col-md-8 col-lg-8" id="left-column">




                <h5 class="collapsible-title mt-3" data-toggle="collapse" data-target="#associated-resa" aria-expanded="true" aria-controls="associated-resa">
                    <i class="fa fa-leanpub"></i> Mes réservations en cours <i class="fa fa-arrow-down pull-right"></i>
                </h5>
                <s:if test="%{listResa.isEmpty()==false}">
                    <s:iterator value="listResa">
                        <div class="collapse collapse show mt-3 mb-3" id="associated-resa" aria-expanded="true">

                            <div class="card card-body bg-light text-dark rounded">


                                <div class="row">

                                    <div class="col-lg-4 ">
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

                                    <div class="col-lg-8 ">

                                        <div class="card-body m-2 border border-primary rounded">
                                            <div class="row">
                                                <h4>Détail de la réservation :</h4>
                                            </div>
                                            <div class="row">
                                                <ul class="m-1" id="listeLivre">
                                                    <s:if test="debutResa!=null">
                                                    <li><b>Réservation commencée le : </b> <span id="attribut"><javatime:parseLocalDate value="${debutResa}" pattern="yyyy-MM-dd" var="date" /><javatime:format value="${date}" pattern="dd-MM-yyyy" /></span></li>
                                                    </s:if>
                                                    <s:if test="finResa!=null">
                                                    <li><b>Réservation terminée le : </b><span id="attribut"><javatime:parseLocalDate value="${finResa}" pattern="yyyy-MM-dd" var="date" /><javatime:format value="${date}" pattern="dd-MM-yyyy" /></span></li>
                                                    </s:if>
                                                    <li><b>Position file d'attente :</b></li>
                                                </ul>
                                            </div>


                                                    <s:a class="btn btn-danger m-3" action="deleteResa" >Annuler la réservation
                                                        <s:param name="idResa" value="id"></s:param>
                                                    </s:a>




                                        </div>



                                    </div>

                                </div>

                            </div>
                        </div>
                    </s:iterator>

                </s:if>
                <s:else>
                    Vous n'avez pas de réservation en cours.
                </s:else>





            </div>
            <div class="col-xs-12 col-md-4 col-lg-4" id="right-column">

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