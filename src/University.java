import java.util.ArrayList;

public class University {
    private ArrayList<Students> list = new ArrayList<>();

    public String addStudent(String name, String surname, int phone, int group) {
        Students st = new Students(name, surname, phone, group);
        list.add(st);
        return "Студент добавлен";
    }

    public String delStudent(String name, String surname, int phone) {
        boolean result = false;
        for (Students st : list) {
            if (st.getName().equals(name) && st.getSurname().equals(surname) && st.getPhone() == phone) {
                list.remove(st);
                result = true;
                break;
            }
        }
        if (result) {
            return "Студент отчислен";
        } else return "Такой студент не найден";
    }

    public String getList(int group) {
        String res = "Студенты группы " + group + "\n";
        for (Students st : list) {
            if (st.getGroup() == group) {
                res += st.getName() + st.getSurname() + st.getPhone() + "\n";
            }
        }
        return res;
    }
}

