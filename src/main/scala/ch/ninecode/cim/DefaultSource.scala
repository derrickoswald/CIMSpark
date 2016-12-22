package ch.ninecode.cim

import org.slf4j.LoggerFactory

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.sources._

     
class DefaultSource extends RelationProvider {
  private val log = LoggerFactory.getLogger(getClass) 
  
  override def createRelation(
      sqlContext: SQLContext,
      parameters: Map[String, String]): BaseRelation = {
    
    new CIMRelation(parameters)(sqlContext)
  }
}
