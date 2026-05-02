package com.klef.fsad.exam;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "hospital_table")
public class Hospital
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hospital_name", nullable = false)
    private String name;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String status;

    // Default Constructor (MANDATORY)
    public Hospital() {}

    // Parameterized Constructor
    public Hospital(String name, String description, Date date, String status)
    {
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}