package model;

public abstract class Account implements Comparable<Account>{
    private String idCard;
    private String fullName;
    private String birthday;
    private int gender;
    private boolean status = false;

    public Account() {
    }

    public Account(String idCard, String fullName, String birthday, int gender, boolean status) {
        this.idCard = idCard;
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.status = status;
    }

    public Account(String string) {
        String[] data = string.split(",");
        setIdCard(data[0]);
        setFullName(data[1]);
        setBirthday((data[2]));
        setGender(Integer.parseInt(data[3]));
//        setStatus(data[4]);
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public abstract String getInfo();

    public String getDataWriteFile() {
        return getIdCard() + "," + getFullName() + "," + getBirthday() + "," + getGender() + "," + isStatus();
    }

    @Override
    public String toString() {
        return "idCard='" + idCard + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender=" + gender +
                ", status=" + status;
    }

    @Override
    public int compareTo(Account account) {
        if (this.fullName.equals(account.fullName)) {
            return -this.birthday.compareTo(account.birthday);
        }
        return this.fullName.compareTo(account.fullName);
    }
}
