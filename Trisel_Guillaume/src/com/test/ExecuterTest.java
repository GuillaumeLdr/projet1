package com.test;


	import org.junit.runner.RunWith;
	import org.junit.runners.Suite;
	import org.junit.runners.Suite.SuiteClasses;
	
	@RunWith(Suite.class)
	@SuiteClasses(value={ // on note la liste des classes de test à enchainer
	CamionTest.class,
	ChauffeurTest.class,
	TypeDechetTest.class,
	FactureTest.class,
	LeveeTest.class,
	PoubelleTest.class,
	HabitationTest.class,
	UsagerTest.class})
	
	public class ExecuterTest {
	public static void main(String[] args) {
		org.junit.runner.JUnitCore.main(
				"ExecuterTests");
	}
}
