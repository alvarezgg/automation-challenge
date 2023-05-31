package scripts;

import static org.testng.Assert.assertTrue;

import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.Config;
import utils.Logger;
import utils.WebServiceHelper;

public class WebServiceTest extends BaseTest{
	
	@BeforeMethod
	public void setUp() {
		this.config = Config.getBaseConfig();
	}
	
	@Test
	@Parameters({"baseUrl","endpoint","nodoBuscado"})
	public void pruebaWebService_3_1(String baseUrl,String endpoint,String nodoBuscado){
		WebServiceHelper webServiceHelper = new WebServiceHelper();
		
		JSONObject response = webServiceHelper.doGetRequest(baseUrl, endpoint);
		
		Logger.log(response.toString());
		
		assertTrue(response.has("departments"), "La respuesta JSON no contiene " + nodoBuscado);
	}
}
