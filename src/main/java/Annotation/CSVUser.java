package Annotation;


import com.opencsv.bean.CsvBindByName;

public class CSVUser {

    @CsvBindByName(column = "name", required = true)
    private String name;

    @CsvBindByName(column = "email", required = true)
    private String email;

    @CsvBindByName(column = "phone")
    private String phone;

    @CsvBindByName(column = "country")
    private String country;

    public CSVUser() {
    }

    public CSVUser(String name, String email, String phone, String country) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "CSVUser{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
