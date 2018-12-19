<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Réservation</title>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>


</head>
<body style="margin: 0; padding: 0;">


                <p>Bonjour ${prenom} ${nom},</p>
                <p>Suite à votre demande de réservation, nous vous informons que le livre suivant est désormais disponible et nous vous invitons à le récupérer</p>

                <p>
                	Nom du livre : ${livre.getTitre()} <br />
                	Date de fin de la réservation : ${resa.getFinResa()}
                </p>

                <p>Nous vous remercions par avance de faire le nécessaire</p>
                <p>Cordialement <br />
                Biblio OCR
                </p>


</body>
</html>