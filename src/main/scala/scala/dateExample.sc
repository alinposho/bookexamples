package scala

object dateExample {
	
	//val format = new java.text.SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss 'Z'")
	
	val formatDateTimeAndTimezone = new java.text.SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]")
                                                  //> formatDateTimeAndTimezone  : java.text.SimpleDateFormat = java.text.SimpleDa
                                                  //| teFormat@8ccb343f
	val dateTimeAndTimezone = "[23/May/2014:05:33:09 -0700]"
                                                  //> dateTimeAndTimezone  : String = [23/May/2014:05:33:09 -0700]
	
	val result = formatDateTimeAndTimezone.parse(dateTimeAndTimezone)
                                                  //> result  : java.util.Date = Fri May 23 13:33:09 IST 2014
	val result2 = formatDateTimeAndTimezone.parse(dateTimeAndTimezone)
                                                  //> result2  : java.util.Date = Fri May 23 13:33:09 IST 2014
	result == result2                         //> res0: Boolean = true
	
	val formatDate = new java.text.SimpleDateFormat("dd/MMM/yyyy")
                                                  //> formatDate  : java.text.SimpleDateFormat = java.text.SimpleDateFormat@7cc505
                                                  //| 11
	val date = "23/May/2014"                  //> date  : String = 23/May/2014
	formatDate.parse(date)                    //> res1: java.util.Date = Fri May 23 00:00:00 IST 2014



}