package neophyte.part10.higher.order.functions

object emailExample {

  Email("subject", "text", "sender", "recipient") //> res0: neophyte.part10.higher.order.functions.Email = Email(subject,text,send
                                                  //| er,recipient)

  def createEmails(numberOf: Int): Seq[Email] = {
    for (i <- 1 to numberOf) yield Email("subject" + i, "text" + i, "sender" + i, "recipient" + i)
  }                                               //> createEmails: (numberOf: Int)Seq[neophyte.part10.higher.order.functions.Emai
                                                  //| l]

  def newMailsForUser(mails: Seq[Email], filter: EmailFilter): Seq[Email] = mails.filter(filter)
                                                  //> newMailsForUser: (mails: Seq[neophyte.part10.higher.order.functions.Email], 
                                                  //| filter: neophyte.part10.higher.order.functions.Email => Boolean)Seq[neophyte
                                                  //| .part10.higher.order.functions.Email]

  // Defined using anonymouse functions
  val sentByOneOf: (Set[String] => EmailFilter) =
    senders => (email => senders.contains(email.sender))
                                                  //> sentByOneOf  : Set[String] => (neophyte.part10.higher.order.functions.Email 
                                                  //| => Boolean) = <function1>

  // defined using functions that regular people can understand
  def sentByOneOfFnc(senders: Set[String]): EmailFilter = {
    def filter(email: Email): Boolean = senders.contains(email.sender)
    filter
  }                                               //> sentByOneOfFnc: (senders: Set[String])neophyte.part10.higher.order.functions
                                                  //| .Email => Boolean

  val filterSend = sentByOneOf(createEmails(10) map (_.sender) toSet)
                                                  //> filterSend  : neophyte.part10.higher.order.functions.Email => Boolean = <fun
                                                  //| ction1>

  filterSend(Email("subject", "text", "sender", "recipient"))
                                                  //> res1: Boolean = false

 // The two are completely the same, just that the one on the website is clutered with annonimous functions that hide what is happening
 // behind the secenes, but most importantly, it hides the intent.
  sentByOneOf(createEmails(10) map (_.sender) toSet)(Email("subject", "text", "sender", "recipient"))
                                                  //> res2: Boolean = false
  
  sentByOneOfFnc(createEmails(10) map (_.sender) toSet)(Email("subject", "text", "sender", "recipient"))
                                                  //> res3: Boolean = false

}