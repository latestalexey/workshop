package task0;

import org.junit.Test;
import task0.java.SimpleClient;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class testTask0<C> {
    private static Class<SimpleClient> getClientClass() {
        return SimpleClient.class;
    }

    private static SimpleClient createClient(String email, boolean isInterestedInSpam) throws Exception {
        Class<SimpleClient> clientClass = getClientClass();
        Constructor<?>[] constructors = clientClass.getConstructors();
        assert constructors.length == 1;
        Constructor<?> constructor = constructors[0];
        Object bob = constructor.newInstance(email, isInterestedInSpam);
        return (SimpleClient)bob;
    }

    @Test
    public void clientCreation() throws Exception {
        createClient("bob@gmail.com", true);
    }

    public void testGetter(String methodName, Object expectedValue) throws Exception {
        SimpleClient client = createClient("bob@gmail.com", true);
        Class<SimpleClient> clientClass = getClientClass();
        Method getEmailMethod = clientClass.getDeclaredMethod(methodName);
        Object result = getEmailMethod.invoke(client);
        assertEquals("Method 'getEmail' should be available in SimpleClient", expectedValue, result);
    }

    @Test
    public void getEmail() throws Exception {
        testGetter("getEmail", "bob@gmail.com");
    }

    @Test
    public void getIsInterestedInSpam() throws Exception {
        try {
            testGetter("isInterestedInSpam", true);
        }
        catch (NoSuchMethodException e) {
            testGetter("getIsInterestedInSpam", true);
        }
    }

    @Test
    public void hasEquals() throws Exception {
        SimpleClient bob1 = createClient("bob@gmail.com", true);
        SimpleClient bob2 = createClient("bob@gmail.com", true);
        assertEquals("Two instances with the same properties should be equal", bob1, bob2);
    }

    @Test
    public void hasToString() throws Exception {
        SimpleClient client = createClient("bob@gmail.com", true);
        try {
            assertEquals("Method 'toString' should be overridden", "SimpleClient(email=bob@gmail.com, isInterestedInSpam=true)", client.toString());
        } catch (AssertionError e) {
            assertEquals("Method 'toString' should be overridden", "SimpleClient{email='bob@gmail.com', isInterestedInSpam=true}", client.toString());
        }
    }
}
