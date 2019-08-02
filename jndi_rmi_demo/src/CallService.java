import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

public class CallService {
    public static void main(String[] args) throws Exception{
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
        env.put(Context.PROVIDER_URL, "rmi://localhost:1099");

        Context ctx = new InitialContext(env);

        // 创建一个rmi映射表
        Registry registry = LocateRegistry.createRegistry(1099);
        IHello hello = new IHelloImpl();
        registry.bind("hello", hello);

        IHello rhello = (IHello) ctx.lookup("hello");
        System.out.println(rhello.sayHello("HE jixin"));
    }
}
