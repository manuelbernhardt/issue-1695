package plugins

import play.api.Plugin
import play.api.Application

class BarPlugin(app: Application) extends Plugin {

  override def onStart() {
    println("BarPlugin starting")
  }

  override def onStop() {
    println("BarPlugin stopping")
  }

  def foo = "baz"

}
