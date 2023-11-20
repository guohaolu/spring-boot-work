package com.stealandfire.support.manager;

import java.util.List;
import java.util.function.Supplier;

public interface IAnimalManager {
    <T> void addAnimal(Supplier<List<T>> producer, Class<? extends T> type);
}
