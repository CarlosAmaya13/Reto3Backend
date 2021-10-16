package com.ciclo3.Reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Car modelo tabla
 *
 * @author Carlos Andres
 */
@Entity
/**
 * Nombre de la tabla
 */
@Table(name = "Car")
public class Car implements Serializable {

    /**
     * Id autoincremental de la tabla
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Id
     */
    private Integer idCar;
    /**
     * Name
     */
    private String name;
    /**
     * Brand
     */
    private String brand;
    /**
     * Year
     */
    private Integer year;
    /**
     * Description
     */
    private String description;

    // Relacion con gama
    @ManyToOne
    @JoinColumn(name = "gammaId")
    @JsonIgnoreProperties("cars")
    /**
     * gama
     */
    private Gama gama;

    //Relacion con Mensajes
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "car")
    @JsonIgnoreProperties({"car", "client"})
    /**
     * messages
     */
    public List<Mensajes> messages;

    //Relacion con reservas
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "car")
    @JsonIgnoreProperties({"car"})
    /**
     * reservations
     */
    public List<Reservas> reservations;

    /**
     * Get lista messages-
     *
     * @return message
     */
    public List<Mensajes> getMessages() {
        return messages;
    }

    /**
     * set message
     *
     * @param messages
     */
    public void setMessages(List<Mensajes> messages) {
        this.messages = messages;
    }

    /**
     * Get lista reservations
     *
     * @return reservations
     */
    public List<Reservas> getReservations() {
        return reservations;
    }

    /**
     * Ser reservations
     *
     * @param reservations
     */
    public void setReservations(List<Reservas> reservations) {
        this.reservations = reservations;
    }

    /**
     * Get id car
     *
     * @return idCar
     */
    public Integer getIdCar() {
        return idCar;
    }

    /**
     * Set idCar
     *
     * @param idCar
     */
    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    /**
     * Get name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get brand
     *
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * set brand
     *
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Get year
     *
     * @return year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Set year
     *
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     * Get description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get gama
     *
     * @return gama
     */
    public Gama getGama() {
        return gama;
    }

    /**
     * Set gama
     *
     * @param gama
     */
    public void setGama(Gama gama) {
        this.gama = gama;
    }

}
