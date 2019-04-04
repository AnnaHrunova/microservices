# microservices

This repository is supposed to be a mini-model of microservice architecture.<br>
Repo consists of three mictoservices:<br>
1). users, where user data is stored; <br>
2). items, where items, that belongs to user are stored; <br>
3). web, where items and users 'are joined' and it is possible to get user data with items. <br>
If some of services is down and doesn't respond, then dummy response is sent. <br>
For example, is web microservice successfully gets user info from users microservice, <br>
but items microservice is down, then user data with dummy items is shown. <br>
Also, it is possible to deploy multiple instances of each microservice. <br>
That's why port, from which information has been got, is shown.<br>
<b>!!!<b>
spring cloud config folder for those microservices is stored in https://github.com/AnnaHrunova/config <br>
Plese, pull it and point it's path in https://github.com/AnnaHrunova/microservices/blob/master/config-server/src/main/resources/application.yaml <br>
properties file.

