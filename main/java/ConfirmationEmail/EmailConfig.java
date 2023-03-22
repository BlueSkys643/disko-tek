package ConfirmationEmail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmailConfig {

    @SerializedName("mailHost")
    @Expose
    private String mailHost;
    @SerializedName("mailPort")
    @Expose
    private String mailPort;
    @SerializedName("encryptionType")
    @Expose
    private String encryptionType;
    @SerializedName("doAuth")
    @Expose
    private Boolean doAuth;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("password")
    @Expose
    private String password;

    /**
     * No args constructor for use in serialization
     *
     */
    public EmailConfig() {
    }

    /**
     *
     * @param mailHost Email host
     * @param mailPort Port for Email host
     * @param userName Username for e-mail host
     * @param password Password for e-mail host
     * @param doAuth Do I need to authenticate or not
     * @param encryptionType SSL, TLS, or startTLS
     */
    public EmailConfig(String mailHost, String mailPort, String encryptionType, Boolean doAuth, String userName, String password) {
        super();
        this.mailHost = mailHost;
        this.mailPort = mailPort;
        this.encryptionType = encryptionType;
        this.doAuth = doAuth;
        this.userName = userName;
        this.password = password;
    }

    public String getMailHost() {
        return mailHost;
    }

    public void setMailHost(String mailHost) {
        this.mailHost = mailHost;
    }

    public String getMailPort() {
        return mailPort;
    }

    public void setMailPort(String mailPort) {
        this.mailPort = mailPort;
    }

    public String getEncryptionType() {
        return encryptionType;
    }

    public void setEncryptionType(String encryptionType) {
        this.encryptionType = encryptionType;
    }

    public Boolean getDoAuth() {
        return doAuth;
    }

    public void setDoAuth(Boolean doAuth) {
        this.doAuth = doAuth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(EmailConfig.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("mailHost");
        sb.append('=');
        sb.append(((this.mailHost == null)?"<null>":this.mailHost));
        sb.append(',');
        sb.append("mailPort");
        sb.append('=');
        sb.append(((this.mailPort == null)?"<null>":this.mailPort));
        sb.append(',');
        sb.append("encryptionType");
        sb.append('=');
        sb.append(((this.encryptionType == null)?"<null>":this.encryptionType));
        sb.append(',');
        sb.append("doAuth");
        sb.append('=');
        sb.append(((this.doAuth == null)?"<null>":this.doAuth));
        sb.append(',');
        sb.append("userName");
        sb.append('=');
        sb.append(((this.userName == null)?"<null>":this.userName));
        sb.append(',');
        sb.append("password");
        sb.append('=');
        sb.append(((this.password == null)?"<null>":this.password));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}