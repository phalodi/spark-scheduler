# spark-scheduler
* Librabry to schedule spark jobs related to time interval, We just start this project as open source our main goal for this library to support the schdeuling of spark jobs and many for components we can add please share your idea.

* Right now we dont have dependency on maven central repository so to use it simply add jar of this by creating using below command

>sbt package

using above command you will get jar in /target/scala-2.11/*.jar

* For now we provide the Scheduler object which have api schedule(spark_job,initialDelay,timeInterval) to schedule the spark jobs. for example
```
package org.phalodi.examples

import org.apache.spark.sql.SparkSession
import org.phalodi.Scheduler

object SparkScheduler extends App {

  val spark=SparkSession.builder().master("local[*]").appName("scheduler").getOrCreate()
  val rdd = spark.sparkContext.parallelize(List(2,3,4,5,4))

  Scheduler.schedule(rdd.count(),0,10)
}
```

