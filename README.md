# spring-cloud-hash-broker

Create Hash Map As a Service Broker and service should be available to other Cloud Foundary applications once it gets registered.

# Prerequisite
Java 1.7 or higher
Pivotal Cloud Foundary PCF DEV
MYSQL 


#Steps
1. First install the pcf dev for your operating system as per the instructions provided in the url 
https://pivotal.io/academy/course/introduction-to-pivotal-cloud-foundry
2.After installing the pcf dev.Start the pcf dev using the command
cf dev start
3.Once pcf is started login to cf using your credentials
cf login -a https://api.local.pcfdev.io --skip-ssl-validation
Enter your username and password
4.To register the service broker .First you need to push the service on pcf dev using the following command
cf push <name-of-service> -m <memory-required> -p <path to your service jar>
5.Once the service is successfully registered on the pcf dev.Now register it as a service broker 

