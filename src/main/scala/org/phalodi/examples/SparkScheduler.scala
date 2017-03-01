package org.phalodi.examples

import org.apache.spark.sql.SparkSession
import org.phalodi.Scheduler

object SparkScheduler extends App {

  val spark=SparkSession.builder().master("local[*]").appName("scheduler").getOrCreate()
  val rdd = spark.sparkContext.parallelize(List(2,3,4,5,4))

  Scheduler.schedule(rdd.count(),0,10)
}
