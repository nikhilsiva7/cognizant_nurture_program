import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BasicJUnitTest {

    private String testString;

    // Setup method runs before every test
    @Before
    public void setUp() {
        testString = "JUnit is working";
        System.out.println("Setup: Initializing test environment.");
    }

    // Teardown method runs after every test
    @After
    public void tearDown() {
        testString = null;
        System.out.println("Teardown: Cleaning up test environment.\n");
    }

    // Testing various Assertions
    @Test
    public void testAssertions() {
        System.out.println("Running testAssertions...");
        assertEquals(5, 2 + 3);
        assertTrue(5 > 3);
        assertFalse(5 < 3);
        assertNull(null);
        assertNotNull(new Object());
    }

    // Arrange-Act-Assert (AAA) Pattern
    @Test
    public void testStringLengthWithAAAPattern() {
        System.out.println("Running testStringLengthWithAAAPattern...");
        
        // Arrange
        String data = testString;
        
        // Act
        int length = data.length();
        
        // Assert
        assertEquals(16, length);
    }
}