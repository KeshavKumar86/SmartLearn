package com.keshav.smartlearn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "review")
@SqlResultSetMapping(
        name="ReviewResult",
        classes={
                @ConstructorResult(
                        targetClass=Review.class,
                        columns={
                                @ColumnResult(name="id", type=Integer.class),
                                @ColumnResult(name="comment", type=String.class)
                        })})
public class Review {

    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "comment")
    private String comment;

    //define constructors
    public Review() {

    }

    public Review(String comment) {
        this.comment = comment;
    }

    public Review(int id, String comment) {
        this.id = id;
        this.comment = comment;
    }
    //define setters/getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    //define toString()

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                '}';
    }
//define mapping with db


}
