import org.specs2._
import play.api.Play.current
import play.api.test._
import plugins._

class RootFooPluginSpec extends mutable.Specification {

  "The FooPlugin" should {

    "return baz in the root project" in new WithApplication {

      current.plugin[FooPlugin] must beSome[FooPlugin]

      current.plugin[FooPlugin].get.bar === "baz"

    }

    "know about the salat plugin in the root project" in new WithApplication {

		current.plugin[se.radley.plugin.salat.SalatPlugin] must beSome[se.radley.plugin.salat.SalatPlugin]

    }

  }
}
