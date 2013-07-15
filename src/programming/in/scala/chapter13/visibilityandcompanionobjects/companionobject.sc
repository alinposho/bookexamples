package chapter13.visibilityandcompanionobjects

object companionobject {
	val rocket = Rocket                       //> rocket  : chapter13.visibilityandcompanionobjects.Rocket.type = chapter13.vis
                                                  //| ibilityandcompanionobjects.Rocket$@654355f1
	rocket.chooseStrategy(new Rocket)         //> Picking a star

}