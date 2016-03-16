package unitTest;

import gpms.codex.app.LocalInfo;
import gpms.codex.app.RegisterController;
import junit.framework.TestCase;

public class ClientSideTest extends TestCase {

	// Test that results are returned in the right format
	public void testGetLocalInfo() {
		LocalInfo local = new LocalInfo();
		String ip = local.getMacAddressFromIp();
		assertNotNull(ip);
	}

	// Test email format function
	public void testMailFormat() {

		assertSame(false, RegisterController.validateMail("asd@asdasdasd."));
		assertSame(false, RegisterController.validateMail("aasdsd."));
		assertSame(false,
				RegisterController.validateMail("as123e313123123123dasdasd."));
		assertSame(false,
				RegisterController.validateMail("aasd123123123*&(^*7"));
		assertSame(false, RegisterController.validateMail(".@2,2"));
		assertSame(true, RegisterController.validateMail("name@name.asd"));
		assertSame(false, RegisterController.validateMail(null));

	}

	// Test name format function
	public void testRealName() {

		assertSame(false, RegisterController.validateRealName("asdasd231123"));
		assertSame(true, RegisterController.validateRealName("as"));
		assertSame(false, RegisterController.validateRealName("123123"));
		assertSame(false, RegisterController.validateRealName("QWE^&*("));
		assertSame(false,
				RegisterController
						.validateRealName("3242472349234234234234234234234234"));
		assertSame(true, RegisterController.validateRealName("nick"));
		assertSame(false, RegisterController.validateRealName(""));
		assertSame(false, RegisterController.validateRealName(null));

	}

}
