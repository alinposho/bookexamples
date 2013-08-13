package real.world.scala.dependency.injection.di.using.guice

import com.google.inject.Guice
import com.google.inject.Module
import com.google.inject.Binder
import com.google.inject.Stage
import com.google.inject.Inject

// =======================
// service interfaces
trait OnOffDevice {
  def on: Unit
  def off: Unit
}
trait SensorDevice {
  def isCoffeePresent: Boolean
}
trait IWarmer {
  def trigger
}
trait Client

// =======================
// service implementations
class Heater extends OnOffDevice {
  def on = println("heater.on")
  def off = println("heater.off")
}
class PotSensor extends SensorDevice {
  def isCoffeePresent = true
}

class Warmer @Inject()(val potSensor: SensorDevice, val heater: OnOffDevice) extends IWarmer {
  def trigger = {
    if (potSensor.isCoffeePresent) heater.on
    else heater.off
  }
}

// =======================
// client
@Inject
class MyClient @Inject()(val warmer: Warmer) extends Client {
  warmer.trigger
}

// =======================
// Guice's configuration class that is defining the 
// interface-implementation bindings 
class DependencyModule extends Module {
  def configure(binder: Binder) = {
    binder.bind(classOf[OnOffDevice]).to(classOf[Heater])
    binder.bind(classOf[SensorDevice]).to(classOf[PotSensor])
    binder.bind(classOf[IWarmer]).to(classOf[Warmer])
    binder.bind(classOf[Client]).to(classOf[MyClient])
  }
}

// =======================
// Usage: val bean = new Bean with ServiceInjector
trait ServiceInjector {
  ServiceInjector.inject(this)
}

// helper companion object 
object ServiceInjector {
  private val injector = Guice.createInjector(Stage.DEVELOPMENT, new DependencyModule)
  def inject(obj: AnyRef) = injector.injectMembers(obj)
}

object GoogleGuiceDI extends ServiceInjector{

  @Inject
  var client: MyClient = _
  
  def main(args: Array[String]): Unit = {
    println(client)
  }
}