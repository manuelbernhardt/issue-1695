package plugins

import play.api.Plugin
import play.api.Application

class FooPlugin(app: Application) extends Plugin {

  override def onStart() {
    println("FooPlugin starting")
  }

  override def onStop() {
    println("FooPlugin stopping")
  }

  def bar = "baz"

}