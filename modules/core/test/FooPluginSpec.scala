import org.specs2._
import play.api.Play.current
import play.api.test._
import plugins._

class FooPluginSpec extends mutable.Specification {

  "The FooPlugin" should {

    "return baz" in new WithApplication {

      current.plugin[FooPlugin] must beSome[FooPlugin]

      current.plugin[FooPlugin].get.bar === "baz"

    }

    "know about the salat plugin" in new WithApplication {

		current.plugin[se.radley.plugin.salat.SalatPlugin] must beSome[se.radley.plugin.salat.SalatPlugin]

    }
  }
}
