
package models;


public class Botanic {
    
    private int idBotanico, idInstitucion;
    private static int idHistBot;
    private String nameBotanico, mailBotanico, password;
    private KindBotanic tipobotanico;
    private Boolean active;

    public Botanic( String nameBotanico,int idInstitucion, String mailBotanico, String password, KindBotanic tipobotanico) {
        
        idHistBot++;
        idBotanico = idHistBot;
        this.idInstitucion = idInstitucion;
        this.nameBotanico = nameBotanico;
        this.mailBotanico = mailBotanico;
        this.password = password;
        this.tipobotanico = tipobotanico;
        this.active = true;
    }
    
    public int getIdBotanico() {
        return idBotanico;
    }

    public void setIdBotanico(int idBotanico) {
        this.idBotanico = idBotanico;
    }

    
    
    public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getNameBotanico() {
        return nameBotanico;
    }

    public String getMailBotanico() {
        return mailBotanico;
    }

    public String getPassword() {
        return password;
    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public KindBotanic getTipobotanico() {
        return tipobotanico;
    }
}
