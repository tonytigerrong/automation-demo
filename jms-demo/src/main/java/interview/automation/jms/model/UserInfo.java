package interview.automation.jms.model;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Address address;

    public UserInfo() {
    }

    public UserInfo(Long id, String firstName, String lastName, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }

    public static class Address{
        private String street1;
        private String street2;
        private String city;
        private String province;
        private String country;
        private String postCode;

        public Address() {
        }

        public Address(String street1, String street2, String city, String province, String country, String postCode) {
            this.street1 = street1;
            this.street2 = street2;
            this.city = city;
            this.province = province;
            this.country = country;
            this.postCode = postCode;
        }

        public String getStreet1() {
            return street1;
        }

        public void setStreet1(String street1) {
            this.street1 = street1;
        }

        public String getStreet2() {
            return street2;
        }

        public void setStreet2(String street2) {
            this.street2 = street2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street1='" + street1 + '\'' +
                    ", street2='" + street2 + '\'' +
                    ", city='" + city + '\'' +
                    ", province='" + province + '\'' +
                    ", Country='" + country + '\'' +
                    ", postCode='" + postCode + '\'' +
                    '}';
        }
    }
}
