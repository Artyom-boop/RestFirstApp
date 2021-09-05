package app.models;


import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    @NotEmpty(message = "Поле не может быть пустым")
    @Size(min = 2, max = 30, message = "Поле должно содержать от 2 до 30 символов")
    private String name;

    private int id;

    @Min(value = 0, message = "Возраст должен быть больше 0")
    private int age;

    @NotEmpty(message = "Поле не может быть пустым")
    @Email(message = "Неверный формат почты")
    private String email;

    public Person() {}

    public Person(String name, int id, String email, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
