# SOAP Services Test Automation

**Automation frame work using stubs to test SOAP services**


This framework allows you to build over to test your soap services independent of any tool and have it integrated as a part of continous testing
This framework uses wsdl2code Mojo for generating Java sources from a WSDL. 
Ref : https://axis.apache.org/axis2/java/core/tools/maven-plugins/axis2-wsdl2code-maven-plugin/wsdl2code-mojo.html 
We can use Axis2 to generate the Java class (stub) from the WSDL file which we can use as a client to generate the web service request, to send the request to the service end point and to process the response.

## Getting Started

1) Download the **soapservicestestautomation** maven project 
2) mvn install
3) This would generate the soaptestautomationjavaexample-0.0.1-sources.jar && soaptestautomationjavaexample-0.0.1.jar
4) Add this to your class path and you are ready to go


## Customizing the framework as per your wsdl
1) update the pom.xml wsdlFile with your wsdl under test
2) Customize SecurityHeader.java as per your service's soap header requirments



## Author

* **Tejaswini R** 
<a href="https://www.linkedin.com/in/tejaswinirajashekarappa/"> <img src="https://img.shields.io/badge/linkedin-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white" />  </a>
