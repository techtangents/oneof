package com.techtangents.oneof.core;

public class Validator {
    public void validateObject(Object o, Class[] clarses) {
        Class clarse = o.getClass();
        validateClass(clarse, clarses);
    }

    public void validateClass(Class clarse, Class[] clarses) {
        if (!isValidClass(clarse, clarses)) kersplode(clarse);
    }

    private boolean isValidClass(Class clarse, Class[] clarses) {
        for (Class c : clarses) if (isValidCast(clarse, c)) return true;
        return false;
    }

    public void validateCast(Object o, Class to) {
        if (!isValidCast(o, to)) kersplode(o.getClass());    
    }

    public boolean isValidCast(Object o, Class to) {
        return isValidCast(o.getClass(), to); 
    }

    public boolean isValidCast(Class from, Class to) {
        // to prevent storing subclasses, change this to .equals
        return to.isAssignableFrom(from);
    }

    private void kersplode(Class clarse) {
        throw new IllegalArgumentException("Illegal class: " + clarse);
    }
}