public class Students {
    private String name;
    private String surname;
    private int phone;
    private int group;

    public Students(String name, String surname, int phone, int group) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.group = group;
    }

    @Override
    public String toString() {
        return name + " " + surname + " тел.: " + phone + " Группа: " + group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
