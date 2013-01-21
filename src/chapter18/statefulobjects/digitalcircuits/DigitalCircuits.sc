package chapter18.statefulobjects.digitalcircuits

import chapter18.statefulobjects.digitalcircuits
import chapter18.statefulobjects.digitalcircuits.Wire

object DigitalCircuits {

  object MySimulation extends CircuitSimulation {
    def InverterDelay = 1
    def AndGateDelay = 3
    def OrGateDelay = 5
  }

  val input1, input2, sum, carry = new Wire

}