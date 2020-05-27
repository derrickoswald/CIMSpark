package ch.ninecode.cim

import org.scalatest.Suites

/*
 * Note:
 * Any execution performed within the eclipse environment can be used for hprof profiling.
 * The procedure is:
 * 1) Execute the program or unit test in Eclipse.
 * 2) In the Debug or Run window, right click on the Target or the now terminated program and select properties.
 * 3) Copy the contents of the Command Line text area, and paste into a new file.
 * 4) Change the -agentlib:ZZZZ specification to an hprof valid configuration, see:
 *    https://docs.oracle.com/javase/7/docs/technotes/samples/hprof.html
 *    some examples:
 *       -agentlib:hprof=cpu=samples
 *       -agentlib:hprof=heap=sites,depth=10
 * 5) Mark the file as executable.
 * 6) Execute the file.
 * 7) Interpret the generated file (default: java.hprof.txt).
 */
class TestSuite extends Suites (
    new CHIMSuite,
    new CIMSuite,
    new CIMRDDSuite,
    new CIMSparkSuite,
    new CIMNetworkTopologyProcessorSuite,
    new CIMIntegrityCheckSuite,
    new CIMAboutSuite,
    new CIMNormalizeSuite,
    new CIMCacheSuite
)
