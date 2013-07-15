package chapter18.statefulobjects.digitalcircuits

import chapter18.statefulobjects.digitalcircuits

object DigitalCircuits {

  object MySimulation extends CircuitSimulation {
    def InverterDelay = 1
    def AndGateDelay = 3
    def OrGateDelay = 5
  }

  // Accessing inner class Wire is achieved similar to Java, by prepending the name
  // of the inner class with the name of the outer class
  val input1, input2, sum, carry = new MySimulation.Wire
                                                  //> input1  : chapter18.statefulobjects.digitalcircuits.DigitalCircuits.MySimula
                                                  //| tion.Wire = chapter18.statefulobjects.digitalcircuits.BasicCircuitSimulation
                                                  //| $Wire@2be2e854
                                                  //| input2  : chapter18.statefulobjects.digitalcircuits.DigitalCircuits.MySimula
                                                  //| tion.Wire = chapter18.statefulobjects.digitalcircuits.BasicCircuitSimulation
                                                  //| $Wire@cea9d22
                                                  //| sum  : chapter18.statefulobjects.digitalcircuits.DigitalCircuits.MySimulatio
                                                  //| n.Wire = chapter18.statefulobjects.digitalcircuits.BasicCircuitSimulation$Wi
                                                  //| re@7ef229cd
                                                  //| carry  : chapter18.statefulobjects.digitalcircuits.DigitalCircuits.MySimulat
                                                  //| ion.Wire = chapter18.statefulobjects.digitalcircuits.BasicCircuitSimulation$
                                                  //| Wire@4c9692d7

  // Or one can also import the methods in a class like this
  import MySimulation._

  // The call these methods
  probe("sum", sum)                               //> sum 0 new-value = false

  probe("carry", carry)                           //> carry 0 new-value = false
  
  halfAdder(input1, input2, sum, carry)
  
  input1 setSignal true
  
  run()                                           //> *** simulation started, time = 0***
                                                  //| sum 8 new-value = true
  
  input2 setSignal true
  
  run()                                           //> *** simulation started, time = 8***
                                                  //| carry 11 new-value = true
                                                  //| sum 15 new-value = false
  
}