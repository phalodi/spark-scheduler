package org.phalodi.examples

import org.apache.spark.sql.SparkSession

object SparkScheduler extends App {
  import org.phalodi.Scheduler._
  val spark=SparkSession.builder().master("local[*]").appName("scheduler").getOrCreate()
  val rdd = spark.sparkContext.parallelize(List("2","3","4","5","4"))
  rdd.schedule(rdd.count(),0,10)

}

object SparkSchedulerOnPairRDD extends App {
  import org.apache.spark.rdd._
  import org.phalodi.Scheduler._
  val spark=SparkSession.builder().master("local[*]").appName("scheduler").getOrCreate()
  val pairRDD=spark.sparkContext.parallelize(List(("2",1),("3",1),("4",1),("5",1),("4",1)))
  pairRDD.schedule(pairRDD.reduceByKey(_+_).collect(),0,5)
}
