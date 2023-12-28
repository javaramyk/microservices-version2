# microservices-version2
1.Spring Cloud LoadBalancer instead of Ribbon
2.Spring Cloud Gateway instead of Zuul
3.Resilience4j instead of Hystrix

limitsMicroservice      MicroserviceX     MicroserviceY

                    SpringCloudConfigServer

                    GitRepo

if our microservice has cloud-starter-config ,we need to import spring cloud config server using spring.config.import=optional:configserver:http://localhost:8888
which is default port for spring cloud config server.

In git-local-config-repo,the name of the properties file should be same the same as the application for which configuration properties is being configured.
we can set dev and qa environments as well for which application service we want to configured
