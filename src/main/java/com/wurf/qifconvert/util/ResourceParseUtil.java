package com.wurf.qifconvert.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharEncoding;

public final class ResourceParseUtil {

    private ResourceParseUtil() {}

    public static List<String> parseResource(final String resource) {
        return parseResource(getResourceAsUrl(resource));
    }

    public static List<String> parseResource(URL url) {
        try {
            return FileUtils.readLines(new File(url.toURI()), CharEncoding.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("error reading resource: " + url, e);
        }
    }

    public static String getResourceAsString(final String resource) {
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
        try {
            return IOUtils.toString(is, CharEncoding.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("resource not found: " + resource);
        }
    }

    public static URL getResourceAsUrl(final String resource) {
        return Thread.currentThread().getContextClassLoader().getResource(resource);
    }

    public static List<List<String>> parseLines(final List<String> lines, final String delimiter) {
        List<List<String>> result = new LinkedList<>();
        List<String> list = new LinkedList<>();
        for (String line : lines) {
            if(delimiter.equals(line)) {
                if(!list.isEmpty()) {
                    result.add(new LinkedList<>(list));
                    list.clear();
                }
                continue;
            }
            list.add(line);
        }
        if(!list.isEmpty()) {
            result.add(new LinkedList<>(list));
        }
        return result;
    }
}
