
import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axiom.soap.SOAPHeaderBlock;

public class SecurityHeader {

	public SOAPHeaderBlock addSecurityHeader(String consumerUname, String consumerPwd) {
		SOAPFactory fac = OMAbstractFactory.getSOAP11Factory();
		OMNamespace headerNs = fac.createOMNamespace(
				"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "o");
		SOAPHeaderBlock soapheader = fac.createSOAPHeaderBlock("Security", headerNs);

		final OMFactory omFactory = OMAbstractFactory.getOMFactory();
		OMElement omusertokenNode = omFactory.createOMElement(new QName("o:UsernameToken"));

		// Set the username.
		final OMNode userNameNode = omFactory.createOMElement(new QName("o:Username"));
		((OMElement) userNameNode).setText(consumerUname);
		omusertokenNode.addChild(userNameNode);

		// Set the password.
		final OMNode passwordNode = omFactory.createOMElement(new QName("o:Password"));
		((OMElement) passwordNode).setText(consumerPwd);
		omusertokenNode.addChild(passwordNode);
		soapheader.addChild(omusertokenNode);

		return soapheader;
	}

}
