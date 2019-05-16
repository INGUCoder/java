package com.baidu.bean;

public class MailInfo {
    private Integer id;

    private Integer enterpriseId;

    private String mailerTelephone;

    private String mailerName;

    private String mailTime;

    private String mailNumber;
    
    private Integer num;
    
    private EnterpriseInfo enterpriseInfo=new EnterpriseInfo();
    
    
    public EnterpriseInfo getEnterpriseInfo() {
		return enterpriseInfo;
	}

	public void setEnterpriseInfo(EnterpriseInfo enterpriseInfo) {
		this.enterpriseInfo = enterpriseInfo;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public MailInfo() {
		super();
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getMailerTelephone() {
        return mailerTelephone;
    }

    public void setMailerTelephone(String mailerTelephone) {
        this.mailerTelephone = mailerTelephone == null ? null : mailerTelephone.trim();
    }

    public String getMailerName() {
        return mailerName;
    }

    public void setMailerName(String mailerName) {
        this.mailerName = mailerName == null ? null : mailerName.trim();
    }

    public String getMailTime() {
        return mailTime;
    }

    public void setMailTime(String mailTime) {
        this.mailTime = mailTime == null ? null : mailTime.trim();
    }

	public MailInfo(Integer id, Integer enterpriseId, String mailerTelephone,
			String mailerName, String mailTime, String mailNumber) {
		super();
		this.id = id;
		this.enterpriseId = enterpriseId;
		this.mailerTelephone = mailerTelephone;
		this.mailerName = mailerName;
		this.mailTime = mailTime;
		this.mailNumber = mailNumber;
	}

	public String getMailNumber() {
		return mailNumber;
	}

	public void setMailNumber(String mailNumber) {
		this.mailNumber = mailNumber;
	}

	@Override
	public String toString() {
		return "MailInfo [id=" + id + ", enterpriseId=" + enterpriseId
				+ ", mailerTelephone=" + mailerTelephone + ", mailerName="
				+ mailerName + ", mailTime=" + mailTime + ", mailNumber="
				+ mailNumber + "]";
	}
    
    
}