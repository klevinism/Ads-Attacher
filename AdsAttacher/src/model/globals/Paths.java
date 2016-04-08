package model.globals;

import java.io.File;

public class Paths extends Globals {

	/*
	 * Local global paths
	 */
	public static String RootFolder = new File("").getAbsolutePath();
	public static String UpdaterXmlLocalFile = RootFolder + "/documents/updater.xml";
	public static String SettingsXmlLocalFile = RootFolder + "/documents/settings.xml";
	
	public static String ResourcesLocalFolder = "/resources/";
	public static String ImageLocalFolder = "/resources/images/";
	/*
	 * Remote global paths
	 */
	public static String RemoteBaseUrl = "http://delimeta.info";
	public static String RemoteUpdaterUrl = RemoteBaseUrl + "/updater/updater_AdsAttacher";
	public static String RemoteUpdaterFileUrl = RemoteUpdaterUrl + "/updater.xml";
}
