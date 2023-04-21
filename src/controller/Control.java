
package controller;

//import static com.sun.corba.se.impl.util.Utility.printStackTrace;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.DOMException;



import fileManager.FileJason;
import fileManager.FileManager;
import fileManager.FileXml;
import fileManager.GenericDAO;
import fileManager.ReadInstitutions;
import general.HandlerLanguage;
import java.util.Calendar;
import java.util.List;
import models.HistoricalContribution;
import models.Specie;
import models.Institution;
import models.MainManager;
import models.KindBotanic;
import view.JDialogCreateBotanic;
import view.JDialogCreatePlant;
import view.JDialogDeleteBotanic;
import view.JFramePrincipal;
import viewMoblie.JFramePrincipalMobile;

public class Control implements ActionListener {
	private static final String NAME_FILE_CONFIG = "config.init";
	private JFramePrincipal jFramePrincipal;
	private JFramePrincipalMobile jFramePrincipalMobile;
	private MainManager mainmanager;
	private FileManager fileManger;
	private FileJason especieJSONDAO;
	private FileXml fileXml;
	private HandlerLanguage config = null;
	private String languageDefault;
	private JDialogCreateBotanic jDialogCreateBotanico;
	private JDialogCreatePlant jDialogCreatePlant;
	private JDialogDeleteBotanic jDialogDeleteBotanic;
	public ReadInstitutions readInstuti;

	public Control() {
		loadConfiguration();
		mainmanager = new MainManager();
		fileXml = new FileXml();
		especieJSONDAO = new FileJason();
		fileManger = new FileManager();
		jFramePrincipal = new JFramePrincipal(this);
		jFramePrincipalMobile = new JFramePrincipalMobile(this);
		jDialogCreateBotanico = new JDialogCreateBotanic(this);
		jDialogCreatePlant = new JDialogCreatePlant(this);
		jDialogDeleteBotanic = new JDialogDeleteBotanic(this);

		// notocar
		readAll();
		saveAll();
		fillTableEspecies(mainmanager.getManagerespecies().getListEspecies());
		// si alguno de estos 2 se borra todos los datos
		getLanguageDefault();
		readInstuti = new ReadInstitutions();
		jFramePrincipal.getjPanelPrincipalTable().getjPanelCenter().getjPanleFilterTable()
				.fillCBFamily(mainmanager.getManagerespecies().getFamilies());
		fillTableEspecies(mainmanager.getManagerespecies().getListEspecies());
		try {
			mainmanager.getManagerinstitucion().setListInstitucion(readInstuti.readInsti());
		} catch (IOException ex) {
			Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
		} catch (org.json.simple.DeserializationException ex) {
			Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
		}
		fillCardAportes();
		fillTableInstitucion(mainmanager.getManagerinstitucion().getListInstitucion());

	}

	public void fillCardAportes() {
		for (HistoricalContribution apor : mainmanager.getManagerAportesHistoricos().getListHistoricos()) {
			String instutution = "sin nombre";
			for (Institution inti : mainmanager.getManagerinstitucion().getListInstitucion()) {
				if (mainmanager.getManagerbotancos().findBotanicoById(apor.getIdUsuario()).getIdInstitucion() == inti
						.getIdInstitucion()) {
					instutution = inti.getNombreInstitucion();
				}
			}

			String nameEspecie = mainmanager.getManagerespecies().findById(apor.getIdEspecie()).getNombreCientifico();

			jFramePrincipal.getjPanelPrincipalCard().getjPanelCenter().getjPanelBorderContenedor()
					.getjPanelCenterContentCard().AddAporteCard(apor,
							mainmanager.getManagerbotancos().findBotanicoById(apor.getIdUsuario()),
							mainmanager.getManagerinstitucion().findInstitucionById(apor.getIdUsuario()), instutution,
							nameEspecie, this);
		}

	}

	public ArrayList<Specie> filterTableExport() {
		String country = jFramePrincipal.getjPanelPrincipalTable().getjPanelCenter().getjPanleFilterTable()
				.getCountrySelected();

		boolean isAptToCity = jFramePrincipal.getjPanelPrincipalTable().getjPanelCenter().getjPanleFilterTable()
				.getCityApt();
		String famaily = jFramePrincipal.getjPanelPrincipalTable().getjPanelCenter().getjPanleFilterTable()
				.GetFamilyCB();

		System.out.println("" + country);

		// fillTableEspecies(mainmanager.getManagerespecies().superSearch(country,
		// isAptToCity, famaily));
		// jFramePrincipal.getjPanelPrincipalTable().getjPanelCenter().getjPanleFilterTable().
		return mainmanager.getManagerespecies().superSearch(country, isAptToCity, famaily);
	}

	public ArrayList<Institution> filterTableInstitutionExport() {
		return mainmanager.getManagerinstitucion().getListInstitucion();
	}

	// este metodo llena la tabla y se puede usar para los reportes por pais familia
	// y otros

	public void fillTableInstitucion(ArrayList<Institution> listInsti) {
		jFramePrincipal.getjPanelPrincipalTableInstitucion().getjPanelCenter().getjPanelTableMostrar()
				.fillTableInstitucion(listInsti);
	}

	public void fillTableEspecies(ArrayList<Specie> listespe) {
		jFramePrincipal.getjPanelPrincipalTable().getjPanelCenter().getjPanelTableMostrar().fillTableEspecie(listespe);
	}

	public void saveAll() {
		fileManger.writeInstituciones(mainmanager.getManagerinstitucion().getListInstitucion());
		fileManger.writeEspecies(mainmanager.getManagerespecies().getListEspecies());
		fileManger.writeBotanicos(mainmanager.getManagerbotancos().getListbotanicos());
		fileManger.writeAportes(mainmanager.getManagerAportesHistoricos().getListHistoricos());
	}

	public void readAll() {
		try {
			mainmanager.getManagerespecies().setListEspecies(fileManger.readEspecies());

		} catch (Exception e) {
			System.out.println(e);
		}
		try {

			mainmanager.getManagerinstitucion().setListInstitucion(readInstuti.readInsti());
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			mainmanager.getManagerAportesHistoricos().setListHistoricos(fileManger.readAportes());
		} catch (Exception e) {
			System.out.println(e);
		}
		try {
			mainmanager.getManagerbotancos().setListbotanicos(fileManger.readBotanicos());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getLanguageDefault() {
		languageDefault = Locale.getDefault().getLanguage();
		switch (languageDefault) {
		case "es":
			return "Spanish";
		case "us":
			return "English";
		}
		return "Spanish";
	}

	public void loadLanguage() throws IOException {
		try {
			config.loadLanguage();
		} catch (Exception e) {
		}
	}

	public void saveConfig() throws IOException {
		try {
			new HandlerLanguage(NAME_FILE_CONFIG).saveLanguage();
		} catch (Exception e) {
		}
	}

	public void changeToEnglish() throws IOException {
		HandlerLanguage.language = "language/languageUS.properties";
		saveConfig();
		loadLanguage();
	}

	public void changeToSpanish() throws IOException {
		HandlerLanguage.language = "language/languageES.properties";
		saveConfig();
		loadLanguage();
	}

	public void loadConfiguration() {
		if (config == null) {
			config = new HandlerLanguage(NAME_FILE_CONFIG);
		}
		try {
			config.loadLanguage();
		} catch (IOException e) {
			System.err.println("file not found : NAME_FILE_CONFIG");
		}
	}

	private void manageChangeLanguageUS() {
		try {
			changeToEnglish();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		manageChangeLanguage();

	}

	private void manageChangeLanguageES() {
		try {
			changeToSpanish();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		manageChangeLanguage();

	}

	private void manageChangeLanguage() {
		jFramePrincipal.changeLanguage();
		jFramePrincipalMobile.changeLanguage();
		jDialogCreateBotanico.changeLanguage();
		jDialogDeleteBotanic.changeLanguage();
		jDialogCreatePlant.changeLanguage();
	}

	public void createAddBotanico(String nameBotanico, int idInstitucion, String mailBotanico, String password,
			KindBotanic tipobotanico) {
		mainmanager.getManagerbotancos().addBotanico(mainmanager.getManagerbotancos().createBotanico(nameBotanico,
				idInstitucion, mailBotanico, password, tipobotanico));
	}

	public void varifyLogIng(String mail, String Password) {
		if (mainmanager.getManagerbotancos().verificateLogIn(mail, Password) == true) {
			int idLog = mainmanager.getManagerbotancos().findBotanicoByMail(mail).getIdBotanico();

			mainmanager.getManagerbotancos().login(idLog);
		}
	}

	public void createUser() {
		if (mainmanager.getManagerbotancos()
				.verificateUnicMail(jDialogCreateBotanico.getCenterEmpleado().getCorreo()) == true) {
			if (mainmanager.getManagerbotancos()
					.verificateMailOk(jDialogCreateBotanico.getCenterEmpleado().getCorreo()) == true) {
				String name = jDialogCreateBotanico.getCenterEmpleado().getNameBotanic();
				String passWord = jDialogCreateBotanico.getCenterEmpleado().getPassword();
				String mail = jDialogCreateBotanico.getCenterEmpleado().getCorreo();
				KindBotanic tipo = jDialogCreateBotanico.getCenterEmpleado().getjCBCostsCategory();
				int idinsttitu = mainmanager.getManagerinstitucion()
						.findInstitutionByName(jDialogCreateBotanico.getCenterEmpleado().getInstitu())
						.getIdInstitucion();

				mainmanager.getManagerbotancos().addBotanico(
						mainmanager.getManagerbotancos().createBotanico(name, idinsttitu, mail, passWord, tipo));

				jDialogCreateBotanico.getCenterEmpleado()
						.fillCBintitu(mainmanager.getManagerinstitucion().getListInstitucion());
				saveAll();

			}
		}

		System.out.println("" + jDialogCreateBotanico.getCenterEmpleado().getNameBotanic());
	}

	public void createPlant() {

		if (mainmanager.getManagerbotancos().getLogedId() != 0) {
			String name = jDialogCreatePlant.getPlant().getName();
			String family = jDialogCreatePlant.getPlant().getfamily();
			List<String> country = jDialogCreatePlant.getPlant().getCountry();
			String reino = "Plantae";
			String note = jDialogCreatePlant.getPlant().getTextArea();
			Boolean Suitable = jDialogCreatePlant.getPlant().getSuitable();
			String textArea = jDialogCreatePlant.getPlant().getTextArea().toString();

			Specie newSpecie = mainmanager.getManagerespecies().createEspecie(name, family, name, reino, note, country, Suitable);
			mainmanager.getManagerespecies().addEspecie(newSpecie);
					
			fillTableEspecies(mainmanager.getManagerespecies().getListEspecies());
			mainmanager.getManagerAportesHistoricos().addAporte(mainmanager.getManagerAportesHistoricos().createAporte(newSpecie.getIdEspecie(), mainmanager.getManagerbotancos().getLogedId(), Calendar.getInstance(), textArea, null));
			saveAll();

			System.out.println("" + jDialogCreateBotanico.getCenterEmpleado().getNameBotanic());
			
		} else {
			JOptionPane.showInternalMessageDialog(null, "NO SE PUEDE REGISTRAR LA PLANTA SIN LOGEARSE PRIMERO");
		}
	}

	public void createPlantMobile() {

		String name = jFramePrincipalMobile.getcreatePlantMobile().getJPanelCenterAddPlant()
				.getJPanleFilterCreatePlantMobile().getName();
		String family = jFramePrincipalMobile.getcreatePlantMobile().getJPanelCenterAddPlant()
				.getJPanleFilterCreatePlantMobile().getfamily();
		List<String> country = jFramePrincipalMobile.getcreatePlantMobile().getJPanelCenterAddPlant()
				.getJPanleFilterCreatePlantMobile().getCountry();
		String reino = "Plantae";
		String note = jDialogCreatePlant.getPlant().getTextArea();
		Boolean Suitable = jFramePrincipalMobile.getcreatePlantMobile().getJPanelCenterAddPlant()
				.getJPanleFilterCreatePlantMobile().getSuitable();

		mainmanager.getManagerespecies().addEspecie(
				mainmanager.getManagerespecies().createEspecie(name, family, name, reino, note, country, Suitable));
		fillTableEspecies(mainmanager.getManagerespecies().getListEspecies());

		saveAll();

		System.out.println("" + jDialogCreateBotanico.getCenterEmpleado().getNameBotanic());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
		
                    case SHOW_STATIC_AVALIBLE:
                        jFramePrincipal.getjPanelPrincipalEstadisticas().
                                getjPanelCenter().getjPanelCenterContent().getjPanelWorkArea().
                                setListSongs(mainmanager.getManagerespecies().getAvalible());
                        
                    break;
                case SHOW_STATI_INSTI: 
                    jFramePrincipal.getjPanelPrincipalEstadisticas().
                                getjPanelCenter().getjPanelCenterContent().getjPanelWorkArea().
                                setListSongs(mainmanager.getManagerinstitucion().getTipesSpecies());

                    break;
                case SHOW_STAT_BY_FAMILY:
                    jFramePrincipal.getjPanelPrincipalEstadisticas().
                                getjPanelCenter().getjPanelCenterContent().getjPanelWorkArea().
                                setListSongs(mainmanager.getManagerespecies().getAllFamilies());

                    break;
                case SHOW_STAT_BY_YEAR:
                    jFramePrincipal.getjPanelPrincipalEstadisticas().
                                getjPanelCenter().getjPanelCenterContent().getjPanelWorkArea().
                                setListSongs(mainmanager.getManagerAportesHistoricos().getYears());
                    break;
            
		case SHOW_HOME:
			jFramePrincipal.showHome();
			break;
		case SHOW_ESTADISTIC:
			jFramePrincipal.showEstadisticas();
			break;
		case SHOW_PLANTLIBRARY:
			jFramePrincipal.showTable();
			break;
		case SHOW_HISTORICALCONTRIBUTIONS:
			jFramePrincipal.showContribution();
			break;
		case SHOW_TABLE_INSTITUCION:
			jFramePrincipal.showTableInstitucion();
			break;
		case SHOW_LOGIN:
			jFramePrincipal.showLogin();
			break;
		case LOG_IN:
			verificateLogin();
			break;
		case SHOW_MOBILE:
			jFramePrincipalMobile.setVisible(true);
			break;
		case SHOW_CREATEBOTANICO:
			jDialogCreateBotanico.getCenterEmpleado()
					.fillCBintitu(mainmanager.getManagerinstitucion().getListInstitucion());
			saveAll();
			jDialogCreateBotanico.setVisible(true);
			break;
		case SHOW_CREATE_PLANT:
			jDialogCreatePlant.setVisible(true);
			break;
		case SHOW_CHANGEPLANT:
			// jDialogChangePlant.setVisible(true);
			break;
		case SHOW_HOMEMOBILE:
			jFramePrincipalMobile.showHomeMobile();
			break;
		case CLOSE_MOBILE:
			jFramePrincipalMobile.setVisible(false);
			break;
		case ADDPLANTNEW:
			jDialogCreatePlant.setVisible(false);
			createPlant();
			manageChangeLanguageES();
			break;
		case CREATE_PLANT_MOBILE:
			createPlantMobile();
			break;
		case DELETE_BOTANIC:
			jDialogDeleteBotanic.setVisible(true);
			break;
		case SHOW_INFOPLANT_MONILE:
			jFramePrincipalMobile.showInfoPlant();
			break;
		case DELETE_BOTANIC_BUTONPRINCIPAL:
			verificateLoginforDelete();
			break;
		case SHOW_ADDPLANT:
			jFramePrincipalMobile.showJPanelAddPlant();
			break;
		case SHOW_USER_MOBILE:
			jFramePrincipalMobile.showUser();
			break;
		case SHOW_CONFI_MOBILE:
			jFramePrincipalMobile.showConfi();
			break;
		case SHOW_INFO_MOBILE:
			jFramePrincipalMobile.showInfo();
			break;
		case SHOWMULTI:
			jFramePrincipalMobile.showMultitarea();
			break;
		case SHOW_TABLEPLANT:
			jFramePrincipal.showPlantTable(
					mainmanager.getManagerespecies().findById(Integer.valueOf(((JButton) (e.getSource())).getName())));

			break;
		case FIND_COUNTRY:
			fillTableEspecies(findCountry());
			break;
		case FIND_SUITABLE:
			fillTableEspecies(findSuitable());
			break;
		case FIND_BY_FAMILY:
			fillTableEspecies(findByFamily());
			break;
		case ADD_COUNTRY:
			jDialogCreatePlant.getPlant().addCountryVerificated();
			break;
		case ADD_COUNTRY_MOBILE:
			jFramePrincipalMobile.getcreatePlantMobile().getJPanelCenterAddPlant().getJPanleFilterCreatePlantMobile()
					.addCountryVerificated();
			break;
		case SEARCHBY_WORD:
			fillTableEspecies(mainmanager.getManagerespecies().findByWord(
					jFramePrincipal.getjPanelPrincipalTable().getjPanelCenter().getjPanleFilterTable().getWord()));
			break;
		case SAVE_BOTANIC:
			createUser();
			saveAll();
			jDialogCreateBotanico.setVisible(false);
			break;
		case SAVEXML:
			try {
				exportFileJsonXML();
			} catch (DOMException | TransformerFactoryConfigurationError | ParserConfigurationException
					| TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case SAVEXMLINSTITUTION:
			try {
				exportFileJsonXMLInstitution();
			} catch (DOMException | TransformerFactoryConfigurationError | ParserConfigurationException
					| TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case SAVE_JSON:
			exportFileJson();
			break;
		case SAVE_JSON_INSTITUTION:
			exportFileJsonInstitution();
			break;
		case C_ENGLISH:
			manageChangeLanguageUS();
			break;
		case C_SPANISH:
			manageChangeLanguageES();
		default:
			break;

		}
	}

	public ArrayList<Specie> findCountry() {
		String country = jFramePrincipal.getjPanelPrincipalTable().getjPanelCenter().getjPanleFilterTable()
				.getCountrySelected();

		return mainmanager.getManagerespecies().filterCountry(country);
	}

	public ArrayList<Specie> findSuitable() {
		boolean suitable = jFramePrincipal.getjPanelPrincipalTable().getjPanelCenter().getjPanleFilterTable()
				.getCityApt();

		return mainmanager.getManagerespecies().filterSuitable(suitable);
	}

	public ArrayList<Specie> findByFamily() {
		String family = jFramePrincipal.getjPanelPrincipalTable().getjPanelCenter().getjPanleFilterTable()
				.GetFamilyCB();

		return mainmanager.getManagerespecies().filterByFamily(family);
	}

	public ArrayList<Specie> findByWord() {
		// fillTableEspecies(mainmanager.getManagerespecies().findByWord(
		// jFramePrincipal.getjPanelPrincipalTable().getjPanelCenter().getjPanleFilterTable().getWord()));

		String word = jFramePrincipal.getjPanelPrincipalTable().getjPanelCenter().getjPanleFilterTable().getName();

		return mainmanager.getManagerespecies().findByWord(word);
	}

	private void verificateLogin() {

		String mail = jFramePrincipal.getjPanelPrincipalLogin().getjTextFieldName();
		String password = jFramePrincipal.getjPanelPrincipalLogin().getJpassword();
		if (mainmanager.getManagerbotancos().verificateLogIn(mail, password) == true) {

			try {
				mainmanager.getManagerbotancos()
						.login(mainmanager.getManagerbotancos().findBotanicoByMail(mail).getIdBotanico());
				jFramePrincipal.showTable();
				JOptionPane.showMessageDialog(null, "se ha logeado con exito");

			} catch (Exception e) {

			}

		} else {
			JOptionPane.showMessageDialog(null, "Contrasenia incorrecta");
		}

	}

	private void verificateLoginforDelete() {

		String mail = jDialogDeleteBotanic.getdeleteBotanic().getCorreo();
		String password = jDialogDeleteBotanic.getdeleteBotanic().getPassword();

		if (mainmanager.getManagerbotancos().verificateLogIn(mail, password) == true) {

			try {

				mainmanager.getManagerbotancos().findBotanicoByMail(mail).setActive(false);
				saveAll();
				JOptionPane.showMessageDialog(null, "se ha eliminado con exito");

			} catch (Exception e) {

			}

		} else {
			JOptionPane.showMessageDialog(null, "Contrase�a incorrecta o usuario eliminado");
		}

	}

	private void exportFileJson() {
		JFileChooser ventanaG = new JFileChooser();
		ventanaG.showSaveDialog(null);
		if (ventanaG.getSelectedFile() != null) {
			especieJSONDAO.escribir(filterTableExport(), ventanaG.getSelectedFile() + ".json");
		}

	}

	private void exportFileJsonInstitution() {
		JFileChooser ventanaG = new JFileChooser();
		ventanaG.showSaveDialog(null);
		if (ventanaG.getSelectedFile() != null) {
			especieJSONDAO.escribirJsonInstitution(filterTableInstitutionExport(),
					ventanaG.getSelectedFile() + ".json");
		}

	}

	private void exportFileJsonXML() throws DOMException, TransformerFactoryConfigurationError,
			ParserConfigurationException, TransformerException {
		JFileChooser ventanaG = new JFileChooser();
		ventanaG.showSaveDialog(null);
		if (ventanaG.getSelectedFile() != null) {
			fileXml.escribirXML(filterTableExport(), ventanaG.getSelectedFile() + ".xml");

		}

	}

	private void exportFileJsonXMLInstitution() throws DOMException, TransformerFactoryConfigurationError,
			ParserConfigurationException, TransformerException {
		JFileChooser ventanaG = new JFileChooser();
		ventanaG.showSaveDialog(null);
		if (ventanaG.getSelectedFile() != null) {
			fileXml.escribirXMLInstitution(filterTableInstitutionExport(), ventanaG.getSelectedFile() + ".xml");

		}

	}

}
