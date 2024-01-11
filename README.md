# RabbitMQMessageSender

We have RabbitMQ message sender which projects have postman collection as well as what configuration needs to be updated into the application.properties file.

#### Application.properties
Update the below properties

spring.rabbitmq.host=
spring.rabbitmq.port=5672
spring.rabbitmq.username=
spring.rabbitmq.password=
spring.rabbitmq.virtual-host=

#### local_rmq_mesaaging_testing.postman_collection.json
This is a Postman collection file to test

#### curl_cmd.txt
In this file we also provide the CURL command those user are comfortable with CURL command they used.

#### how to start the customizations-rmq-message.jar
you have to use the below command for this:
java -Dspring.config.location=<Path_of_properties_file>\application.properties -jar customizations-rmq-message.jar

This is the specific queue/exchange message-sending project.
It will give the idea of how to send a message to the RabbitMQ.
