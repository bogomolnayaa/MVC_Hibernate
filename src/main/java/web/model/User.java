package web.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Имя не может быть пустым")
    @Pattern(regexp="^[а-яА-Яa-zA-Z]+$", message = "Используйте только русские или латинские буквы")
    @Size(min = 2, max = 30, message = "Количество символов должно быть от 2 до 30")
    private String name;

    @Column(name = "lastname")
    @NotEmpty(message = "Фамилия не может быть пустой")
    @Pattern(regexp="^[а-яА-Яa-zA-Z]+$", message = "Используйте только русские или латинские буквы")
    @Size(min = 2, max = 30, message = "Количество символов должно быть от 2 до 30")
    private String lastname;

    @Column(name = "age")
    @NotNull(message = "Вы не указали возраст")
    @Min(value = 0, message = "Возраст должен быть положительным числом")
    private int age;

    @Column(name = "email")
    @NotEmpty(message = "Вы не указали email")
    @Email(message = "Некорректное значение email")
    private String email;


    public User() {

    }

    public User(int id, String name, String lastname, int age, String email, String password, String roles) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name) && Objects.equals(lastname, user.lastname) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, age, email);
    }
}


