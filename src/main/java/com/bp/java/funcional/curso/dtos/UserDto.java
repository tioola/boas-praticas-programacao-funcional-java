package com.bp.java.funcional.curso.dtos;

import com.google.gson.annotations.SerializedName;

public class UserDto {

    private UserData data;

    private UserAd ad;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public UserAd getAd() {
        return ad;
    }

    public void setAd(UserAd ad) {
        this.ad = ad;
    }

    public class UserData {

        private Integer id;

        private String email;




        @SerializedName("first_name")
        private String firstName;

        @SerializedName("last_name")
        private String lastName;

        private String avatar;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        @Override
        public String toString() {
            return "{\"UserData\":{"
                    + "                        \"id\":\"" + id + "\""
                    + ",                         \"email\":\"" + email + "\""
                    + ",                         \"firstName\":\"" + firstName + "\""
                    + ",                         \"lastName\":\"" + lastName + "\""
                    + ",                         \"avatar\":\"" + avatar + "\""
                    + "}}";
        }
    }

    public class UserAd {
        private String company;

        private String url;

        private String text;

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return "{\"UserAd\":{"
                    + "                        \"company\":\"" + company + "\""
                    + ",                         \"url\":\"" + url + "\""
                    + ",                         \"text\":\"" + text + "\""
                    + "}}";
        }
    }
}
