package org.phalodi

import akka.actor.ActorSystem
import org.apache.spark.rdd.RDD
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits._

object Scheduler {

  val system=ActorSystem("system")

  implicit class RDDApis(rdd: RDD[_]){
    def schedule[T](x: =>T,intialTime:Long,timeInterval:Long) = {
      system.scheduler.schedule(intialTime seconds, timeInterval seconds)(x)
    }
  }
}