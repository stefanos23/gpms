package unitTest;

import gpms.codex.mock.server.DatabaseInterface;
import gpms.codex.mock.server.UserProfile;
import junit.framework.TestCase;

public class ServerSideTest extends TestCase {

	// test the getProfile method
	public void testDatabaseInterface() {

		DatabaseInterface db = new DatabaseInterface();
		assertSame(null, db.getProfileByName("asd123123123123"));
		assertSame(null, db.getProfileByName(null));
		assertEquals(UserProfile.class, db.getProfileByName("asdasd")
				.getClass());

	}

}
