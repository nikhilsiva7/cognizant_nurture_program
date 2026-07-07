import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class MyServiceTest {

    @Test
    public void testMockingAndStubbing() {
        // Create a mock object for the external API
        ExternalApi mockApi = mock(ExternalApi.class);
        
        // Stub the methods to return predefined values
        when(mockApi.getData()).thenReturn("Mock Data");
        
        // Write a test case that uses the mock object
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        
        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyingInteractions() {
        // Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        
        // Call the method
        service.processAndSend("Hello World");
        
        // Ensure that a method is called with specific arguments
        verify(mockApi, times(1)).sendData("Hello World");
    }
}