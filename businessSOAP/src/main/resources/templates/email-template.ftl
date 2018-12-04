<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Relance retard prêt</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


</head>
<body style="margin: 0; padding: 0;">


                <p>Bonjour ${prenom} ${nom},</p>
                <p>Veuillez prendre connaisance du retard suivant concernant l'un ou plusieurs de vos emprunts</p>
                <#list listeRetards as pret >
                <p>
                	Nom du livre : ${pret.getLivre().getTitre()} <br />
                	Date fin prévue : ${pret.getDateFin()}
                </p>
                </#list >
                <p>Nous vous remercions par avance de faire le nécessaire</p>
                <p>Cordialement <br />
                Biblio OCR
                </p>


</body>
</html>