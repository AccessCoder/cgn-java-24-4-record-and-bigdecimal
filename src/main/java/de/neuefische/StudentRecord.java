package de.neuefische;

public record StudentRecord(String id,
                            String firstname,
                            String lastname,
                            int age)  {

    //Wither
    public StudentRecord withFirstname(String newName){
        return new StudentRecord(id, newName, lastname, age);
    }


}
