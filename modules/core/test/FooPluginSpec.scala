import java.io.File
import org.specs2._
import play.api.Play.current
import play.api.test._
import plugins._

class FooPluginSpec extends mutable.Specification {

  "The core sub-project" should {

    "return baz from the FooPlugin" in new WithApplication {

      current.plugin[FooPlugin] must beSome[FooPlugin]

      current.plugin[FooPlugin].get.bar === "baz"

    }

    "know about the salat plugin when explicitly given the plugin some configuration" in new WithApplication(FakeApplication(
      additionalConfiguration = Map("mongodb.default.uri" -> "mongodb://127.0.0.1:27017/nexxPortal")
    )) {

      current.plugin[se.radley.plugin.salat.SalatPlugin] must beSome[se.radley.plugin.salat.SalatPlugin]

    }

    "know about the salat plugin by inheriting the root project configuration" in new WithApplication {

  		current.plugin[se.radley.plugin.salat.SalatPlugin] must beSome[se.radley.plugin.salat.SalatPlugin]

    }

    "know about the salat plugin by explicitly setting the path to the root project" in new WithApplication(FakeApplication(path = new File("../../."))) {

  		current.plugin[se.radley.plugin.salat.SalatPlugin] must beSome[se.radley.plugin.salat.SalatPlugin]

    }

  }
}