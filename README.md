# Proiect Java Linte Robert
#### **_Descrierea proiectului_**
Aplicatia isi propune crearea unui site de lictiatii online. Astfel, un user se poate loga (fiind 3 tipuri de useri: admin, buyer, seller) si poate licita sau posta diferite produse. 
1. Define 10 business requirements for the chosen business domain
   - sign up
   - login cu email si parola
   - change password
   - adaugare fonduri in cont (de pe un card asociat contului)
   - asociere card catre cont
   - create product daca user-ul are rolul de seller
   - make bit daca user-ul are rolul de buyer. In acest caz se verifica ca soldul userului sa fie suficient de mare iar mai apoi se transmite o notificare catre seller ca are o oferta cat si catre vechiul client (in caz ca exista) ca s-a facut o oferta mai mare.
   - edit product
   - add images to product
   - get products by page cu sortare in functie de un field
   - alte operatii basic de tip deleteById, getById, getPorudctsByUsername, etc
2. Prepare a document based on the 10 business requirements containing a description of 5 main
features your project should contain for the MVP (minimum viable product) phase
   - sign-up: pentru crearea unui cont se va cere: un username, o adresa de email (trebuie sa fie unica), o parola (care va fi criptata pentru a oferi o securitate mai sporita). Pentru login si change password se folosesc operatii similare de criptare si decriptare pe baza parolei.
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/cee84fa2-c90c-45da-9dce-94e31b685ec0)
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/f49dcd91-2719-4f00-a145-fe7c54d14db5)
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/49b1648e-6c31-4f42-8eb4-45a35d6a3b4b)
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/16c8a35e-86da-4a52-8554-5282d5d3b647)
   - create product: pentru crearea unui produs trebuie sa furnizam id-ul user-ului care creaza produsul, si detaliile produsului. De asemenea se vor face diferite validari precum: pretul sa fie mai mare ca 0, user ul sa aibe rolul de seller sau endTime > dateTime.now(). La creare se poate primi si o lista de imagini aferente produsului
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/99f7b3bb-c2ff-49ef-a6bf-a05ca5bc2e8a)
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/15417fbc-6bc0-4716-8fa0-3ee30d567e92)
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/3cde8557-eac4-497b-87a3-372983e1f043)
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/f22fa9c0-4e59-4a8c-a3b8-9abdfa1fb0fe)
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/29821af5-e308-453f-9836-625783f15cd1)
   - asociere card catre un cont: pentru a putea pe viitor sa adauge bani in cont
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/41cbf15f-d04c-46e1-a1f0-deaecb178bed)
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/43a46d20-7ecb-49c5-a332-bb2efd56c9ab)
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/b8eec857-217b-4285-8901-93e82a77ccd3)
   - adaugare fonduri in cont
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/8e4a587a-9733-442f-9ead-744eb148759d)
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/49ee27d0-c3b6-4066-b3c8-fd4cdc495c36)
   - adaugare review
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/58e5a487-2da4-4887-aee6-271c26fa1c93)
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/53175ed1-a899-45cf-b2b4-eb262a3b9873)
     ![image](https://github.com/linterobert/JavaBiddingApp/assets/80642370/243e8cdb-78a0-461d-8cf4-58b9ce429709)















   
