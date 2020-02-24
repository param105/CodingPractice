package com.param.javacode.designpatterns.builder;

/***
 * ## Points to note
 * - object class has only get methods because once object created by Builder then it is immutable.
 * - only builder can create object so constructor is private
 * - Builder class is static so that can be accessed from any other class.
 * - Builder's set methods sets variable and returns self so that we can use same to set another
 *   value like given in example below.
 *
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

    private Employee(String firstName, String middleName,
                     String lastName, String age, String fatherName,
                     String motherName, String height, String weight) {
        this.firstName = firstName;
        this.middlename = middleName;
        this.lastName = lastName;
        this.age = age;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.height = height;
        this.weight = weight;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
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

        /***
         * build method can decide how to create object
         * it can create object using parameterised constructor
         * or
         * it has option to create it with blank constructor and then set values one by one
         * if it is needed to set values in sequential manner
         * @return
         */
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
