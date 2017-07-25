#!/bin/sh

COMMAND=$1
shift


cd `dirname $0`
cd ..
STREAM_HOME=`pwd`

JAVA=$JAVA_HOME/bin/java
HEAP_OPTS="-Xmx1000m -XX:PermSize=128m -XX:MaxPermSize=256m"

CLASSPATH=${CLASSPATH}:$JAVA_HOME/lib/tools.jar
CLASSPATH=${CLASSPATH}:conf

source /etc/spark/conf/spark-env.sh
YARN_HOME=/opt/cloudera/parcels/CDH/lib/hadoop-yarn
HDFS_HOME=/opt/cloudera/parcels/CDH/lib/hadoop-hdfs


for f in $DEFAULT_HADOOP_HOME/*.jar; do
  CLASSPATH=${CLASSPATH}:$f;
done

for f in $DEFAULT_HADOOP_HOME/lib/*.jar; do
  CLASSPATH=${CLASSPATH}:$f;
done

for f in $YARN_HOME/*.jar; do
  CLASSPATH=${CLASSPATH}:$f;
done

for f in $HDFS_HOME/*.jar; do
  CLASSPATH=${CLASSPATH}:$f;
done

for f in $SPARK_HOME/lib/*.jar; do
  CLASSPATH=${CLASSPATH}:$f;
done

for f in $STREAM_HOME/*.jar; do
  CLASSPATH=${CLASSPATH}:$f;
  if [  `echo $f | grep  ga-mass-spark`  ];then
        YARN_JAR=$f;
  fi
done

for f in $STREAM_HOME/lib/*.jar; do
  CLASSPATH=${CLASSPATH}:$f;
  ST_LIBS=${ST_LIBS}:$f;
done

CLASS=com.ga.projects.spark.SparkJobSubmit

"$JAVA" -Djava.awt.headless=true $HEAP_OPTS -classpath "$CLASSPATH" $CLASS $STREAM_HOME $YARN_JAR $ST_LIBS
