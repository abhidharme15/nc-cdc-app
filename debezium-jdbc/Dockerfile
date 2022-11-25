FROM debezium/connect:1.9
ENV KAFKA_CONNECT_JDBC_DIR=$KAFKA_CONNECT_PLUGINS_DIR/kafka-connect-jdbc

ARG POSTGRES_VERSION=42.5.0
ARG KAFKA_JDBC_VERSION=5.3.1

# Deploy PostgreSQL JDBC Driver
# RUN cd /kafka/libs 
# RUN curl -sO https://jdbc.postgresql.org/download/postgresql-$POSTGRES_VERSION.jar
COPY postgresql-42.4.1.jar /kafka/libs/postgresql-42.4.1.jar
RUN mkdir $KAFKA_CONNECT_JDBC_DIR
COPY kafka-connect-jdbc-5.3.1.jar $KAFKA_CONNECT_JDBC_DIR/kafka-connect-jdbc-5.3.1.jar


# Deploy Kafka Connect JDBC
# RUN mkdir $KAFKA_CONNECT_JDBC_DIR && cd $KAFKA_CONNECT_JDBC_DIR &&\
#	curl -sO https://packages.confluent.io/maven/io/confluent/kafka-connect-jdbc/$KAFKA_JDBC_VERSION/kafka-connect-jdbc-$KAFKA_JDBC_VERSION.jar