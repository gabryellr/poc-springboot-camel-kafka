# poc-springboot-camel-kafka

## Spring boot application with Camel and Kafka

#### How to run


1. Download the 2.2.0 release and un-tar it: *http://ftp.unicamp.br/pub/apache/kafka/2.2.0/kafka_2.12-2.2.0.tgz*

    >`tar -xzf kafka_2.12-2.2.0.tgz` <br/>
    >`cd kafka_2.12-2.2.0`

2. start the Kafka server:
    >`bin/kafka-server-start.sh config/server.properties`

3. Lets create a topic named "test" with a single partition and only one replica
    > `bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test`

4. Send some messages <br/>
   > `bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test` <br/>
   > `> message 1` <br/>
   > `> message 2`

5. Clone this repository into another folder
`git clone https://github.com/gabryelrock/poc-springboot-camel-kafka.git`

6. Start the application typing it on the terminal
`gradle bootRun`

7. Back to the terminal where the **step 4** was done and send some messages again, now on the terminal where the application was started **(step 6)** you'll see the messages printed
