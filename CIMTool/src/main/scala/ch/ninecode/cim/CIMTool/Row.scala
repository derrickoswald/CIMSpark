package ch.ninecode.cim.CIMTool

import java.util.Map

case class Row (fields: Map[String,Object])
{
    def this (raw: Object) = this (raw.asInstanceOf[Map[String,Object]])

    def getInt (name: String): Int =
    {
        val raw = fields.get (name)
        if ((null != raw) && raw.isInstanceOf[Int])
            raw.asInstanceOf[Int]
        else
            0
    }

    def getString (name: String): String =
    {
        val raw = fields.get (name)
        if (null != raw)
            raw.toString
        else
            ""
    }

    def getTrimmedString (name: String): String =
    {
        val text = getString (name)
        if (null != text)
        {
            val trimmed = text.trim
            if (0 != trimmed.length)
                trimmed
            else
                null
        }
        else
            null
    }

    def isNull (name: String): Boolean = null != fields.get (name)

    def getObjectID          = getInt ("Object_ID")
    def getPackageID         = getInt ("Package_ID")
    def getParentID          = getInt ("Parent_ID")
    def getStartObjectID     = getInt ("Start_Object_ID")
    def getEndObjectID       = getInt ("End_Object_ID")
    def getClassifier        = getInt ("Classifier")
    def hasClassifier        = 0 != getClassifier
    def getXUID              = { val xuid = getString ("ea_guid"); "_" + xuid.substring (1, xuid.length - 1) }
    def getName              = getString ("Name")
    def getObjectType        = getString ("Object_Type")
    def getConnectorType     = getString ("Connector_Type")
    def getNote              = getTrimmedString ("Note")
    def getNotes             = getTrimmedString ("Notes")
    def getStereotype        = getString ("Stereotype")
    def hasStereotype        = isNull ("Stereotype")
    def hasDefault           = isNull ("Default")
    def getDefault           = getString ("Default")
    def getDestRole          = getString ("DestRole")
    def getDestRoleNote      = getString ("DestRoleNote")
    def getDestCard          = getString ("DestCard")
    def getDestIsAggregate   = 0 != getInt ("DestIsAggregate")
    def getSourceRole        = getString ("SourceRole")
    def getSourceRoleNote    = getString ("SourceRoleNote")
    def getSourceCard        = getString ("SourceCard")
    def getSourceIsAggregate = 0 != getInt ("SourceIsAggregate")
    def getType              = getString ("Type")
}