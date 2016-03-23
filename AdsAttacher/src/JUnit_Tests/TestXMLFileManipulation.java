package JUnit_Tests;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import model.UpdaterObject;
import model.XMLFileManipulation;

public class TestXMLFileManipulation {
	@Test
	public void test(){
		//Test for xml file manipulation
		XMLFileManipulation xmlFM = new XMLFileManipulation(new File("").getAbsolutePath()+"/updater.xml");
		UpdaterObject updateObject = new UpdaterObject();
		try {
			updateObject = (UpdaterObject)xmlFM.Read(new UpdaterObject().getClass());
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(updateObject.getCurrentVersion(0)+"I did this shit");
	}
}
