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

#Steps
. First install the pcf dev for your operating system as per the instructions provided in the url 
https://pivotal.io/academy/course/introduction-to-pivotal-cloud-foundry

. After installing the pcf dev.Start the pcf dev using the command
cf dev start

. Once pcf is started login to cf using your credentials
cf login -a https://api.local.pcfdev.io --skip-ssl-validation
Enter your username and password

. Clone the repository git clone https://github.com/eddy8700/spring-cloud-hash-broker.git

. Go To the servive-broker-hasmap project and run the following commands to build the project

mvn clean

mvn package -DskipTests

. Now push the service on the pcf dev using cf push command it will read the configuration from manifest.yml file of the project.

.Once the app is running, register the broker with the Cloud Controller (substitute the route for your broker app):

cf create-service-broker hashmap-service-broker username password http://hashmap-service-broker.local.pcfdev.io

.Next, we need to make the service plan public, as all plans start private by default.

cf enable-service-access service-name(hashmap-service-broker)

.You should now be able to see your service in the marketplace:
cf marketplace

.Next, create an instance of your service:

cf create-service service-name basic custom-hash

Now it’s time to push and bind to the client app.Go to hashmap-broker-client and run 


mvn clean

mvn package -DskipTests

.We’ll use a CF application manifest to take care of our metadata, including binding to the HashBroker service.

Now push the client app using : cf push

.Once the application is running, you can test it:

http://route-of-your-client-application/HashBroker/{key-name}

This is PUT operation

Now put some value in this key for ex {"value":"bar"}

Now perform the GET call on the key to fetch the value 

http://route-of-your-client-application/HashBroker/{key-name} it will return value.


Routes
======
|Routes|Method|Description|
|------|------|-----------|
|/v2/catalog|GET|Service and its plan details by this broker|
|/v2/service_instances/:id|PUT|create a dedicated database for this service|
|/v2/service_instances/:id|DELETE|delete previously created database for this service|
|/v2/service_instances/:id/service_bindings/:id|PUT|create user and grant privilege for the database associated with service.|
|/v2/service_instances/:id/service_bindings/:id|DELETE|delete the user created previously for this binding.|












