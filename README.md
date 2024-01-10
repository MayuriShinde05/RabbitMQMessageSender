# RabbitMQMessageSender

We have RabbitMQ message sender which project have postman collection as well as what configuration need to be update into the application.properties file.

#### Application.properties
Update the below properties

spring.rabbitmq.host=
spring.rabbitmq.port=5672
spring.rabbitmq.username=
spring.rabbitmq.password=
spring.rabbitmq.virtual-host=

#### Load_Testing_Grab-SG.postman_collection.json
This is postman collection file to test

#### how to start the customizations-rmq-message.jar
you have to use below command for this:
java -Dspring.config.location=<Path_of_properties_file>\application.properties -jar customizations-rmq-message.jar

This is the specific queue/exchange messgae sending project.
It will give the idea how to send message to the RabbitMQ.
