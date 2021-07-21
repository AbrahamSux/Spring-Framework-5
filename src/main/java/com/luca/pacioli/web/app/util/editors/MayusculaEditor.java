package com.luca.pacioli.web.app.util.editors;

import java.beans.PropertyEditorSupport;

public class MayusculaEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        // ESTABLECE EL TEXTO A MAYUSCULA Y SIN ESPACIOS VACIOS.
        setValue(text.toUpperCase().trim());
    }
}
