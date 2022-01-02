# Getting Started

###How To Work With Apache Kafka In Spring Boot
Kafka can be a good option to solve our purpose. 
In a single line, Apache Kafka acts as a mediator to transmit data 
between applications that generate data and applications that consume data.

###How to Install Kafka
Extract ‘kafka_2.12-2.6.0.zip’ from package tools
to a folder.
now we can see folder ‘kafka_2.12-2.6.0’.
Copy this folder to a drive of your system like ‘C:/’ or ‘D:/’ drive.

###How to run Kafka nad Zookeeper
First go to the path of your Kafka in your system
> cmd>cd C:\kafka_2.12-2.6.0

Start Zookeeper
> cmd> .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

Start Kafka setup
> cmd> .\bin\windows\kafka-server-start.bat .\config\server.properties

Create a Topic
> cmd>.\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic myKafkaTest

After starting application Enter below URLs on the Browser and test the results
* http://localhost:9090/send/async?msg=I like
* http://localhost:9090/send/async?msg=to work on
* http://localhost:9090/send/async?msg=Kafka
* http://localhost:9090/send/async?msg=with Spring Boot
* http://localhost:9090/getAll
 