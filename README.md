# microservices-version2
1.Spring Cloud LoadBalancer instead of Ribbon
2.Spring Cloud Gateway instead of Zuul
3.Resilience4j instead of Hystrix

limitsMicroservice      MicroserviceX     MicroserviceY

                    SpringCloudConfigServer

                    GitRepo

if our microservice has cloud-starter-config ,we need to import spring cloud config server using spring.config.import=optional:configserver:http://localhosy:8888
which is default port for spring cloud config server.
