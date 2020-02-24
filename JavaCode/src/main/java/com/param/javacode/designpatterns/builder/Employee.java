package com.param.javacode.designpatterns.builder;

/***
 * Class to demonstrate builder pattern
 *
 *          new Employee.Builder()
 *                 .setFirstName("param")
 *                 .setMiddlename("D")
 *                 .setLastName("C")
 *                 .setHeight("165")
 *                 .build();
 */
class Employee {

    private String firstName;
    private String middlename;
    private String lastName;
    private String age;
    private String fatherName;
    private String motherName;
    private String height;
    private String weight;

    private Employee(String firstName, String middlename,
                     String lastName, String age, String fatherName,
                     String motherName, String height, String weight) {
        this.firstName = firstName;
        this.middlename = middlename;
        this.lastName = lastName;
        this.age = age;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.height = height;
        this.weight = weight;
    }


    /***
     * Builder to build Employee class
     */
    public static class Builder{
        private String firstName;
        private String middlename;
        private String lastName;
        private String age;
        private String fatherName;
        private String motherName;
        private String height;
        private String weight;

        public Builder(){}

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setMiddlename(String middlename) {
            this.middlename = middlename;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAge(String age) {
            this.age = age;
            return this;
        }

        public Builder setFatherName(String fatherName) {
            this.fatherName = fatherName;
            return this;
        }

        public Builder setMotherName(String motherName) {
            this.motherName = motherName;
            return this;
        }

        public Builder setHeight(String height) {
            this.height = height;
            return this;
        }

        public Builder setWeight(String weight) {
            this.weight = weight;
            return this;
        }

        public Employee build(){
            return new Employee(firstName,
                    middlename,
                    lastName,
                    age,
                    fatherName,
                    motherName,
                    height,
                    weight);
        }


    }


}
