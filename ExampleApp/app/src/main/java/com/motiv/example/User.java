package com.motiv.example;

import androidx.annotation.NonNull;
import androidx.fragment.app.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import io.realm.*;
import java.util.*;
import java.util.concurrent.*;
import javax.inject.*;

public class User extends RealmObject {

    private static final Gson gson = new Gson();
    @NonNull private java.lang.String id = UUID.randomUUID().toString();

    @SerializedName("website")
    private java.lang.String website;

    @SerializedName("address")
    private java.lang.String address;

    @SerializedName("gender")
    private java.lang.String gender;

    @SerializedName("phone")
    private java.lang.String phone;

    @SerializedName("_links")
    private com.motiv.example.Links links;

    @SerializedName("dob")
    private java.lang.String dob;

    @SerializedName("last_name")
    private java.lang.String last_name;

    @SerializedName("first_name")
    private java.lang.String first_name;

    @SerializedName("email")
    private java.lang.String email;

    @SerializedName("status")
    private java.lang.String status;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getWebsite() {

        return this.website;
    }

    public void setWebsite(java.lang.String website) {
        this.website = website;
    }

    public java.lang.String getAddress() {

        return this.address;
    }

    public void setAddress(java.lang.String address) {
        this.address = address;
    }

    public java.lang.String getGender() {

        return this.gender;
    }

    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }

    public java.lang.String getPhone() {

        return this.phone;
    }

    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }

    public com.motiv.example.Links getLinks() {

        return this.links;
    }

    public void setLinks(com.motiv.example.Links links) {
        this.links = links;
    }

    public java.lang.String getDob() {

        return this.dob;
    }

    public void setDob(java.lang.String dob) {
        this.dob = dob;
    }

    public java.lang.String getLast_name() {

        return this.last_name;
    }

    public void setLast_name(java.lang.String last_name) {
        this.last_name = last_name;
    }

    public java.lang.String getFirst_name() {

        return this.first_name;
    }

    public void setFirst_name(java.lang.String first_name) {
        this.first_name = first_name;
    }

    public java.lang.String getEmail() {

        return this.email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getStatus() {

        return this.status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public static User fromJson(String json) {
        return gson.fromJson(json, User.class);
    }

    public static String toJson(User object) {
        return gson.toJson(object, User.class);
    }

    public static String toJsonArray(User[] array) {
        return gson.toJson(array, User[].class);
    }

    public static User[] fromJsonArray(String array) {
        return gson.fromJson(array, User[].class);
    }
}
