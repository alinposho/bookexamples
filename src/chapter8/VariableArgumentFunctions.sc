package chapter8

object VariableArgumentFunctions {

  def echo(s: String*) = s foreach (println)      //> echo: (s: String*)Unit

  echo()
  echo("1")                                       //> 1
  echo((1 to 10) mkString " ")                    //> 1 2 3 4 5 6 7 8 9 10

  echo("1", "some string")                        //> 1
                                                  //| some string
}