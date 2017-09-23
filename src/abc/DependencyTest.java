package abc;

import org.testng.annotations.Test;

import junit.framework.Assert;
//Got
public class DependencyTest {
	@Test
	public void meth1()
	{
		System.out.println("meth1");
		
	}
	@Test(dependsOnMethods="meth1")
	public void meth2()
	{
		System.out.println("meth2");
	}

}
