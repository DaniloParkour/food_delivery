package com.lanches.food_devlivery.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MapperUtil {

  public static <T, O> T mapObject(O obj, Class<T> destinationClass) {

    if(Objects.isNull(obj)) return null;

    try {

      T destinationObject = destinationClass.getDeclaredConstructor().newInstance();

      Field[] sourceFields = obj.getClass().getDeclaredFields();

      for (Field f : sourceFields) {
        String fieldName = f.getName();

        f.setAccessible(true);
        Object fieldValue = f.get(obj);
        Field destinationField = destinationClass.getDeclaredField(fieldName);

        destinationField.setAccessible(true);
        destinationField.set(destinationObject, fieldValue);

      }

      return destinationObject;

    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  private static <T> Constructor<T> getDeclaredConstructor(Class<T> destinationClass) throws NoSuchMethodException {
    return destinationClass.getDeclaredConstructor();
  }

  public static <T, L> List<T> mapList(List<L> list, Class<T> destinationClass) {
    if(Objects.isNull(list) || list.isEmpty()) return Collections.emptyList();
    return list.stream().map(obj -> mapObject(obj, destinationClass)).collect(Collectors.toList());
  }

}
