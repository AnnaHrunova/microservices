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
That's why port, from which information has been got, is shown.<br><br>
<b>!!! Notes !!!</b><br>
Main page: http://localhost:8089/microservices/web/src/webapp/html/allUsers.html <br>
User creating page: http://localhost:8089/microservices/web/src/webapp/html/createUser.html <br>
<b>***</b> config-server and service-registry should be started firstly. <br><br>
<b>Used technologies:</b> spring boot, spring cloud, Eureka, Feign, Ribbon, Embedded mongo.<br><br>
<b>TODO:</b> add tests, prettify UI
