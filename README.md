"# scloud" 

e:spring cloud config server
f:spring cloud config client(bus)

For bus
1.pom.xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>

2.application.yml
spring:
  rabbitmq:
    host: 192.168.56.101
    port: 5672
    username: admin
    password: admin
	
3.@RefreshScope annotation on specified class