package com.expedia.hotels.business;

public class Persona
{
    private String personaType;

    public String getPersonaType ()
    {
        return personaType;
    }

    public void setPersonaType (String personaType)
    {
        this.personaType = personaType;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [personaType = "+personaType+"]";
    }
}
	
