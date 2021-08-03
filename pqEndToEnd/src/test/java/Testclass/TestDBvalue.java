package Testclass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.DbTesting;

public class TestDBvalue {
	

	
	DbTesting db;
	@Parameters({"mobile"})
	@Test
	private void TestDBvaluefun(String mobile) {
		db=new DbTesting();
		db.adminleadobject(mobile);

	}

}
