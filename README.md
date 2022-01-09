# P9-searchPatient

Ce module est un microservice Rest API dédié à la gestion des patients.

Test de l’application :

Tests unitaires :  
Lancer les tests unitaires du module avec l’instruction gradle build.  
Le rapport de couverture de code par les tests est disponible au directory : 
build/jacocoHtml/index.html  
ou directement au path :   
test/java/report/index.html

Tests des microservices :
Ouvrir Postman et tester les endpoints suivants :

Methodes Post :   
Ajouter les patients :  
172.23.0.4:8081/patient/add  
Json :  
{
"id":"1",
"uuid":"237e9877-e79b-12d4-a765-321741963000",
"firstname":"firstname",
"lastname":"testNone",
"phone":"100-222-3333",
"gender":"F",
"address":"1 Brookside St",
"birthdate":"1966-12-31"
}  

172.23.0.4:8081/patient/add  
{
"id":"2",
"uuid":"237e9877-e79b-12d4-a765-321741963001",
"firstname":"firstname",
"lastname":"testBorderline",
"phone":"200-333-4444",
"gender":"M",
"address":"2 High St",
"birthdate":"1945-06-24"
}  

172.23.0.4:8081/patient/add  
Json :  
{
"id":"3",
"uuid":"237e9877-e79b-12d4-a765-321741963002",
"lastname":"TestInDanger",
"firstname":"firstname",
"phone":"300-444-5555",
"gender":"M",
"address":"3 Club Road",
"birthdate":"2004-06-18"
}  

172.23.0.4:8081/patient/add  
Json : {   "id":"4",
"uuid":"237e9877-e79b-12d4-a765-321741963003",
"firstname":"firstname",
"lastname":"TestEarlyOnset",
"phone":"400-555-6666",
"gender":"F",
"address":"4 Valley Dr",
"birthdate":"2002-06-28"
}   


Méthodes Get :  
Récupérer un patient par son nom de famille :  
172.23.0.4:8081/patient/getByLastname/testBorderline  
Récupérer un patient par son id :  
172.23.0.4:8081/patient/get/2  
Récupérer la liste des patients :  
172.23.0.4:8081/patient/list  
172.23.0.4:8081/patient/getAll 