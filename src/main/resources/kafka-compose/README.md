1. First write command as : docker compose up, it will take several minutes to pull docker image for kafka and zookeper image.
   Then write command as:  docker exec -it kafka bash

2. To create a topic: kafka-topics.sh --bootstrap-server localhost:9092 --create --topic t_hello --partitions 1 --replication-factor 1

3lets delete topic t_test: kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic t_test

4. To see the specific partition of a topic: kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic t_multi_partitions --offset earliest --partition 0

5. To modify the existing topics with the numbers of partitions: kafka-topics.sh --bootstrap-server localhost:9092 --alter --topic t_multi_partitions --partitions 4

6. Consumer group operation: 

    1. kafka-consumer-groups.sh --bootstrap-server localhost:9092 --groups cg-dashboard --describe
    2. kafka-consumer-groups.sh --bootstrap-server localhost:9092 --group cg-notification --describe
    3. kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list
    4. kafka-consumer-groups.sh --bootstrap-server localhost:9092 --groups cg-dashboard --execute --reset-offsets --to-offset 10 --topic t_commodity:0
    5. kafka-consumer-groups.sh --bootstrap-server localhost:9092 --groups cg-dashboard --describe
       Now cg-dashboard, will read data from offset 10
