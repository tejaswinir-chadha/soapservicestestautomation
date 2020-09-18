package clientstubexample;

import java.rmi.RemoteException;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.example.AddDocument;
import com.example.AddResponseDocument;

import calculator.CalculatorServiceStub;

public class TestCalculator {

	private CalculatorServiceStub calculatorServiceStub;

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
		calculatorServiceStub = new CalculatorServiceStub();

	}

	@Test
	public void addTest() throws org.apache.axis2.AxisFault, RemoteException {

		AddDocument additionExample = AddDocument.Factory.newInstance();
		additionExample.addNewAdd();
		additionExample.getAdd().setIntA(3);
		additionExample.getAdd().setIntB(6);
		AddResponseDocument addResponse = calculatorServiceStub.add(additionExample);

		Assert.assertTrue(addResponse.getAddResponse().getValue() > 0,
				"The addition of tow numbers is not greater than zero");

	}

}
