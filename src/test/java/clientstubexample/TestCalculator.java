package clientstubexample;

import java.rmi.RemoteException;

import org.tempuri.AddDocument;
import org.tempuri.AddResponseDocument;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import calculator.CalculatorStub;

public class TestCalculator {

	private CalculatorStub calculatorServiceStub;

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
		calculatorServiceStub = new CalculatorStub("http://www.dneonline.com/calculator.asmx?wsdl");

		// SecurityHeader sc = new SecurityHeader();
		// SOAPHeaderBlock soapheader = sc.addSecurityHeader("DummyUname", "DummyPwd");
		// calculatorServiceStub._getServiceClient().addHeader(soapheader);

	}

	@Test
	public void addTest() throws org.apache.axis2.AxisFault, RemoteException {

		AddDocument additionExample = AddDocument.Factory.newInstance();
		additionExample.addNewAdd().setIntA(10);
		additionExample.getAdd().setIntB(6);

		AddResponseDocument addResponse = calculatorServiceStub.add(additionExample);

		Assert.assertTrue(addResponse.getAddResponse().getAddResult() > 0,
				"The addition of two positive numbers is not greater than zero");

	}

}
