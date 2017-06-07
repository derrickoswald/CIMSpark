package ch.ninecode.model

import org.apache.spark.sql.Row

import ch.ninecode.cim.Context
import ch.ninecode.cim.Parseable

/*
 * Package: Work
 */

case class BaseWork
(
    override val sup: Document,
    val kind: String,
    val statusKind: String,
    val WorkLocation: String,
    val priority: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null) }
    def Document: Document = sup.asInstanceOf[Document]
    override def copy (): Row = { return (clone ().asInstanceOf[BaseWork]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object BaseWork
extends
    Parseable[BaseWork]
{
    val kind = parse_attribute (attribute ("""BaseWork.kind"""))
    val statusKind = parse_attribute (attribute ("""BaseWork.statusKind"""))
    val WorkLocation = parse_attribute (attribute ("""BaseWork.WorkLocation"""))
    val priority = parse_attribute (attribute ("""BaseWork.priority"""))
    def parse (context: Context): BaseWork =
    {
        return (
            BaseWork
            (
                Document.parse (context),
                kind (context),
                statusKind (context),
                WorkLocation (context),
                priority (context)
            )
        )
    }
}

case class Work
(
    override val sup: BaseWork,
    val requestDateTime: String,
    val BusinessCase: String,
    val ErpProjectAccounting: String,
    val Project: String,
    val WorkBillingInfo: String
)
extends
    Element
{
    def this () = { this (null, null, null, null, null, null) }
    def BaseWork: BaseWork = sup.asInstanceOf[BaseWork]
    override def copy (): Row = { return (clone ().asInstanceOf[Work]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object Work
extends
    Parseable[Work]
{
    val requestDateTime = parse_element (element ("""Work.requestDateTime"""))
    val BusinessCase = parse_attribute (attribute ("""Work.BusinessCase"""))
    val ErpProjectAccounting = parse_attribute (attribute ("""Work.ErpProjectAccounting"""))
    val Project = parse_attribute (attribute ("""Work.Project"""))
    val WorkBillingInfo = parse_attribute (attribute ("""Work.WorkBillingInfo"""))
    def parse (context: Context): Work =
    {
        return (
            Work
            (
                BaseWork.parse (context),
                requestDateTime (context),
                BusinessCase (context),
                ErpProjectAccounting (context),
                Project (context),
                WorkBillingInfo (context)
            )
        )
    }
}

case class WorkLocation
(
    override val sup: Location,
    val OneCallRequest: String
)
extends
    Element
{
    def this () = { this (null, null) }
    def Location: Location = sup.asInstanceOf[Location]
    override def copy (): Row = { return (clone ().asInstanceOf[WorkLocation]); }
    override def get (i: Int): Object =
    {
        if (i < productArity)
            productElement (i).asInstanceOf[AnyRef]
        else
            throw new IllegalArgumentException ("invalid property index " + i)
    }
    override def length: Int = productArity
}

object WorkLocation
extends
    Parseable[WorkLocation]
{Work
    val OneCallRequest = parse_element (element ("""WorkLocation.OneCallRequest"""))
    def parse (context: Context): WorkLocation =
    {
        return (
            WorkLocation
            (
                Location.parse (context),
                OneCallRequest (context)
            )
        )
    }
}

object _Work
{
    def register: Unit =
    {
      BaseWork.register
      Work.register
      WorkLocation.register
    }
}
