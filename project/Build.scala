import sbt._
import sbt.Keys._
import play.Project._

object Build extends sbt.Build {

  val core = play.Project("core", path= file("modules/core")).settings(

 	libraryDependencies += "se.radley"              %% "play-plugins-salat"  % "1.3.0"
  
  )
  
  val root = play.Project("root").configs(IntegrationTest).settings(Defaults.itSettings : _*).dependsOn(core % "test->test;compile->compile").aggregate(core)
  
  override def rootProject = Some(root) 

}
