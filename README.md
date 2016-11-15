# spring-cloud-hash-broker

Create Hash Map As a Service Broker and service should be available to other Cloud Foundary applications once it gets registered.

# Prerequisite
Java 1.7 or higher
Pivotal Cloud Foundary PCF DEV
MYSQL 
CF CLI
VirtualBox: 5.0+


This lab will guide you through:

* deploying a Service Broker as an app to Cloud Foundry
* registering the Broker with the Cloud Controller
* making the single plan in the catalog ``public''
* creating an instance of a service
* pushing and binding a test app to that service
* testing the app's interaction with the service

== Steps
. First install the pcf dev for your operating system as per the instructions provided in the url 
https://pivotal.io/academy/course/introduction-to-pivotal-cloud-foundry
. After installing the pcf dev.Start the pcf dev using the command
----
cf dev start
----
. Once pcf is started login to cf using your credentials
----
cf login -a https://api.local.pcfdev.io --skip-ssl-validation
----
Enter your username and password



