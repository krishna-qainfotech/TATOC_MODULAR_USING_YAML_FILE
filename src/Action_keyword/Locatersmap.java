package Action_keyword;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.ho.yaml.Yaml;





public class Locatersmap {
	HashMap<String, String> nameToTypeMap;
	HashMap<String, String> nameToValueMap;
	
	@SuppressWarnings("unchecked")
	public Locatersmap() throws FileNotFoundException {
	    String filePath1 = "/home/qainfotech/Music/eclipse-workspace/TATOC_MODULAR_APPROACH/src/Locator/NAME_ID.yaml";
	    String filePath2 = "/home/qainfotech/Music/eclipse-workspace/TATOC_MODULAR_APPROACH/src/Locator/NAME_VAULE.yaml";
	    
	    nameToTypeMap = (HashMap<String, String>)Yaml.load(new FileInputStream(filePath1));
	    nameToValueMap =(HashMap<String, String>)Yaml.load(new FileInputStream(filePath2));
	}
	
	public String getLocatorType(String LocatorName) {
		return nameToTypeMap.get(LocatorName);
		
	}
	
	public String getLocatorValue(String LocatorName) {
		return nameToValueMap.get(LocatorName);
	}

}
