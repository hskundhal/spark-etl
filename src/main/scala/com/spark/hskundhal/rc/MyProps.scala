package com.spark.hskundhal.rc

import java.io.FileInputStream
import java.util.Properties

import scala.util.control.NonFatal

object MyProps {

  var properties: Properties = null

  try {
    properties = new Properties()
    properties.load(new FileInputStream("resources/config.properties"))
  }
  catch {
    case NonFatal(e) => {
      println("Error reading properties file")
      e.printStackTrace()
      sys.exit(-10)
    }
  }


  //val appConfig = properties

  val hrs4Grouping = properties.getProperty("hoursForGrouping")
  println("hrs4Grouping => " + hrs4Grouping)
  assert((hrs4Grouping != null) && (hrs4Grouping != ""),"hours for Grouping (hoursForGrouping)  is not available from properties file")


  val srcHost = properties.getProperty("Source_Hostname")
  println("source host => " + srcHost)
  assert((srcHost != null) && (srcHost != ""),"Source Hostname (srcHost) is not available from properties file")

  val srcDatabase = properties.getProperty("SourceDatabase")
  println("L102database => " + srcDatabase)
  assert((srcDatabase != null) && (srcDatabase != ""),"Source Database (srcDatabase) is not available from properties file")

  val srcUser = properties.getProperty("Source_User")
  println("L102_user => " + srcUser)
  assert((srcUser != null) && (srcUser != ""),"Source User (srcUser) is not available from properties file")

  val srcPassword = properties.getProperty("Source_password")
  println("L102_password => " + srcPassword)
  assert((srcPassword != null) && (srcPassword != ""),"Source Password (srcPassword) is not available from properties file")


  val jdbc = (s"jdbc:sqlserver://$srcHost;database=$srcDatabase;user=$srcUser;password=$srcPassword")
  println("jdbc string => " + jdbc)

  val hivetransformationDB = properties.getProperty("hive_transformation_db")
  println("hive_database => " + hivetransformationDB)
  assert((hivetransformationDB != null) && (hivetransformationDB != ""),"Hive Transformation Database name (hive_transformation_db) is not available from properties file")


  val hiveDestLandingDB = properties.getProperty("hive_Dest_landing_db")
  println("hive_Dest_landingDatabase => " + hiveDestLandingDB)
  assert((hiveDestLandingDB != null) && (hiveDestLandingDB != ""),"Hive Landing Database (hive_Dest_landing_db) name is not available from properties file")

  val hivedelayCodeLandingdb = properties.getProperty("hive_delaycode_landing_db")
  println("hive_delay_codelanding_db => " + hivedelayCodeLandingdb)
  assert((hivedelayCodeLandingdb != null) && (hivedelayCodeLandingdb != ""),"Hive Delay Code Landing Database (hive_delaycode_landing_db) name is not available from properties file")

  //val config = ConfigFactory.load(s"config/$appConfig")
  val inputDir = properties.getProperty("details.inputDir")
  println("source host => " + srcHost)
  val outDir = properties.getProperty("details.outDir")
  println("source host => " + srcHost)
  val configDir = properties.getProperty("details.configDir")
  println("source host => " + srcHost)
  val filePattern = properties.getProperty("details.filePattern")
  println("source host => " + srcHost)
  val appName = properties.getProperty("details.appName")
  println("source host => " + srcHost)
}
