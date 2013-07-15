package chapter5

object symbols {
	
	def updateRecordByName(r: Symbol, value: Any) = {
		r.name
	}                                         //> updateRecordByName: (r: Symbol, value: Any)String
	
	updateRecordByName('favoriteAlbum, "OK Computer")
                                                  //> res0: String = favoriteAlbum


}