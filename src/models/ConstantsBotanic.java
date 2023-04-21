
package models;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.scene.layout.Background;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class ConstantsBotanic {

	public static final String BLUE_STEAM = "#1b2c3e";
	public static final String BLUE_STEAM_MID = "#123249";
	public static final String GREEN_GREED = "#769505";
	public static final String MAIN_COLOR_LIGTH = "#b5d3f3";
	public static final String MAIN_COLOR_STRONG = "#557096";
	public static final String COLOR_START = "#f4b80f";
	public static final String URL_JSON_USERS = "./data/userjs.json";
	public static final String ULR_PHOTO_USER_STANDAR = "/images/if_user_309035.png";

	public static final Font linkButons = new Font("", Font.BOLD, 20);
	public static final Font titleBig = new Font("", Font.BOLD, 25);
	public static final Font BIG_TITLE = new Font("Times New Roman", Font.BOLD, 30);
	public static final SimpleDateFormat FORMATE_DATE = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
	public static final SimpleDateFormat FORMATE_DATE_STANDAR = new SimpleDateFormat("yyyy/MM/dd");
	public static final SimpleDateFormat FORMATE_CALENDAR_STRING = new SimpleDateFormat("E MMM d HH:mm:ss z uuuu");
	public static final MatteBorder SEPARATOR_BORDER = BorderFactory.createMatteBorder(14, 0, 5, 0, Color.WHITE);
	public static final MatteBorder LINE_BORDER_TOP = BorderFactory.createMatteBorder(1, 0, 0, 0, Color.GRAY);
	public static final MatteBorder STANDAR_BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE);

	public static final javax.swing.border.Border SPACEBUTTON = BorderFactory.createLineBorder(Color.decode(BLUE_STEAM),
			10);
	public static final javax.swing.border.Border SPACEMIDButton = BorderFactory
			.createLineBorder(Color.decode(BLUE_STEAM), 5);
	public static final javax.swing.border.Border BORDER_LOG_BOX = BorderFactory.createLineBorder(Color.BLACK, 1);

	public static final MatteBorder TOP_BUTTON_BORDER = BorderFactory.createMatteBorder(10, 5, 10, 5, Color.WHITE);
	public static final MatteBorder TOP_BUTTON_SELECTED = BorderFactory.createMatteBorder(10, 5, 10, 5, Color.WHITE);
	public static final MatteBorder TEN_TEN_BORDER = BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE);
	public static final MatteBorder LEFT_BORDER = BorderFactory.createMatteBorder(0, 10, 0, 0, Color.WHITE);
	public static final MatteBorder DOWN_BORDER_DARK = BorderFactory.createMatteBorder(0, 0, 10, 0, Color.WHITE);

	public static final String T_ENGLISH = "T_ENGLISH";
	public static final String T_SPANISH = "T_SPANISH";
	public static final String T_MENU_Home = "T_MENU_Home";
	public static final String T_MENU_Plantlibrary = "T_MENU_Plantlibrary";
	public static final String T_MENU_HistoricalContributions = "T_MENU_HistoricalContributions";
	public static final String T_MENU_STATISTICS = "T_MENU_STATISTICS";
	public static final String T_MENU_MORE = "T_MENU_MORE";

	public static final String TABLE_IDPLANT = "TABLE_IDPLANT";
	public static final String TABLE_FAMILYPLANT = "TABLE_FAMILYPLANT";
	public static final String TABLE_NAMEPLANT = "TABLE_NAMEPLANT";
	public static final String TABLE_COUNTRYPLANT = "TABLE_COUNTRYPLANT";
	public static final String TABLE_SUITABLEPLANT = "TABLE_SUITABLEPLANT";
	public static final String TABLE_INSTITUTION = "TABLE_INSTITUTION";
	public static final String DELETE_BOTANIC = "DELETE_BOTANIC";
	public static final String CREATE_BOTANIC = "CREATE_BOTANIC";

	public static final String NAME_BOTANIC = "NAME_BOTANIC";
	public static final String EMAIL = "EMAIL";
	public static final String PASSWORD = "PASSWORD";
	public static final String KIND_BOTANIC = "KIND_BOTANIC";
	public static final String INSTITUTION = "INSTITUTION";
	public static final String CREATE = "CREATE";
	
	public static final String REGISTER_PLANT = "REGISTER_PLANT";
	public static final String SEARCH_PLANT = "SEARCH_PLANT";
	public static final String ACCOUNT = "ACCOUNT";
	public static final String CONFIGURATION = "CONFIGURATION";

                public static final String AVALIBLE = "AVALIBLE";
        public static final String NOT_AVALIBLE = "NOT_AVALIBLE";






	public static final String ACCION_GUARDARXML = "GUARDARXML";
	public static final String ACCION_GUARDARJSON = "GUARDARJSON";
	public static final String ACCION_GUARDARBIN = "GUARDARBIN";
	public static final String ACCION_GUARDARCSV = "GUARDARCSV";
	
	public static final String EXPORTJSON = "EXPORTJSON";
	public static final String ADDPLANT = "ADDPLANT";
	public static final String CHANGEDPALNT = "CHANGEDPALNT";

	public static final String DATA = "DATA";
	public static final String INFORMATION = "INFORMATION";
    public static final MatteBorder RIGTH_BORDER = BorderFactory.createMatteBorder(0, 0, 0, 2, Color.GRAY);
	public static void launchwarnigMessage() {
		JOptionPane.showMessageDialog(null, "user not foud" + "\n" + "verificate user and password");
	}

	public static void launchUserInUser() {
		JOptionPane.showMessageDialog(null, "dataos de ususario invalidos" + "\n" + "intente de nuevo");
	}

	public static void launchwarnigNotFoundGame() {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
																		// Tools | Templates.
	}
	
	
    public static String formateDate(Calendar cal){
        
        String strdate = null;

            if (cal != null) {
            strdate = ConstantsBotanic.FORMATE_DATE_STANDAR.format(cal.getTime());
            }
        
        return strdate;
    }

	private String getMonthFromated(int month) {
		String formatedMonth = "";

		if ((month + 1) < 9) {
			formatedMonth = "0" + (month + 1);
		} else {
			formatedMonth = (month + 1) + "";
		}
		return formatedMonth;
	}

}
