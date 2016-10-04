package ch.ninecode

import org.scalatest.Suites

class TestSuite extends Suites (
  new CIMSuite,
  new CIMRDDSuite,
  new CIMSparkSuite,
  new CIMNetworkTopologyProcessorSuite
)
