package edu.hw6.Task3;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

/**
 * Интерфейс AbstractFilter предоставляет статические методы для создания фильтров DirectoryStream
 * Реализации этого интерфейса могут использоваться для фильтрации файлов в директории
 */
public interface AbstractFilter extends DirectoryStream.Filter<Path> {

    /**
     * Возвращает фильтр который пропускает только обычные файлы
     */
    static AbstractFilter regularFile() {
        return Files::isRegularFile;
    }

    /**
     * Возвращает фильтр который пропускает только читаемые файлы
     */
    static AbstractFilter readable() {
        return Files::isReadable;
    }

    /**
     * Возвращает фильтр который пропускает только записываемые файлы
     */
    static AbstractFilter writable() {
        return Files::isWritable;
    }

    /**
     * Возвращает фильтр который пропускает файлы размер которых больше или равен заданному значению
     */
    static AbstractFilter largerThan(long size) {
        return entry -> Files.size(entry) >= size;
    }

    /**
     * Возвращает фильтр который пропускает файлы размер которых меньше или равен заданному значению
     */
    static AbstractFilter smallerThan(long size) {
        return entry -> Files.size(entry) <= size;
    }

    /**
     * Возвращает фильтр который пропускает файлы с указанным расширением
     */
    static AbstractFilter hasExtension(String extension) {
        return entry -> entry.getFileName().toString().endsWith("." + extension);
    }

    /**
     * Возвращает фильтр который пропускает файлы имена которых соответствуют заданному регулярному выражению
     */
    static AbstractFilter nameMatchesRegex(String regex) {
        return entry -> entry.getFileName().toString().matches(regex);
    }

    /**
     * Возвращает фильтр который пропускает файлы с определенными байтами в начале файла
     */
    static AbstractFilter magicNumber(Object... bytes) {
        return entry -> {
            if (Files.isDirectory(entry)) {
                return false;
            }

            byte[] entryBytes = Files.readAllBytes(entry);
            if (entryBytes.length < bytes.length) {
                return false;
            }

            for (int i = 0; i < bytes.length; i++) {
                if (entryBytes[i] != (int) bytes[i]) {
                    return false;
                }
            }
            return true;
        };
    }

    /**
     * Возвращает фильтр который пропускает файлы имена которых соответствуют указанному glob-шаблону
     */
    static AbstractFilter globMatches(String glob) {
        return entry -> entry.getFileName().toString().endsWith(glob);
    }

    /**
     * Возвращает фильтр который пропускает файлы имена которых содержат подстроку соответствующую регулярному выражению
     */
    static AbstractFilter regexContains(String regex) {
        return entry -> Pattern.compile(regex).matcher(entry.toString()).find();
    }

    /**
     * Объединяет текущий фильтр с другим фильтром возвращая новый фильтр который пропускает записи
     * если они проходят оба фильтра
     */
    default AbstractFilter and(AbstractFilter other) {
        return x -> this.accept(x) && other.accept(x);
    }

    /**
     * Объединяет текущий фильтр с другим фильтром возвращая новый фильтр, который пропускает записи
     * если они проходят хотя бы один из фильтров
     */
    default AbstractFilter or(AbstractFilter other) {
        return x -> this.accept(x) || other.accept(x);
    }
}
