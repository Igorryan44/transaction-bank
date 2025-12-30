package com.igor_dev.transaction_bank.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    private Long balance;

    public User() {
    }

    public User(Long id, String username, String email, String cpf, String password, Long balance) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.cpf = cpf;
        this.password = password;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public Long getBalance() {
        return balance;
    }

    public String getCpf() {
        return cpf;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
