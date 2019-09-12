
    test ("ExportDiagramsAllTransformersFile")
    {
        implicit spark: SparkSession ⇒

            val options = new HashMap[String, String]().asInstanceOf [Map[String, String]]
            options.put ("ch.ninecode.cim.do_topo_islands", "true")
            val elements = readFile (FILE_DEPOT + "cim_export_ews_oberiberg.rdf", options)
            println (elements.count + " elements")
            val start = System.nanoTime
            val export = new CIMExport (spark)
            export.exportAllTransformers (FILE_DEPOT + "cim_export_ews_oberiberg.rdf", "target/")
            println ("process: %s seconds".format ((System.nanoTime - start) / 1e9))

            // remove all RDD to start from scratch
            spark.sparkContext.getPersistentRDDs.foreach (x ⇒ { x._2.unpersist(true); x._2.name = null })

            val elements2 = readFile ("target/TRA153" + ".rdf")
            println (elements2.count + " elements")
            val checker = new CIMIntegrityChecker (spark)
            val errors = checker.checkAll
            println (if (errors.isDefined) errors.get else "no errors")
            assert (errors.isEmpty, "reference errors")
    }
