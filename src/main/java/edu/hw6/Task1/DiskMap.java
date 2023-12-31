package edu.hw6.Task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Класс DiskMap реализует интерфейс для хранения пар ключ-значение на жестком диске.
 */
public class DiskMap implements Map<String, String> {
    // Внутренняя структура данных для хранения пар ключ-значение в памяти
    private final HashMap<String, String> map = new HashMap<>();

    /**
     * Конструктор, который загружает данные из файла при создании объекта, если файл существует.
     *
     * @param nameFileRead Имя файла для чтения данных.
     * @throws RuntimeException если файл не найден.
     */
    public DiskMap(String nameFileRead) {
        if (new File(nameFileRead).exists()) {
            readFromFile(nameFileRead);
        } else {
            throw new RuntimeException("file not found");
        }
    }

    /**
     * Пустой конструктор, создает пустой объект DiskMap.
     */
    public DiskMap() {
    }

    // Реализация методов интерфейса Map<String, String>

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return map.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        return map.put(key, value);
    }

    @Override
    public String remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return map.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return map.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return map.entrySet();
    }

    /**
     * Метод для записи данных из объекта в файл на диске.
     *
     * @param name Имя файла для записи данных.
     * @throws RuntimeException если произошла ошибка ввода/вывода.
     */
    public void writeToFile(String name) {
        try (FileWriter writer = new FileWriter(name)) {
            for (String i : map.keySet()) {
                writer.write(String.format("%s:%s\n", i, map.get(i)));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод для чтения данных из файла на диске и загрузки их в объект.
     *
     * @param name Имя файла для чтения данных.
     * @throws RuntimeException если произошла ошибка ввода/вывода.
     */
    private void readFromFile(String name) {
        try (FileInputStream reader = new FileInputStream(name)) {
            StringBuilder sb = new StringBuilder();
            byte[] bytes = reader.readAllBytes();

            char character;
            for (int i = 0; i < bytes.length && bytes[i] > 0; i++) {
                character = (char) bytes[i];
                sb.append(character);
            }

            String[] lines = sb.toString().split("\n");
            for (String i : lines) {
                if (i.isEmpty()) {
                    break;
                }

                String[] m = i.split(":");
                map.put(m[0], m[1]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
