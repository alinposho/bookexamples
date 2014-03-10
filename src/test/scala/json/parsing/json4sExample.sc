package json.parsing
import org.json4s._
import org.json4s.native.JsonMethods._

object json4sExample {

  val json = parse("""
         { "name": "joe",
           "children": [
             {
               "name": "Mary",
               "age": 5
             },
             {
               "name": "Mazy",
               "age": 3
             }
           ]
         }
       """)                                       //> json  : org.json4s.JValue = JObject(List((name,JString(joe)), (children,JArr
                                                  //| ay(List(JObject(List((name,JString(Mary)), (age,JInt(5)))), JObject(List((na
                                                  //| me,JString(Mazy)), (age,JInt(3)))))))))

  for {
    JObject(child) <- json
    JField("age", JInt(age)) <- child
  } yield age                                     //> res0: List[BigInt] = List(5, 3)

  val gcs = parse("""
 {
 "kind": "storage#object",
 "id": "wdgcstransport/afolder/output1394452502014.txt/1394452502803000",
 "selfLink": "https://www.googleapis.com/storage/v1/b/wdgcstransport/o/afolder%2Foutput1394452502014.txt",
 "name": "afolder/output1394452502014.txt",
 "bucket": "wdgcstransport",
 "generation": "1394452502803000",
 "metageneration": "1",
 "contentType": "text/plain",
 "updated": "2014-03-10T11:55:02.707Z",
 "size": "26",
 "md5Hash": "IlRpbv6MiP71l4e85NPXAA==",
 "mediaLink": "https://www.googleapis.com/storage/v1/b/wdgcstransport/o/afolder%2Foutput1394452502014.txt?generation=1394452502803000&alt=media",
 "owner": {
  "entity": "user-00b4903a971821b80aa490186610c244eb86cb68ff9860d2f22272ddde063eb0",
  "entityId": "00b4903a971821b80aa490186610c244eb86cb68ff9860d2f22272ddde063eb0"
 },
 "crc32c": "43KhRg==",
 "etag": "CLjk17D0h70CEAE="
}
 """)                                             //> gcs  : org.json4s.JValue = JObject(List((kind,JString(storage#object)), (id
                                                  //| ,JString(wdgcstransport/afolder/output1394452502014.txt/1394452502803000)),
                                                  //|  (selfLink,JString(https://www.googleapis.com/storage/v1/b/wdgcstransport/o
                                                  //| /afolder%2Foutput1394452502014.txt)), (name,JString(afolder/output139445250
                                                  //| 2014.txt)), (bucket,JString(wdgcstransport)), (generation,JString(139445250
                                                  //| 2803000)), (metageneration,JString(1)), (contentType,JString(text/plain)), 
                                                  //| (updated,JString(2014-03-10T11:55:02.707Z)), (size,JString(26)), (md5Hash,J
                                                  //| String(IlRpbv6MiP71l4e85NPXAA==)), (mediaLink,JString(https://www.googleapi
                                                  //| s.com/storage/v1/b/wdgcstransport/o/afolder%2Foutput1394452502014.txt?gener
                                                  //| ation=1394452502803000&alt=media)), (owner,JObject(List((entity,JString(use
                                                  //| r-00b4903a971821b80aa490186610c244eb86cb68ff9860d2f22272ddde063eb0)), (enti
                                                  //| tyId,JString(00b4903a971821b80aa490186610c244eb86cb68ff9860d2f22272ddde063e
                                                  //| b0))))), (crc32c,JStrin
                                                  //| Output exceeds cutoff limit.

  for {
    JObject(response) <- gcs
    JField("bucket", JString(bucket)) <- response
    JField("name", JString(name)) <- response
  } yield (bucket, name)                          //> res1: List[(String, String)] = List((wdgcstransport,afolder/output139445250
                                                  //| 2014.txt))

  for {
    JObject(response) <- gcs
    JField("updated", JString(updated)) <- response
  } yield updated                                 //> res2: List[String] = List(2014-03-10T11:55:02.707Z)

}