package testngPackage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenersDemo.class)
public class DemoClass3 {

	@Test
	public void m1() {
		System.out.println("Done");
	}

	@Test
	public void m2() {
		Assert.assertFalse(true);
		System.out.println("Done");
	}

	@Test(timeOut = 500)
	public void m3() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("Done");
	}

	@Test(dependsOnMethods = { "m2" })
	public void m4() {
		System.out.println("Done");
	}

}
