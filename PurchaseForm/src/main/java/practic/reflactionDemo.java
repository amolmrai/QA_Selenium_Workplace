package practic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

import org.testng.annotations.Test;


public class reflactionDemo {
	foo f  ;
	@Test
	public void runReflaction() throws Exception {
		//f= new foo();
		Method method;
		//Object obj = Class.forName("practic.foo").newInstance();
		Class<?> obj=Class.forName("practic.foo");
		Method[] allMethods = obj.getDeclaredMethods();
		for (Method m : allMethods) {
		    String mname = m.getName();
		    if (mname.startsWith("test") ) {
		    	  method = obj.getDeclaredMethod("methodTwo");
		    	  method.invoke(obj.newInstance());
		    }
		}
		    
		//Method method=obj.getMethod("doubleIt",java.lang.Integer.class);
		  

	
	}


}
