package scala

object xmlExample {
  
	val xml = """<?xml version="1.0" encoding="UTF-8"?><cloud-collection xmlns="urn:com.workday/esb/cloud/10.0" name="testIpRestrictionsDummyCollection"><integration name="testIpRestrictionsDummyCollection"><in-connector id="IN"><integration-system name="testIpRestrictionsDummyCollection"/></in-connector></integration><deployed-since>2014-05-26T14:01:17.785Z</deployed-since></cloud-collection>"""
                                                  //> xml  : String = <?xml version="1.0" encoding="UTF-8"?><cloud-collection xmln
                                                  //| s="urn:com.workday/esb/cloud/10.0" name="testIpRestrictionsDummyCollection">
                                                  //| <integration name="testIpRestrictionsDummyCollection"><in-connector id="IN">
                                                  //| <integration-system name="testIpRestrictionsDummyCollection"/></in-connector
                                                  //| ></integration><deployed-since>2014-05-26T14:01:17.785Z</deployed-since></cl
                                                  //| oud-collection>
	
	val cloudCollection = scala.xml.XML.loadString(xml.toString)
                                                  //> cloudCollection  : scala.xml.Elem = <cloud-collection name="testIpRestrictio
                                                  //| nsDummyCollection" xmlns="urn:com.workday/esb/cloud/10.0"><integration name=
                                                  //| "testIpRestrictionsDummyCollection"><in-connector id="IN"><integration-syste
                                                  //| m name="testIpRestrictionsDummyCollection"/></in-connector></integration><de
                                                  //| ployed-since>2014-05-26T14:01:17.785Z</deployed-since></cloud-collection>
	val collectionName = for(name <- (cloudCollection \ "@name")) yield  name.text
                                                  //> collectionName  : scala.collection.immutable.Seq[String] = List(testIpRestri
                                                  //| ctionsDummyCollection)
	
	
}