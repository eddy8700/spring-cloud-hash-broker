# spring-cloud-hash-broker

Create Hash Map As a Service Broker and service should be available to other Cloud Foundary applications once it gets registered.

# Prerequisite
Java 1.7 or higher
Pivotal Cloud Foundary PCF DEV
MYSQL 
CF CLI
VirtualBox: 5.0+


#Steps
1. First install the pcf dev for your operating system as per the instructions provided in the url 
https://pivotal.io/academy/course/introduction-to-pivotal-cloud-foundry
2.After installing the pcf dev.Start the pcf dev using the command
cf dev start
3.Once pcf is started login to cf using your credentials
cf login -a https://api.local.pcfdev.io --skip-ssl-validation
Enter your username and password
4.To register the service broker .Create the jar file using mvn package command
First you need to push the service on pcf dev using the following command(Run the command from the project directory folder)
cf push <name-of-service> -m <memory-required> -p <path to your service jar>
5.Once the app is running, register the broker with the Cloud Controller
cf create-service-broker <service-name> <username> <password> http://service-broker-url
6.Make the service broker public by calling v2/service_instances/{id} url .So that it register with the cloud controller.


