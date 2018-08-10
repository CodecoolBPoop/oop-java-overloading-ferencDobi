package com.codecool.uml.overloading;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Date;

public class FeaturedProductCategory extends ProductCategory {
    private Date startDate;
    private Date endDate;

    public void schedule(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        Field[] fields = this.getClass().getSuperclass().getDeclaredFields();
        fields = Arrays.stream(fields).filter(field -> !Modifier.isStatic(field.getModifiers())).toArray(Field[]::new);
        String[] fieldStrings = new String[fields.length];
        int i = 0;
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                fieldStrings[i++] = field.getName() + ":" + field.get(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return getClass().getSimpleName() + ":" + String.join(",", fieldStrings) + "," + super.toString();
    }
}

