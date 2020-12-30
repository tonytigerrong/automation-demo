cd C:\DevEnv\kafka_2.13-2.5.0\bin\windows
.\kafka-server-start.bat ..\..\config\server.properties

# create a topic "test_topic"
C:\DevEnv\kafka_2.13-2.5.0\bin\windows>kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test_topic
